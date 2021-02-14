package xunito.fatflix.controllers;

import xunito.fatflix.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class MovieController {

	@FXML
	public void openHomeScreen() {
		App.setRoot("main");
	}
	
	@FXML
	public void registerMovie() {
		App.setRoot("registerMovie");
	}
	
}
