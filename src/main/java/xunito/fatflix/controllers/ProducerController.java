package xunito.fatflix.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import xunito.fatflix.AlertUtil;
import xunito.fatflix.App;

public class ProducerController {

	@FXML
	private ListView<String> producersList;
	
	
	@FXML
	public void addProducer() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("producerRegister.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) producersList.getScene().getWindow();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the producer registration window.", e);
			alert.showAndWait();
			return;
		}
	}
	
	@FXML
    private void logout() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) producersList.getScene().getWindow();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the login window.", e);
			alert.showAndWait();
			return;
		}
    }
	
	@FXML
	public void openHomeWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) producersList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the home window.", e);
			alert.showAndWait();
			return;
		}
	}
	
	@FXML
	public void openMoviesWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("movies.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) producersList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the movies window.", e);
			alert.showAndWait();
			return;
		}
	}
	
	@FXML
	public void openTVShowsWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("tvShows.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) producersList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the TV Shows window.", e);
			alert.showAndWait();
			return;
		}
	}
	
	@FXML
    public void openDirectorsWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("directors.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) producersList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the directors window.", e);
			alert.showAndWait();
			return;
		}
    }
	
	@FXML
	public void openActorsWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actors.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) producersList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the actors window.", e);
			alert.showAndWait();
			return;
		}
	}
	
}
