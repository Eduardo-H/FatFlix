package xunito.fatflix;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginController {
	@FXML
	private Button loginBtn;

	
	@FXML
	private void login() {
		try {
			App.setRoot("main");
		} catch (IOException e) {
			System.err.println("Not able to open the main window");
		}
	}
}
