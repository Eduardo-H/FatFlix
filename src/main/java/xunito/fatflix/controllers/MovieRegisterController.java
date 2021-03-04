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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import xunito.fatflix.AlertUtil;
import xunito.fatflix.App;
import xunito.fatflix.entities.Actor;
import xunito.fatflix.entities.Director;
import xunito.fatflix.entities.Producer;

public class MovieRegisterController implements Initializable {

	@FXML
	private TextField titleTxt;
	@FXML
	private TextField releaseYearTxt;
	@FXML
	private TextField lenghtTxt;
	
	@FXML
	private ListView directorsList;
	@FXML
	private ListView actorsList;
	@FXML
	private ListView producersList;
	@FXML
	private Button removeDirectorBtn;
	@FXML
	private Button removeActorBtn;
	@FXML
	private Button removeProducerBtn;
	
	private ArrayList<Director> directors;
	private ArrayList<Actor> actors;
	private ArrayList<Producer> producers;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		removeDirectorBtn.setVisible(false);
		removeActorBtn.setVisible(false);
		removeProducerBtn.setVisible(false);
		
		directors = new ArrayList();
		actors = new ArrayList();
		producers = new ArrayList();
	}
	
	@FXML
	public void save() {
		
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
		
	}
	
	public void addActor() {
		
	}
	
	public void removeActor() {
		
	}
	
	public void addProducer() {
		
	}
	
	public void removeProducer() {
		
	}
	
	public void handleDirectorListClick() {
		
	}
	
	public void handleActorListClick() {
			
	}
	
	public void handleProducerListClick() {
		
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
		ArrayList<String> names = new ArrayList();
		
		for (Director director : directors) {
			names.add(director.getName());
		}
		
		directorsList.setItems(FXCollections.observableArrayList(names));
	}
}
