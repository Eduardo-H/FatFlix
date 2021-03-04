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

public class SingUpController {

	@FXML
	private TextField usernameTxt;
	@FXML
	private PasswordField passwordTxt;
	@FXML
	private PasswordField confirmPasswordTxt;
	@FXML
	private Button loginBtn;
	@FXML
	private Button singUpBtn;
	@FXML
	private ImageView logo;
	
	@FXML
	private void singUp() {
		String username = usernameTxt.getText();
		String password = passwordTxt.getText();
		String confirmPassword = confirmPasswordTxt.getText();
		
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
		
		if (confirmPassword.isBlank()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Confirm your password.", null);
			alert.showAndWait();
			return;
		}
		
		if (!password.contentEquals(confirmPassword)) {
			Alert alert = AlertUtil.error("Error!", "Error!", "The passwords don't match.", null);
			alert.showAndWait();
			return;
		}
		
		User user = new UserDAO().get(username);
		
		if (user == null) {
			new UserDAO().persist(new User(username, password));
			
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
				Scene scene = new Scene(fxmlLoader.load());
				Stage stage = (Stage) logo.getScene().getWindow();
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the login window.", e);
				errorAlert.showAndWait();
				return;
			}
		} else {
			Alert alert = AlertUtil.error("Error!", "Error!", "Username already exists.", null);
			alert.showAndWait();
			return;
		}
	}
	
	@FXML
	private void login() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) logo.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the login window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
}
