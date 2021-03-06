package xunito.fatflix.controllers;

import xunito.fatflix.AlertUtil;
import xunito.fatflix.App;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainController {

	@FXML
	private ImageView logo;
	
    @FXML
    private void logout() {
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) logo.getScene().getWindow();
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the login window.", e);
			errorAlert.showAndWait();
			return;
		}
    }
    
    @FXML
	public void openMoviesWindow() {
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("movies.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) logo.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the movies window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
    
    @FXML
	public void openTVShowsWindow() {
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("tvShows.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) logo.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the TV Shows window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
    
    @FXML
    public void openDirectorsWindow() {
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("directors.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) logo.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the directors window.", e);
			errorAlert.showAndWait();
			return;
		}
    }
    
    @FXML
    public void openActorsWindow() {
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actors.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) logo.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the actors window.", e);
			errorAlert.showAndWait();
			return;
		}
    }
    
    @FXML
	public void openProducersWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("producers.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) logo.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the producers window.", e);
			alert.showAndWait();
			return;
		}
	}
}
