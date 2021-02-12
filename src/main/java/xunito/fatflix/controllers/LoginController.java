package xunito.fatflix.controllers;

import xunito.fatflix.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginController {
	@FXML
	private Button loginBtn;
	@FXML
	private Button singUpBtn;
	
	@FXML
	private void login() {
		App.changeResizable();
		App.setRoot("main");
	}
	
	@FXML
	private void singUp() {
		App.setRoot("register");
	}
}
