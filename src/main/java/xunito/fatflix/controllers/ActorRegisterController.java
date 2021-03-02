package xunito.fatflix.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
	
	private int actorId;
	
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
		
		Actor actor = new Actor(name, birthDate, nationality, sex, transformedHeight);
		
		if (actorId > 0) {
			actor.setId(actorId);
		}
		
		new ActorDAO().persist(actor);
		
		Alert alert = AlertUtil.info("Success!", "Operation successfully completed", "Actor saved in the database.");
		alert.show();
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actors.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) nameTxt.getScene().getWindow();
			stage.setResizable(true);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the actor registration window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	@FXML
	public void cancel() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actors.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) nameTxt.getScene().getWindow();
			stage.setResizable(true);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the actor registration window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	public void handleMaleRadioClick() {
		femaleRadio.setSelected(false);
	}
	
	public void handleFemaleRadioClick() {
		maleRadio.setSelected(false);
	}
	
	public void setActorId(int id) {
		this.actorId = id;
	}
}
