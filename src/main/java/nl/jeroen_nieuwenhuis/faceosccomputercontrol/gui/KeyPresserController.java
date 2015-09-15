/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jeroen_nieuwenhuis.faceosccomputercontrol.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
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
        // TODO
    }    

    public void setApp(MainApp aThis) {
        this.app = app;
    }
    
}
