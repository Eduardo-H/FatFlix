package xunito.fatflix.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import xunito.fatflix.AlertUtil;
import xunito.fatflix.App;
import xunito.fatflix.db.ActorDAO;
import xunito.fatflix.entities.Actor;

public class ActorController implements Initializable {

	@FXML
	private ListView<String> actorsList;
	@FXML
	private Button viewBtn;
	
	private ArrayList<Integer> ids;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ids = getAllActors();
		viewBtn.setDisable(true);
	}
	
	public ArrayList<Integer> getAllActors() {
		List<String> actors = new ArrayList<>();
		ArrayList<Integer> actorIds = new ArrayList();
		
		for (Actor actor : new ActorDAO().getAll()) {
			actors.add(actor.getName());
			actorIds.add(actor.getId());
		}
			
		actorsList.setItems(FXCollections.observableArrayList(actors));
		
		return actorIds;
	}
	
	@FXML
	public void addActor() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actorRegister.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) actorsList.getScene().getWindow();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the actor registration window.", e);
			alert.showAndWait();
			return;
		}
	}
	
	public void handleListClick() {
		if (actorsList.getSelectionModel().selectedItemProperty().getValue() != null) {
			viewBtn.setDisable(false);
		} else {
			viewBtn.setDisable(true);
		}
	}
	
	public void handleViewClick() {
		if (actorsList.getSelectionModel().selectedItemProperty().getValue() != null) {
			int actorId = ids.get(actorsList.getSelectionModel().getSelectedIndex());
			
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actorView.fxml"));
				Scene scene = new Scene(fxmlLoader.load());
				Stage stage = (Stage) actorsList.getScene().getWindow();
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
				
				ActorViewController controller = fxmlLoader.getController();
				controller.setActor(new ActorDAO().get(actorId));
			} catch (IOException e) {
				Alert alert = AlertUtil.error("Erro", "Inexisting file",
						"Error trying to load the actor visualization window.", e);
				alert.showAndWait();
				return;
			}		
		}
	}
	
	@FXML
    private void logout() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) actorsList.getScene().getWindow();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the login window.", e);
			alert.showAndWait();
			return;
		}
    }
	
	@FXML
	public void openHomeWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) actorsList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the home window.", e);
			alert.showAndWait();
			return;
		}
	}
	
	@FXML
	public void openMoviesWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("movies.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) actorsList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the movies window.", e);
			alert.showAndWait();
			return;
		}
	}
	
	@FXML
	public void openTVShowsWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("tvShows.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) actorsList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the TV Shows window.", e);
			alert.showAndWait();
			return;
		}
	}
	
	@FXML
    public void openDirectorsWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("directors.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) actorsList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the directors window.", e);
			alert.showAndWait();
			return;
		}
    }
	
	@FXML
	public void openProducersWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("producers.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) actorsList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the producers window.", e);
			alert.showAndWait();
			return;
		}
	}

}
