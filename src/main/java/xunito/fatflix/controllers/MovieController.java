package xunito.fatflix.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import xunito.fatflix.AlertUtil;
import xunito.fatflix.App;
import xunito.fatflix.db.MovieDAO;
import xunito.fatflix.entities.Movie;

public class MovieController implements Initializable {

	@FXML
	private ImageView logo;
	@FXML
	private ListView<String> moviesList;
	@FXML
	private Button viewBtn;
	
	private ArrayList<Integer> ids;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ids = getAllMovies();
		viewBtn.setDisable(true);
	}
	
	public ArrayList<Integer> getAllMovies() {
		ArrayList<String> movies = new ArrayList<String>();
		ArrayList<Integer> moviesIds = new ArrayList<Integer>();
		
		for (Movie movie : new MovieDAO().getAll()) {
			movies.add(movie.getTitle());
			moviesIds.add(movie.getId());
		}
		
		moviesList.setItems(FXCollections.observableArrayList(movies));
		
		return moviesIds;
	}
	
	@FXML
	public void addMovie() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("movieRegister.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) logo.getScene().getWindow();
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
			
			MovieRegisterController controller = fxmlLoader.getController();
			controller.setMovieId(0);
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the movie register window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	public void handleListClick() {
		if (moviesList.getSelectionModel().selectedItemProperty().getValue() != null) {
			viewBtn.setDisable(false);
		} else {
			viewBtn.setDisable(true);
		}
	}
	
	public void handleViewClick() {
		if (moviesList.getSelectionModel().selectedItemProperty().getValue() != null) {
			int movieId = ids.get(moviesList.getSelectionModel().getSelectedIndex());
			
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("movieView.fxml"));
				Scene scene = new Scene(fxmlLoader.load());
				Stage stage = (Stage) moviesList.getScene().getWindow();
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
				
				MovieViewController controller = fxmlLoader.getController();
				controller.setMovie(new MovieDAO().get(movieId));
			} catch (IOException e) {
				Alert alert = AlertUtil.error("Erro", "Inexisting file",
						"Error trying to load the movie visualization window.", e);
				alert.showAndWait();
				return;
			}	
		}
	}
		
	
	@FXML
    private void logout() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("movieRegister.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) logo.getScene().getWindow();
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the movie register window.", e);
			errorAlert.showAndWait();
			return;
		}
    }
	
	@FXML
	public void openHomeWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) logo.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the home window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	@FXML
	public void openTVShowsWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("tvShows.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) logo.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the TV Shows window.", e);
			errorAlert.showAndWait();
			return;
		}
	}
	
	@FXML
    public void openDirectorsWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("directors.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) logo.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the directors window.", e);
			errorAlert.showAndWait();
			return;
		}
    }
	
	@FXML
    public void openActorsWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actors.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) logo.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert errorAlert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the actors window.", e);
			errorAlert.showAndWait();
			return;
		}
    }
	
	@FXML
	public void openProducersWindow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("producers.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = (Stage) logo.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the producers window.", e);
			alert.showAndWait();
			return;
		}
	}
	
}
