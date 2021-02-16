package xunito.fatflix.controllers;

import javafx.fxml.FXML;
import xunito.fatflix.App;

public class MovieRegisterController {

	@FXML
	public void openMoviesScreen() {
		App.setRoot("movies");
	}
	
	@FXML
	public void openHomeScreen() {
		App.setRoot("main");
	}
	
}
