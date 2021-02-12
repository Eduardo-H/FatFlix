module xunito.fatflix {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens xunito.fatflix to javafx.fxml;
    exports xunito.fatflix;
}