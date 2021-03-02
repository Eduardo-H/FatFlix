package xunito.fatflix.controllers;

import xunito.fatflix.AlertUtil;
import xunito.fatflix.App;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private Button loginBtn;
	@FXML
	private Button singUpBtn;
	@FXML
	private ImageView logo;
	
	@FXML
	private void login() {
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
