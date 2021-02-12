package xunito.fatflix;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RegisterController {

	@FXML
	private Button loginBtn;
	private Button singUpBtn;
	
	@FXML
	private void singUp() {
		try {
			App.setRoot("main");
		} catch (IOException e) {
			System.err.println("Not able to open the main window");
		}
	}
	
	@FXML
	private void login() {
		try {
			App.setRoot("login");
		} catch (IOException e) {
			System.err.println("Not able to open the login window");
		}
	}
}
