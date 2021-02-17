package xunito.fatflix.controllers;

import javafx.fxml.FXML;
import xunito.fatflix.App;

public class TvShowController {
	
	
	@FXML
    private void logout() {
    	App.changeResizable();
    	App.setRoot("login");
    }
	
	@FXML
	public void openHomeScreen() {
		App.setRoot("main");
	}
	
	@FXML
	public void openMoviesScreen() {
		App.setRoot("movies");
	}
}
