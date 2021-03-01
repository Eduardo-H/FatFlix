package xunito.fatflix.controllers;

import xunito.fatflix.App;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class MovieController {

	@FXML
	private ImageView logo;
	
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
	public void openTVShowsScreen() {
		App.setRoot("tvShows");
	}
	
	@FXML
	public void registerMovie() {
		App.setRoot("movieRegister");
	}
	
	@FXML
    public void openDirectorsWindow() {
    	App.setRoot("directors");
    }
}
