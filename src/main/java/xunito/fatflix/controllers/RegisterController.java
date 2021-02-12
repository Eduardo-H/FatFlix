package xunito.fatflix.controllers;

import xunito.fatflix.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RegisterController {

	@FXML
	private Button loginBtn;
	private Button singUpBtn;
	
	@FXML
	private void singUp() {
		App.changeResizable();
		App.setRoot("main");
	}
	
	@FXML
	private void login() {
		App.setRoot("login");
	}
}
