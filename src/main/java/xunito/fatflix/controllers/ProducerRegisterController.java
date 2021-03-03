package xunito.fatflix.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import xunito.fatflix.AlertUtil;
import xunito.fatflix.App;
import xunito.fatflix.db.ProducerDAO;
import xunito.fatflix.entities.Producer;

public class ProducerRegisterController {

	@FXML
	private TextField nameTxt;
	@FXML
	private TextField foundationDateTxt;
	
	private String producerName;
	
	
	@FXML
	public void save() {
		String name = nameTxt.getText();
		String foundation = foundationDateTxt.getText();
		
		if (name.isBlank()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Type the producer's name.", null);
			alert.showAndWait();
			return;
		}
		
		if (foundation.isBlank()) {
			Alert alert = AlertUtil.error("Error!", "Error!", "Type the producer's foundation date.", null);
			alert.showAndWait();
			return;
		}
		
		new ProducerDAO().persist(new Producer(name, foundation));
		
		Alert alert = AlertUtil.info("Success!", "Operation successfully completed", "Producer saved in the database.");
		alert.show();
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("producers.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) nameTxt.getScene().getWindow();
			stage.setResizable(true);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the producers registration window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	@FXML
	public void cancel() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("producers.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) nameTxt.getScene().getWindow();
			stage.setResizable(true);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the producers window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	public void setProducerNam(String name) {
		this.producerName = name;
		setFields();
	}
	
	public void setFields() {
		if (producerName != null) {
			Producer producer = new ProducerDAO().get(producerName);
			nameTxt.setText(producer.getName());
			foundationDateTxt.setText(producer.getFoundation());
		}
	}
	
}
