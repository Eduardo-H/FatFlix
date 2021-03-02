package xunito.fatflix;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

public class FXMLUtil {
	
	public static Scene loadScene(String fxml) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			return scene;
		} catch (IOException eIO) {
			Alert alert = AlertUtil.error("Erro", "Error trying to load a component", "Error trying to load a component " + fxml,
					eIO);
			alert.showAndWait();
			return null;
		} catch (IllegalStateException eIllegalState) {
			Alert alert = AlertUtil.error("Erro", "Inexisting file", "Error trying to load the window " + fxml,
					eIllegalState);
			alert.showAndWait();
			return null;
		}
	}

}
