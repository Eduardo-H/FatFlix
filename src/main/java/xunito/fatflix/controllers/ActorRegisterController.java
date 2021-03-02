package xunito.fatflix.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import xunito.fatflix.AlertUtil;
import xunito.fatflix.App;
import xunito.fatflix.db.ActorDAO;
import xunito.fatflix.entities.Actor;

public class ActorRegisterController {
	@FXML
	private TextField nameTxt;
	@FXML
	private TextField birthDateTxt;
	@FXML
	private TextField nationalityTxt;
	@FXML
	private TextField heightTxt;
	@FXML
	private RadioButton maleRadio;
	@FXML
	private RadioButton femaleRadio;
	
	
	@FXML
	public void save() {
		String name = nameTxt.getText();
		String birthDate = birthDateTxt.getText();
		String nationality = nationalityTxt.getText();
		String height = heightTxt.getText();
		
		if (name.isBlank()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Type the actor's name.", null);
			alert.showAndWait();
			return;
		}
		
		if (birthDate.isBlank()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Type the actor's birth date.", null);
			alert.showAndWait();
			return;
		}
		
		if (nationality.isBlank()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Type the actor's nationality.", null);
			alert.showAndWait();
			return;
		}
		
		if (height.isBlank()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Type the actor's height.", null);
			alert.showAndWait();
			return;
		}
		
		// Trying to format height to float
		float transformedHeight = 0;
		height = height.replace(",", ".");
		
		try {
			transformedHeight = Float.parseFloat(height);
		} catch (NumberFormatException e) {
			Alert alert = AlertUtil.error("Error!", "Invalid height formtat.", "Inable to convert the informed value into a float number.", e);
			alert.showAndWait();
			return;
		}
		
		
		if (!maleRadio.isSelected() && !femaleRadio.isSelected()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Select the actor's sex.", null);
			alert.showAndWait();
			return;
		}
		
		String sex;
		
		if (maleRadio.isSelected()) {
			sex = maleRadio.getText();
		} else {
			sex = femaleRadio.getText();
		}
		
		new ActorDAO().persist(new Actor(name, birthDate, nationality, sex, transformedHeight));
		
		Alert alert = AlertUtil.info("Success!", "Operation successfully completed", "Actor saved in the database.");
		alert.show();
		
		App.changeResizable();
		App.setRoot("actors");
	}
	
	public void handleMaleRadioClick() {
		femaleRadio.setSelected(false);
	}
	
	public void handleFemaleRadioClick() {
		maleRadio.setSelected(false);
	}

	public void cancel() {
		App.changeResizable();
		App.setRoot("actors");
	}
}
