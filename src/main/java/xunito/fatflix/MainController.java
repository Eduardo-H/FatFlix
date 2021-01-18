package xunito.fatflix;

import java.io.IOException;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    private void logout() {
    	try {
    		App.setRoot("login");
    	} catch (IOException e) {
    		System.err.println("Not able to open the login window");
    	}
    }
}
