package xunito.fatflix.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import xunito.fatflix.AlertUtil;
import xunito.fatflix.App;
import xunito.fatflix.db.ActorDAO;
import xunito.fatflix.entities.Actor;

public class ActorViewController {

	@FXML
	private Label nameLbl;
	@FXML
	private Label birthDateLbl;
	@FXML
	private Label nationalityLbl;
	@FXML
	private Label sexLbl;
	@FXML
	private Label heightLbl;
	
	private Actor actor;
	
	@FXML
	public void back() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actors.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) nameLbl.getScene().getWindow();
			stage.setResizable(true);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the actors window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	@FXML
	public void delete() {
		new ActorDAO().remove(actor);
		
		Alert alert = AlertUtil.info("Success!", "Operation successfully completed", "Actor deleted from the database.");
		alert.show();
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actors.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) nameLbl.getScene().getWindow();
			stage.setResizable(true);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the actors window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	@FXML
	public void edit() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actorRegister.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) nameLbl.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
			
			ActorRegisterController controller = fxmlLoader.getController();
			controller.setActorId(actor.getId());
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the actors registration window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	public void setActor(Actor actor) {
		this.actor = actor;
		setFields();
	}
	
	public void setFields() {
		nameLbl.setText(actor.getName());
		birthDateLbl.setText(actor.getBirthDate());
		nationalityLbl.setText(actor.getNationality());
		sexLbl.setText(actor.getSex());
		heightLbl.setText(Float.toString(actor.getHeight()));
	}
	
}
