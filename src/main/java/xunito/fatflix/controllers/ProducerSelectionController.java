package xunito.fatflix.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import xunito.fatflix.db.ProducerDAO;
import xunito.fatflix.entities.Producer;

public class ProducerSelectionController implements Initializable {

	@FXML
	private ListView<String> producersList;
	@FXML
	private Button selectBtn;

	private ArrayList<Integer> ids;
	private MovieRegisterController controller;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ids = getAllProducers();
		selectBtn.setDisable(true);
	}
	
	public ArrayList<Integer> getAllProducers() {
		List<String> producers = new ArrayList<String>();
		ArrayList<Integer> pIds = new ArrayList<Integer>();
		
		for (Producer producer : new ProducerDAO().getAll()) {
			producers.add(producer.getName());
		}

		producersList.setItems(FXCollections.observableArrayList(producers));
		
		return pIds;
	}
	
	public void handleListClick() {
		if (producersList.getSelectionModel().selectedItemProperty().getValue() != null) {
			selectBtn.setDisable(false);
		} else {
			selectBtn.setDisable(true);
		}
	}
	
	@FXML
	public void select() {
		String name = producersList.getSelectionModel().selectedItemProperty().getValue();
		if (name != null) {

			controller.setProducer(new ProducerDAO().get(name));
			
			Stage stage = (Stage) producersList.getScene().getWindow();
			stage.close();
		}
	}
	
	@FXML
	public void cancel() {
		Stage stage = (Stage) producersList.getScene().getWindow();
		stage.close();
	}
	
	public void setController(MovieRegisterController controller) {
		this.controller = controller;
	}
	
}
