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
import xunito.fatflix.db.ActorDAO;
import xunito.fatflix.entities.Actor;

public class ActorController implements Initializable {

	@FXML
	private ListView<String> actorsList;
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getAllActors();
	}
	
	public void getAllActors() {
		List<String> actors = new ArrayList<>();
		
		for (Actor actor : new ActorDAO().getAll())
			actors.add(actor.getName());
		
		actorsList.setItems(FXCollections.observableArrayList(actors));
	}
	
	@FXML
	public void addActor() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actorRegister.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) actorsList.getScene().getWindow();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the actor registration window.", e);
			alert.showAndWait();
			return;
		}
	}
	
	@FXML
    private void logout() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) actorsList.getScene().getWindow();
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
			Stage stage = (Stage) actorsList.getScene().getWindow();
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
			Stage stage = (Stage) actorsList.getScene().getWindow();
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
			Stage stage = (Stage) actorsList.getScene().getWindow();
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
			Stage stage = (Stage) actorsList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the directors window.", e);
			alert.showAndWait();
			return;
		}
    }

}
