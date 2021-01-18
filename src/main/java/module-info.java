module xunito.fatflix {
    requires javafx.controls;
    requires javafx.fxml;

    opens xunito.fatflix to javafx.fxml;
    exports xunito.fatflix;
}