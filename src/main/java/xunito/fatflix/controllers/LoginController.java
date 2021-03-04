package xunito.fatflix.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import xunito.fatflix.AlertUtil;
import xunito.fatflix.App;
import xunito.fatflix.db.UserDAO;
import xunito.fatflix.entities.User;

public class LoginController {
	
	@FXML
	private TextField usernameTxt;
	@FXML
	private PasswordField passwordTxt;
	@FXML
	private Button loginBtn;
	@FXML
	private Button singUpBtn;
	@FXML
	private ImageView logo;
	
	@FXML
	private void login() {
		String username = usernameTxt.getText();
		String password = passwordTxt.getText();
		
		if (username.isBlank()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Type your username.", null);
			alert.showAndWait();
			return;
		}
		
		if (password.isBlank()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Type your password.", null);
			alert.showAndWait();
			return;
		}
		
		User user = new UserDAO().get(username);
		
		if (user != null && password.contentEquals(user.getPassword())) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main.fxml"));
				Scene scene = new Scene(fxmlLoader.load());
				Stage stage = (Stage) loginBtn.getScene().getWindow();
				stage.setResizable(true);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the main window.", e);
				errorAlert.showAndWait();
				return;
			}
		} else {
			Alert alert = AlertUtil.error("Error!", "Error!", "Username or password is invalid.", null);
			alert.showAndWait();
			return;
		}
	}
	
	@FXML
	private void singUp() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("singUp.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) loginBtn.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the sing up window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
}
