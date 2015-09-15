package nl.jeroen_nieuwenhuis.faceosccomputercontrol.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.MainApp;

public class TriggerSettingsController implements Initializable {
    
    private MainApp app;
    
    
    @FXML private TextField leftBrowCurrent;
    @FXML private TextField rightBrowCurrent;
    @FXML private TextField mouthHeightCurrent;
    
    @FXML private TextField leftEyebrowDown;
    @FXML private TextField leftEyebrowUp;
    
    @FXML private TextField rightEyebrowDown;
    @FXML private TextField rightEyebrowUp;
    
    @FXML private TextField mouthOpen;
    @FXML private TextField mouthClosed;
//    @FXML
//    private Label label;
//    
//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }
    public void setApp(MainApp app){
        this.app = app;
    }
    
    
    public void updateLeftEyebrowCurrent(String value){
        leftBrowCurrent.setText(value);
    }
    public void updateRightEyebrowCurrent(String value){
        rightBrowCurrent.setText(value);
    }
    public void updateMouthHeightCurrent(String value){
        mouthHeightCurrent.setText(value);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(leftEyebrowDown == null){
            System.out.println("jjkjttttttttttttttt");
        }
        leftEyebrowDown.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Float f;
                try {
                    f = Float.parseFloat(newValue);
                    app.face.leftEyebrowDownTrigger = f;
                } catch (NumberFormatException e){
                    return;
                }
            }
        });
        leftEyebrowUp.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Float f;
                try {
                    f = Float.parseFloat(newValue);
                    app.face.leftEyebrowUpTrigger = f;
                } catch (NumberFormatException e){
                    return;
                }
            }
        });
        rightEyebrowDown.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Float f;
                try {
                    f = Float.parseFloat(newValue);
                    app.face.rightEyebrowDownTrigger = f;
                } catch (NumberFormatException e){
                    return;
                }
            }
        });
        rightEyebrowUp.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Float f;
                try {
                    f = Float.parseFloat(newValue);
                    app.face.rightEyebrowUpTrigger = f;
                } catch (NumberFormatException e){
                    return;
                }
            }
        });
        mouthOpen.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Float f;
                try {
                    f = Float.parseFloat(newValue);
                    app.face.mouthOpenTrigger = f;
                } catch (NumberFormatException e){
                    return;
                }
            }
        });
        mouthClosed.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Float f;
                try {
                    f = Float.parseFloat(newValue);
                    app.face.mouthClosedTrigger = f;
                } catch (NumberFormatException e){
                    return;
                }
            }
        });
    }    
}
