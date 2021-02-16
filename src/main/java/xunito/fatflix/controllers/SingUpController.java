package xunito.fatflix.controllers;

import xunito.fatflix.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class SingUpController {

	@FXML
	private Button loginBtn;
	@FXML
	private Button singUpBtn;
	@FXML
	private ImageView logo;
	
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
