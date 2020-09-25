package pl.sda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import pl.sda.view.DiceController;


public class Main extends Application {
    private static Main application;
    private Stage diceStage;
    private Stage currentStage;
    private DiceController diceController;

    @Override
    public void start(Stage stage) throws Exception {
        stage.close();
        application = this;
        FXMLLoader diceStageLoader = new FXMLLoader(getClass().getClassLoader().getResource("dice.fxml"));
        this.diceStage = diceStageLoader.load();
        this.diceController = diceStageLoader.getController();
        diceStage.show();
        currentStage = diceStage;
    }

    public static Main getApplication() {
        return application;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
