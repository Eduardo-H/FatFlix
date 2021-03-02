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
import xunito.fatflix.db.ProducerDAO;
import xunito.fatflix.entities.Producer;

public class ProducerController implements Initializable {

	@FXML
	private ListView<String> producersList;
	@FXML
	private Button viewBtn;
	
	private ArrayList<Integer> ids;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ids = getAllProducers();
		viewBtn.setDisable(true);
	}

	public ArrayList<Integer> getAllProducers() {
		List<String> producers = new ArrayList<>();
		ArrayList<Integer> pIds = new ArrayList();
		
		for (Producer producer : new ProducerDAO().getAll()) {
			producers.add(producer.getName());
			pIds.add(producer.getId());
		}

		producersList.setItems(FXCollections.observableArrayList(producers));
		
		return pIds;
	}
	
	public void handleListClick() {
		if (producersList.getSelectionModel().selectedItemProperty().getValue() != null) {
			viewBtn.setDisable(false);
		} else {
			viewBtn.setDisable(true);
		}
	}

	public void handleViewClick() {
		if (producersList.getSelectionModel().selectedItemProperty().getValue() != null) {
			int producerId = ids.get(producersList.getSelectionModel().getSelectedIndex());
			
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("producerView.fxml"));
				Scene scene = new Scene(fxmlLoader.load());
				Stage stage = (Stage) producersList.getScene().getWindow();
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
				
				ProducerViewController controller = fxmlLoader.getController();
				controller.setProducer(new ProducerDAO().get(producerId));
			} catch (IOException e) {
				Alert alert = AlertUtil.error("Erro", "Inexisting file",
						"Error trying to load the producer visualization window.", e);
				alert.showAndWait();
				return;
			}		
		}
	}
	
	@FXML
	public void addProducer() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("producerRegister.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) producersList.getScene().getWindow();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			ProducerRegisterController controller = fxmlLoader.getController();
			controller.setProducerId(0);
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file",
					"Error trying to load the producer registration window.", e);
			alert.showAndWait();
			return;
		}
	}

	@FXML
	private void logout() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) producersList.getScene().getWindow();
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
			Stage stage = (Stage) producersList.getScene().getWindow();
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
			Stage stage = (Stage) producersList.getScene().getWindow();
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
			Stage stage = (Stage) producersList.getScene().getWindow();
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
			Stage stage = (Stage) producersList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the directors window.", e);
			alert.showAndWait();
			return;
		}
	}

	@FXML
	public void openActorsWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actors.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) producersList.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the actors window.", e);
			alert.showAndWait();
			return;
		}
	}

}
