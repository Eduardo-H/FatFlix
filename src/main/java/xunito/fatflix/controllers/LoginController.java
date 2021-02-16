package xunito.fatflix.controllers;

import xunito.fatflix.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class LoginController {
	@FXML
	private Button loginBtn;
	@FXML
	private Button singUpBtn;
	@FXML
	private ImageView logo;
	
	@FXML
	private void login() {
		App.changeResizable();
		App.setRoot("main");
	}
	
	@FXML
	private void singUp() {
		App.setRoot("singUp");
	}
}
