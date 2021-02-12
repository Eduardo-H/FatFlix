package xunito.fatflix.controllers;

import xunito.fatflix.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    private void logout() {
    	App.changeResizable();
    	App.setRoot("main");
    }
}
