module xunito.fatflix {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires java.persistence;

    opens xunito.fatflix.controllers to javafx.fxml;
    exports xunito.fatflix;
}