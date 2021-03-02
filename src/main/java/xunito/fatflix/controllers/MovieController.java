package xunito.fatflix.controllers;

import xunito.fatflix.App;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class MovieController {

	@FXML
	private ImageView logo;
	
	
	@FXML
	public void addMovie() {
		App.setRoot("movieRegister");
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
	public void openTVShowsWindow() {
		App.setRoot("tvShows");
	}
	
	@FXML
    public void openDirectorsWindow() {
    	App.setRoot("directors");
    }
	
	@FXML
    public void openActorsWindow() {
    	App.setRoot("actors");
    }
}
