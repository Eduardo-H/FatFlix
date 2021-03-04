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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import xunito.fatflix.AlertUtil;
import xunito.fatflix.App;
import xunito.fatflix.db.MovieDAO;
import xunito.fatflix.entities.Actor;
import xunito.fatflix.entities.Director;
import xunito.fatflix.entities.Movie;
import xunito.fatflix.entities.Producer;

public class MovieRegisterController implements Initializable {

	@FXML
	private TextField titleTxt;
	@FXML
	private TextField releaseYearTxt;
	@FXML
	private TextField lengthTxt;
	
	@FXML
	private ListView<String> directorsList;
	@FXML
	private ListView<String> actorsList;
	@FXML
	private ListView<String> producersList;
	@FXML
	private Button removeDirectorBtn;
	@FXML
	private Button removeActorBtn;
	@FXML
	private Button removeProducerBtn;
	
	private List<Director> directors;
	private List<Actor> actors;
	private List<Producer> producers;
	
	private int movieId; 
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		removeDirectorBtn.setVisible(false);
		removeActorBtn.setVisible(false);
		removeProducerBtn.setVisible(false);
		
		directors = new ArrayList<Director>();
		actors = new ArrayList<Actor>();
		producers = new ArrayList<Producer>();
	}
	
	@FXML
	public void save() {
		String title = titleTxt.getText();
		String release = releaseYearTxt.getText();
		String length = lengthTxt.getText();
		
		if (title.isBlank()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Type the movie's title.", null);
			alert.showAndWait();
			return;
		}
		
		if (release.isBlank()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Type the movie's year of release.", null);
			alert.showAndWait();
			return;
		}
		
		int transformedRelease = 0;
		
		try {
			transformedRelease = Integer.parseInt(release);
		} catch (NumberFormatException e) {
			Alert alert = AlertUtil.error("Error!", "Invalid height formtat.", "Inable to convert the informed value into a integer number.", e);
			alert.showAndWait();
			return;
		}
		
		if (length.isBlank()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Type the movie's lenght.", null);
			alert.showAndWait();
			return;
		}
		
		if (directors.size() < 1) {
			Alert alert = AlertUtil.error("Error!", "Error!", "You need at least one director, please select one.", null);
			alert.showAndWait();
			return;
		}
		
		if (actors.size() < 1) {
			Alert alert = AlertUtil.error("Error!", "Error!", "You need at least one actor, please select one.", null);
			alert.showAndWait();
			return;
		}

		if (producers.size() < 1) {
			Alert alert = AlertUtil.error("Error!", "Error!", "You need at least one producer, please select one.", null);
			alert.showAndWait();
			return;
		}
		
		Movie movie = new Movie(title, transformedRelease, length, directors, actors, producers);
		
		if (movieId > 0)
			movie.setId(movieId);
		
		new MovieDAO().persist(movie);
		
		Alert alert = AlertUtil.info("Success!", "Operation successfully completed", "Movie saved in the database.");
		alert.show();
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("movies.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) titleTxt.getScene().getWindow();
			stage.setResizable(true);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the movies window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	public void addDirector() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("directorSelection.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
			
			DirectorSelectionController controller = fxmlLoader.getController();
			controller.setController(this);
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the directors window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	public void removeDirector() {
		if (directorsList.getSelectionModel().selectedItemProperty().getValue() != null) {
			directors.remove(directorsList.getSelectionModel().getSelectedIndex());
			updateDirectorsList();
			removeDirectorBtn.setVisible(false);
		}
	}
	
	public void addActor() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actorSelection.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
			
			ActorSelectionController controller = fxmlLoader.getController();
			controller.setController(this);
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the actors window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	public void removeActor() {
		if (actorsList.getSelectionModel().selectedItemProperty().getValue() != null) {
			actors.remove(actorsList.getSelectionModel().getSelectedIndex());
			updateActorsList();
			removeActorBtn.setVisible(false);
		}
	}
	
	public void addProducer() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("producerSelection.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
			
			ProducerSelectionController controller = fxmlLoader.getController();
			controller.setController(this);
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the producers window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	public void removeProducer() {
		if (producersList.getSelectionModel().selectedItemProperty().getValue() != null) {
			producers.remove(producersList.getSelectionModel().getSelectedIndex());
			updateProducersList();
			removeProducerBtn.setVisible(false);
		}
	}
	
	public void handleDirectorListClick() {
		if (directorsList.getSelectionModel().selectedItemProperty().getValue() != null) {
			removeDirectorBtn.setVisible(true);
		} else {
			removeDirectorBtn.setVisible(false);
		}
	}
	
	public void handleActorListClick() {
		if (actorsList.getSelectionModel().selectedItemProperty().getValue() != null) {
			removeActorBtn.setVisible(true);
		} else {
			removeActorBtn.setVisible(false);
		}
	}
	
	public void handleProducerListClick() {
		if (producersList.getSelectionModel().selectedItemProperty().getValue() != null) {
			removeProducerBtn.setVisible(true);
		} else {
			removeProducerBtn.setVisible(false);
		}
	}
	
	@FXML
	public void cancel() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("movies.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) titleTxt.getScene().getWindow();
			stage.setResizable(true);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the movies window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	
	// Setters
	public void setDirector(Director director) {
		directors.add(director);
		updateDirectorsList();
	}
	
	public void updateDirectorsList() {
		directorsList.setItems(null);
		ArrayList<String> names = new ArrayList<String>();
		
		for (Director director : directors) {
			names.add(director.getName());
		}
		
		directorsList.setItems(FXCollections.observableArrayList(names));
	}
	
	public void setActor(Actor actor) {
		actors.add(actor);
		updateActorsList();
	}
	
	public void updateActorsList() {
		actorsList.setItems(null);
		ArrayList<String> names = new ArrayList<String>();
		
		for (Actor actor : actors) {
			names.add(actor.getName());
		}
		
		actorsList.setItems(FXCollections.observableArrayList(names));
	}
	
	public void setProducer(Producer producer) {
		producers.add(producer);
		updateProducersList();
	}
	
	public void updateProducersList() {
		producersList.setItems(null);
		ArrayList<String> names = new ArrayList<String>();
		
		for (Producer producer : producers) {
			names.add(producer.getName());
		}
		
		producersList.setItems(FXCollections.observableArrayList(names));
	}
	
	public void setMovieId(int id) {
		this.movieId = id;
		setFields();
	}
	
	public void setFields() {
		if (movieId > 0) {
			Movie movie = new MovieDAO().get(movieId);
			
			titleTxt.setText(movie.getTitle());
			releaseYearTxt.setText(Integer.toString(movie.getReleaseYear()));
			lengthTxt.setText(movie.getLength());
			
			ArrayList<String> directorsNames = new ArrayList<String>();
			ArrayList<String> actorsNames = new ArrayList<String>();
			ArrayList<String> producersNames = new ArrayList<String>();
			
			for (Director director : movie.getDirectors()) {
				directorsNames.add(director.getName());
				directors.add(director);
			}
			
			directorsList.setItems(FXCollections.observableArrayList(directorsNames));
			
			for (Actor actor : movie.getActors()) {
				actorsNames.add(actor.getName());
				actors.add(actor);
			}
			
			actorsList.setItems(FXCollections.observableArrayList(actorsNames));
			
			for (Producer producer : movie.getProducers()) {
				producersNames.add(producer.getName());
				producers.add(producer);
			}
			
			producersList.setItems(FXCollections.observableArrayList(producersNames));
		}
	}
}
