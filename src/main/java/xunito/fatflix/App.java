package xunito.fatflix;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Stage stage;

	@Override
	public void start(Stage stg) {
		stage = stg;
		stage.setScene(FXMLUtil.loadScene("login"));
		changeResizable();
		stage.setTitle("Fatflix");
		stage.show();
	}

	public static void setRoot(String fxml) {
		stage.setScene(FXMLUtil.loadScene(fxml));
	}

	public static void changeResizable() {
		if (stage.isResizable())
			stage.setResizable(false);
		else
			stage.setResizable(true);
	}

    public static void main(String[] args) {
        launch();
    }

}