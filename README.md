1. Wejdź [tu](https://gluonhq.com/download/javafx-11-0-2-sdk-windows/)
2. Rozpakuj archiwum do `C:\Program Files\Java\`
3. W `Run configuration` w IntelliJ ustaw `VM Options` na  
```--module-path "C:\Program Files\Java\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml```

Zadanie:

Stwórz aplikację symulującą rzucanie kostką.
1. Po naciśnięciu przycisku "Rzuć!" w Label ma się wyświetlać losowa liczba w Labelce.
2. Wynik rzutu powinien się odkładać do bazy (wszyscy będziemy korzystali z jednej BD, podam dane).
Pojedynczy wiersz ma składać się z:
identyfikatora, daty rzutu, wyniku rzutu 
3. Dodaj na górze okna Labelkę pokazujacą ile zostało wykonanych rzutów dotychczas (jest ustawiana podczas startu aplikacji)
4. Dodaj na górze obok tej labelki przycisk służący do odświeżenia tej wartości
5. Dodaj przycisk umożliwiający wyliczenie średniej ze wszystkich rekordów w bazie danych - średnia ma się pojawiać w oknie dialogowym
Jak wyświetlać dialogi znajdziesz [tutaj](https://code.makery.ch/blog/javafx-dialogs-official/)

> wyjątkowo dozwolone jest używanie EntityManager bezpośrednio bez warstwy serwisowej czy dao
