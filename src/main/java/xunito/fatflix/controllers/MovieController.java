package xunito.fatflix.controllers;

import xunito.fatflix.App;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class MovieController {

	@FXML
	private ImageView logo;
	
	@FXML
	public void openHomeScreen() {
		App.setRoot("main");
	}
	
	@FXML
	public void registerMovie() {
		App.setRoot("movieRegister");
	}
	
}
