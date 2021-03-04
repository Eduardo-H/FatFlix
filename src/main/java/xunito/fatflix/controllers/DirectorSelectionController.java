package xunito.fatflix.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import xunito.fatflix.db.DirectorDAO;
import xunito.fatflix.entities.Director;

public class DirectorSelectionController implements Initializable {

	@FXML
	private ListView<String> directorsList;
	@FXML
	private Button selectBtn;

	private ArrayList<Integer> ids;
	private MovieRegisterController controller;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ids = getAllDirectors();
		selectBtn.setDisable(true);
	}
	
	public ArrayList<Integer> getAllDirectors() {
		List<String> directors = new ArrayList<>();
		ArrayList<Integer> directorIds = new ArrayList();
		
		for (Director director : new DirectorDAO().getAll()) {
			directors.add(director.getName());
			directorIds.add(director.getId());
		}
		
		directorsList.setItems(FXCollections.observableArrayList(directors));
		
		return directorIds;
	}
	
	public void handleListClick() {
		if (directorsList.getSelectionModel().selectedItemProperty().getValue() != null) {
			selectBtn.setDisable(false);
		} else {
			selectBtn.setDisable(true);
		}
	}
	
	@FXML
	public void select() {
		if (directorsList.getSelectionModel().selectedItemProperty().getValue() != null) {
			int directorId = ids.get(directorsList.getSelectionModel().getSelectedIndex());

			controller.setDirector(new DirectorDAO().get(directorId));
			
			Stage stage = (Stage) directorsList.getScene().getWindow();
			stage.close();
		}
	}
	
	@FXML
	public void cancel() {
		Stage stage = (Stage) directorsList.getScene().getWindow();
		stage.close();
	}
	
	public void setController(MovieRegisterController controller) {
		this.controller = controller;
	}
	
}
