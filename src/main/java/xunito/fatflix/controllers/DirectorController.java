package xunito.fatflix.controllers;

import javafx.fxml.FXML;
import xunito.fatflix.App;

public class DirectorController {
	
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
