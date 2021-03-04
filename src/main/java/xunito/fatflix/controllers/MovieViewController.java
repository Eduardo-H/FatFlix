package xunito.fatflix.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import xunito.fatflix.AlertUtil;
import xunito.fatflix.App;
import xunito.fatflix.db.MovieDAO;
import xunito.fatflix.entities.Actor;
import xunito.fatflix.entities.Director;
import xunito.fatflix.entities.Movie;
import xunito.fatflix.entities.Producer;

public class MovieViewController implements Initializable {

	@FXML
	private Label titleLbl;
	@FXML
	private Label releaseLbl;
	@FXML
	private Label lengthLbl;
	@FXML
	private ListView<String> directorsList;
	@FXML
	private ListView<String> actorsList;
	@FXML
	private ListView<String> producersList;
	
	private Movie movie;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO
	}
	
	@FXML
	public void back() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("movies.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) titleLbl.getScene().getWindow();
			stage.setResizable(true);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the movies window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	public void delete() {
		new MovieDAO().remove(movie);
		
		Alert alert = AlertUtil.info("Success!", "Operation successfully completed", "Movie deleted from the database.");
		alert.show();
	
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("movies.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) titleLbl.getScene().getWindow();
			stage.setResizable(true);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the movies window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	@FXML
	public void edit() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("movieRegister.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) titleLbl.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
			
			MovieRegisterController controller = fxmlLoader.getController();
			controller.setMovieId(movie.getId());
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the movie registration window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
		setFields();
	}
	
	public void setFields() {
		titleLbl.setText(movie.getTitle());
		releaseLbl.setText(Integer.toString(movie.getReleaseYear()));
		lengthLbl.setText(movie.getLength());
		
		ArrayList<String> directors = new ArrayList<String>();
		ArrayList<String> actors = new ArrayList<String>();
		ArrayList<String> producers = new ArrayList<String>();
		
		for (Director director : movie.getDirectors()) {
			directors.add(director.getName());
		}
		
		directorsList.setItems(FXCollections.observableArrayList(directors));
		
		for (Actor actor : movie.getActors()) {
			actors.add(actor.getName());
		}
		
		actorsList.setItems(FXCollections.observableArrayList(actors));
		
		for (Producer producer : movie.getProducers()) {
			producers.add(producer.getName());
		}
		
		producersList.setItems(FXCollections.observableArrayList(producers));
	}
}
