package pl.sda.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import pl.sda.model.ThrowResultEntity;
import pl.sda.util.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Random;

public class DiceController {
    public Label throwResultLabel;
    public Label throwCountLabel;

    public void initialize() {
        setCountOfThrows();
    }

    private void setCountOfThrows() {
        EntityManager entityManager = EntityManagerUtil.get();
        Long count = entityManager.createQuery("SELECT COUNT(id) FROM ThrowResultEntity", Long.class).getSingleResult();


        throwCountLabel.setText(count + "");
    }

    public void throwBtnAction() {
        EntityManager entityManager = EntityManagerUtil.get();
        Random random = new Random();
        int throwResult = random.nextInt(6) + 1;

        ThrowResultEntity resultToSave = new ThrowResultEntity();
        resultToSave.setCreated(LocalDateTime.now());
        resultToSave.setResult(throwResult);

        entityManager.getTransaction().begin();
        entityManager.persist(resultToSave);
        entityManager.getTransaction().commit();

        entityManager.close();
        throwResultLabel.setText(throwResult + "");
    }

    public void refreshThrowCount() {
        setCountOfThrows();
    }

    public void countAvgBtnAction() {
        EntityManager entityManager = EntityManagerUtil.get();
        Double avg = entityManager.createQuery("SELECT AVG(result) FROM ThrowResultEntity", Double.class).getSingleResult();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Wyliczona srednia");
        alert.setHeaderText(null);
        alert.setContentText("Wyliczona srednia to: " + avg);
        alert.show();
    }
}
