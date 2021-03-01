package xunito.fatflix.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import xunito.fatflix.App;

public class DirectorRegisterController {
	
	@FXML
	private TextField nameTxt;
	@FXML
	private TextField birthDateTxt;
	@FXML
	private TextField nationalityTxt;
	@FXML
	private RadioButton maleRadio;
	@FXML
	private RadioButton femaleRadio;
	
	
	public void save() {
		
	}
	
	public void handleMaleRadioClick() {
		femaleRadio.setSelected(false);
	}
	
	public void handleFemaleRadioClick() {
		maleRadio.setSelected(false);
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
	public void openDirectorWindow() {
		App.setRoot("directors");
	}
}
