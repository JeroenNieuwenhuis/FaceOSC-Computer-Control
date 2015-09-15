/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jeroen_nieuwenhuis.faceosccomputercontrol.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.KeyPresser.KeyPressConfiguration;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.KeyPresser.KeyPresser;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.MainApp;

/**
 * FXML Controller class
 *
 * @author Jeroen
 */
public class KeyPresserController implements Initializable {

    
    @FXML private CheckBox leftBrowUpEnabled;
    @FXML private CheckBox leftBrowDownEnabled;
    @FXML private CheckBox rightBrowUpEnabled;
    @FXML private CheckBox rightBrowDownEnabled;
    @FXML private CheckBox mouthOpenEnabled;
    @FXML private CheckBox mouthClosedEnabled;
    
    @FXML private TextField leftBrowUpChar;
    @FXML private TextField leftBrowDownChar;
    @FXML private TextField rightBrowUpChar;
    @FXML private TextField rightBrowDownChar;
    @FXML private TextField mouthOpenChar;
    @FXML private TextField mouthClosedChar;
    
    @FXML private Button saveButton;
    @FXML private Button newButton;
    
    @FXML private TextField newField;
    @FXML private ChoiceBox configurationPicker;
    
    private KeyPresser presser;
    private MainApp app;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        presser = new KeyPresser();
        
        configurationPicker.setItems(FXCollections.observableArrayList(presser.getConfNames()));
        configurationPicker.getSelectionModel().select(0);
        configurationPicker.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                presser.setCurrent(newValue.intValue());
                setToCurrent();
            }
        });
        
        newButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String tekst = newField.getText();
                if (!tekst.isEmpty()) {
                    presser.addConf(new KeyPressConfiguration(tekst));
                    configurationPicker.setItems(FXCollections.observableArrayList(presser.getConfNames()));
                    configurationPicker.getSelectionModel().select(presser.getConfNames().size()-1);
                    presser.setCurrent(presser.getConfNames().size()-1);
                    newField.setText("");
                    clearAll();
                }
            }
        });
        
        leftBrowUpEnabled.selectedProperty().addListener(new ChangeListener<Boolean>() {
        public void changed(ObservableValue<? extends Boolean> ov,
            Boolean old_val, Boolean new_val) {
                presser.getCurrent().setLeftBrowUpEnabled(new_val);
        }
    });
        leftBrowDownEnabled.selectedProperty().addListener(new ChangeListener<Boolean>() {
        public void changed(ObservableValue<? extends Boolean> ov,
            Boolean old_val, Boolean new_val) {
                presser.getCurrent().setLeftBrowDownEnabled(new_val);
        }
    });
        rightBrowUpEnabled.selectedProperty().addListener(new ChangeListener<Boolean>() {
        public void changed(ObservableValue<? extends Boolean> ov,
            Boolean old_val, Boolean new_val) {
                presser.getCurrent().setRightBrowUpEnabled(new_val);
        }
    });
        rightBrowDownEnabled.selectedProperty().addListener(new ChangeListener<Boolean>() {
        public void changed(ObservableValue<? extends Boolean> ov,
            Boolean old_val, Boolean new_val) {
                presser.getCurrent().setRightBrowDownEnabled(new_val);
        }
    });
        mouthOpenEnabled.selectedProperty().addListener(new ChangeListener<Boolean>() {
        public void changed(ObservableValue<? extends Boolean> ov,
            Boolean old_val, Boolean new_val) {
                presser.getCurrent().setMouthOpenEnabled(new_val);
        }
    });
        mouthClosedEnabled.selectedProperty().addListener(new ChangeListener<Boolean>() {
        public void changed(ObservableValue<? extends Boolean> ov,
            Boolean old_val, Boolean new_val) {
                presser.getCurrent().setMouthClosedEnabled(new_val);
        }
    });
        
        leftBrowUpChar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.isEmpty()){
                    presser.getCurrent().setLeftBrowUpChar(newValue.charAt(0));
                }
            }
        });
        leftBrowDownChar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.isEmpty()){
                    presser.getCurrent().setLeftBrowDownChar(newValue.charAt(0));
                }
            }
        });
        rightBrowUpChar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.isEmpty()){
                    presser.getCurrent().setRightBrowUpChar(newValue.charAt(0));
                }
            }
        });
        rightBrowDownChar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.isEmpty()){
                    presser.getCurrent().setRightBrowDownChar(newValue.charAt(0));
                }
            }
        });
        mouthOpenChar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.isEmpty()){
                    presser.getCurrent().setMouthOpenChar(newValue.charAt(0));
                }
            }
        });
        mouthClosedChar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.isEmpty()){
                    presser.getCurrent().setMouthClosedChar(newValue.charAt(0));
                }
            }
        });
    }    
    
    public void setToCurrent(){
        leftBrowUpEnabled.setSelected(presser.getCurrent().isLeftBrowUpEnabled());
        leftBrowDownEnabled.setSelected(presser.getCurrent().isLeftBrowDownEnabled());
        rightBrowUpEnabled.setSelected(presser.getCurrent().isRightBrowUpEnabled());
        rightBrowDownEnabled.setSelected(presser.getCurrent().isRightBrowDownEnabled());
        mouthOpenEnabled.setSelected(presser.getCurrent().isMouthOpenEnabled());
        mouthClosedEnabled.setSelected(presser.getCurrent().isMouthClosedEnabled());
        
        leftBrowUpChar.setText(presser.getCurrent().getLeftBrowUpChar()+"");
        leftBrowDownChar.setText(presser.getCurrent().getLeftBrowDownChar()+"");
        rightBrowUpChar.setText(presser.getCurrent().getRightBrowUpChar()+"");
        rightBrowDownChar.setText(presser.getCurrent().getRightBrowDownChar()+"");
        mouthOpenChar.setText(presser.getCurrent().getMouthOpenChar()+"");
        mouthClosedChar.setText(presser.getCurrent().getMouthClosedChar()+"");
    }
    
    public void clearAll() {
        leftBrowUpEnabled.setSelected(false);
        presser.getCurrent().setLeftBrowUpEnabled(false);
        leftBrowDownEnabled.setSelected(false);
        presser.getCurrent().setLeftBrowDownEnabled(false);
        rightBrowUpEnabled.setSelected(false);
        presser.getCurrent().setRightBrowUpEnabled(false);
        rightBrowDownEnabled.setSelected(false);
        presser.getCurrent().setRightBrowDownEnabled(false);
        mouthOpenEnabled.setSelected(false);
        presser.getCurrent().setMouthOpenEnabled(false);
        mouthClosedEnabled.setSelected(false);
        presser.getCurrent().setMouthClosedEnabled(false);

        leftBrowUpChar.setText("");
        presser.getCurrent().setLeftBrowUpChar('`');
        leftBrowDownChar.setText("");
        presser.getCurrent().setLeftBrowDownChar('`');
        rightBrowUpChar.setText("");
        presser.getCurrent().setRightBrowUpChar('`');
        rightBrowDownChar.setText("");
        presser.getCurrent().setRightBrowDownChar('`');
        mouthOpenChar.setText("");
        presser.getCurrent().setMouthOpenChar('`');
        mouthClosedChar.setText("");
        presser.getCurrent().setMouthClosedChar('`');
    }

    public void setApp(MainApp aThis) {
        this.app = app;
    }
    
}
