module xunito.fatflix {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens xunito.fatflix.controllers to javafx.fxml;
    exports xunito.fatflix;
}