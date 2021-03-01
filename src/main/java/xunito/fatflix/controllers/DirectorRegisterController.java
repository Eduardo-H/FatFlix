package xunito.fatflix.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import xunito.fatflix.AlertUtil;
import xunito.fatflix.App;
import xunito.fatflix.db.DirectorDAO;
import xunito.fatflix.entities.Director;

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
	
	
	@FXML
	public void save() {
		String name = nameTxt.getText();
		String birthDate = birthDateTxt.getText();
		String nationality = nationalityTxt.getText();
		
		if (name.isBlank()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Type the director's name.", null);
			alert.showAndWait();
			return;
		}
		
		if (birthDate.isBlank()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Type the director's birth date.", null);
			alert.showAndWait();
			return;
		}
		
		if (nationality.isBlank()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Type the director's nationality.", null);
			alert.showAndWait();
			return;
		}
		
		if (!maleRadio.isSelected() && !femaleRadio.isSelected()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Select the director's sex.", null);
			alert.showAndWait();
			return;
		}
		
		String sex;
		
		if (maleRadio.isSelected()) {
			sex = maleRadio.getText();
		} else {
			sex = femaleRadio.getText();
		}
		
		new DirectorDAO().persist(new Director(name, birthDate, nationality, sex));
		
		App.setRoot("directors");
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
