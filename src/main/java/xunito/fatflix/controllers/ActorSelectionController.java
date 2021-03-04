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
import xunito.fatflix.db.ActorDAO;
import xunito.fatflix.db.DirectorDAO;
import xunito.fatflix.entities.Actor;

public class ActorSelectionController implements Initializable {

	@FXML
	private ListView<String> actorsList;
	@FXML
	private Button selectBtn;

	private ArrayList<Integer> ids;
	private MovieRegisterController controller;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ids = getAllActors();
		selectBtn.setDisable(true);
	}
	
	public ArrayList<Integer> getAllActors() {
		List<String> actors = new ArrayList<String>();
		ArrayList<Integer> actorIds = new ArrayList<Integer>();
		
		for (Actor actor : new ActorDAO().getAll()) {
			actors.add(actor.getName());
			actorIds.add(actor.getId());
		}
			
		actorsList.setItems(FXCollections.observableArrayList(actors));
		
		return actorIds;
	}
	
	public void handleListClick() {
		if (actorsList.getSelectionModel().selectedItemProperty().getValue() != null) {
			selectBtn.setDisable(false);
		} else {
			selectBtn.setDisable(true);
		}
	}
	
	@FXML
	public void select() {
		if (actorsList.getSelectionModel().selectedItemProperty().getValue() != null) {
			int actorId = ids.get(actorsList.getSelectionModel().getSelectedIndex());

			controller.setActor(new ActorDAO().get(actorId));
			
			Stage stage = (Stage) actorsList.getScene().getWindow();
			stage.close();
		}
	}
	
	@FXML
	public void cancel() {
		Stage stage = (Stage) actorsList.getScene().getWindow();
		stage.close();
	}
	
	public void setController(MovieRegisterController controller) {
		this.controller = controller;
	}
	
}
