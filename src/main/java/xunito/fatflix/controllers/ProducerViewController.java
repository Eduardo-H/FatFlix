package xunito.fatflix.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import xunito.fatflix.AlertUtil;
import xunito.fatflix.App;
import xunito.fatflix.db.ProducerDAO;
import xunito.fatflix.entities.Producer;

public class ProducerViewController implements Initializable {

	@FXML
	private Label nameLbl;
	@FXML
	private Label foundationLbl;
	
	private Producer producer;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void setProducer(Producer p) {
		this.producer = p;
		setValues();
	}
	
	public void setValues() {
		nameLbl.setText(producer.getName());
		foundationLbl.setText(producer.getFoundation());
	}
	
	public void back() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("producers.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) nameLbl.getScene().getWindow();
			stage.setResizable(true);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the producers window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	public void delete() {
		new ProducerDAO().remove(producer);
		
		Alert alert = AlertUtil.info("Success!", "Operation successfully completed", "Producer deleted from the database.");
		alert.show();
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("producers.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) nameLbl.getScene().getWindow();
			stage.setResizable(true);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the producers window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	public void edit() {
		
	}
}
