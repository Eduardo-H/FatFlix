package xunito.fatflix.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import xunito.fatflix.AlertUtil;
import xunito.fatflix.App;
import xunito.fatflix.db.DirectorDAO;
import xunito.fatflix.entities.Director;

public class DirectorController implements Initializable {
	
	@FXML
	private ListView<String> directorsList;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getAllDirectors();
	}
	
	public void getAllDirectors() {
		List<String> directors = new ArrayList<>();
		
		for (Director director : new DirectorDAO().getAll())
			directors.add(director.getName());
		
		directorsList.setItems(FXCollections.observableArrayList(directors));
	}
	
	@FXML
	public void addDirector() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("directorRegister.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) directorsList.getScene().getWindow();
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
			
			DirectorRegisterController controller = fxmlLoader.getController();
			controller.setDirectorId(0);
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the director registration window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	@FXML
    private void logout() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) directorsList.getScene().getWindow();
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
	public void openHomeWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) directorsList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the home window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	@FXML
	public void openMoviesWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("movies.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) directorsList.getScene().getWindow();
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
			Stage stage = (Stage) directorsList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the TV Shows window.", e);
			errorAlert.showAndWait();
			return;
		}
	}

	@FXML
	public void openActorsWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actors.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) directorsList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the actors window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
}
