package nl.jeroen_nieuwenhuis.faceosccomputercontrol;

import com.illposed.osc.OSCPortIn;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.KeyPresser.KeyPresser;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.gui.KeyPresserController;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.gui.TriggerSettingsController;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.model.Face;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.osc.LeftEyebrowListener;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.osc.MouthHeightListener;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.osc.RightEyebrowListener;


public class MainApp extends Application {
    
    TriggerSettingsController triggerSettingsController;
    KeyPresserController keyPresserController;
    public Face face;
    KeyPresser presser;

    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/TriggerSettings.fxml"));
        Parent root = fxmlLoader.load();
 
        triggerSettingsController = (TriggerSettingsController) fxmlLoader.getController();
        triggerSettingsController.setApp(this);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("Trigger settings");
        stage.setScene(scene);
        stage.show();
        
        keyPresserController = showKeyPresserStage();
        keyPresserController.init(this);
        presser = keyPresserController.getPresser();
        face = new Face(this, presser);
        startOSCListeners();
    }
    
    public KeyPresserController showKeyPresserStage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/KeyPresser.fxml"));
        Parent root = fxmlLoader.load();
        
        KeyPresserController controller = (KeyPresserController) fxmlLoader.getController();
        
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add("/styles/Styles.css");
        Stage stage = new Stage();
        stage.setTitle("Trigger settings");
        stage.setScene(scene);
        stage.show();
        
        return controller;
    }
    
    public void startOSCListeners(){
        try {
            OSCPortIn receiver = new OSCPortIn(8338);
            receiver.addListener("/gesture/eyebrow/left", new LeftEyebrowListener(face, presser));
            receiver.addListener("/gesture/eyebrow/right", new RightEyebrowListener(face, presser));
            receiver.addListener("/gesture/mouth/height", new MouthHeightListener(face, presser));

            
            receiver.startListening();
        } catch (SocketException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setKeyPresser(KeyPresser presser){
        this.presser = presser;
    }
    
    public void updateLeftEyebrowCurrent(float value){
        triggerSettingsController.updateLeftEyebrowCurrent((value+"").substring(0, 3));
    }
    public void updateRightEyebrowCurrent(float value){
        triggerSettingsController.updateRightEyebrowCurrent((value+"").substring(0, 3));
    }
    public void updateMouthHeightCurrent(float value){
        triggerSettingsController.updateMouthHeightCurrent((value+"").substring(0, 3));
    }
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
