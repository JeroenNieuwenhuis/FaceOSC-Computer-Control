package nl.jeroen_nieuwenhuis.faceosccomputercontrol.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class TriggerSettingsController implements Initializable {
    
    
    @FXML public Text leftBrowCurrent;
    @FXML private Text rightBrowCurrent;
    @FXML private Text mouthCurrent;
//    @FXML
//    private Label label;
//    
//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
