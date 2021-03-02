package xunito.fatflix.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
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
		App.changeResizable();
    	App.setRoot("actorRegister");
	}
	
	@FXML
    private void logout() {
    	App.changeResizable();
    	App.setRoot("login");
    }
	
	@FXML
	public void openHomeWindow() {
		App.setRoot("main");
	}
	
	@FXML
	public void openMoviesWindow() {
		App.setRoot("movies");
	}
	
	@FXML
	public void openTVShowsWindow() {
		App.setRoot("tvShows");
	}
	
	@FXML
    public void openDirectorsWindow() {
    	App.setRoot("directors");
    }
	
}
