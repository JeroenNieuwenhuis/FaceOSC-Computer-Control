package nl.jeroen_nieuwenhuis.faceosccomputercontrol.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.KeyPresser.KeyPressConfiguration;
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
    
    @FXML private Button enableButton;
    @FXML private Label enableText;
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
    
    
    public void updateLeftEyebrowCurrent(final String value){
        Platform.runLater(new Runnable() {
            @Override public void run() {
                leftBrowCurrent.setText(value);
            }
        });
        
    }
    public void updateRightEyebrowCurrent(final String value){
        Platform.runLater(new Runnable() {
            @Override public void run() {
                rightBrowCurrent.setText(value);
            }
        });
        
    }
    public void updateMouthHeightCurrent(final String value){
        Platform.runLater(new Runnable() {
            @Override public void run() {
                mouthHeightCurrent.setText(value);
            }
        });
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        enableButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(app.face.isEnabled()){
                    app.face.disable();
                    enableText.setText("Triggers disabled");
                } else {
                    if(app.face.enable()){
                        enableText.setText("Triggers enabled");
                    } else {
                        enableText.setText("Triggers disabled, set trigger values");
                    }
                }
            }
        });
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
