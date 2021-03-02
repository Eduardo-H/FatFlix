package xunito.fatflix.controllers;

import javafx.fxml.FXML;
import xunito.fatflix.App;

public class ActorController {

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
