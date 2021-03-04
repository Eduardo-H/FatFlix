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
import xunito.fatflix.db.DirectorDAO;
import xunito.fatflix.entities.Director;

public class DirectorViewController {

	@FXML
	private Label nameLbl;
	@FXML
	private Label birthDateLbl;
	@FXML
	private Label nationalityLbl;
	@FXML
	private Label sexLbl;
	
	private Director director;
	
	
	@FXML
	public void back() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("directors.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) nameLbl.getScene().getWindow();
			stage.setResizable(true);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the directors window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	@FXML
	public void delete() {
		new DirectorDAO().remove(director);
		
		Alert alert = AlertUtil.info("Success!", "Operation successfully completed", "Director deleted from the database.");
		alert.show();
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("directors.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) nameLbl.getScene().getWindow();
			stage.setResizable(true);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the directors window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	@FXML
	public void edit() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("directorRegister.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) nameLbl.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
			
			DirectorRegisterController controller = fxmlLoader.getController();
			controller.setDirectorId(director.getId());
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the director registration window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	public void setDirector(Director director) {
		this.director = director;
		setFields();
	}
	
	public void setFields() {
		nameLbl.setText(director.getName());
		birthDateLbl.setText(director.getBirthDate());
		nationalityLbl.setText(director.getNationality());
		sexLbl.setText(director.getSex());
	}
}
