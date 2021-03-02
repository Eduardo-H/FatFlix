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
	public void openDirectorRegistration() {
		App.changeResizable();
		App.setRoot("directorRegister");
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

}
