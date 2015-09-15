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
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.gui.TriggerSettingsController;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.osc.LeftEyebrowListener;


public class MainApp extends Application {
    
    TriggerSettingsController triggerSettingsController;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        triggerSettingsController = (TriggerSettingsController) fxmlLoader.getController();
        
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("FaceOSC Computer Control");
        stage.setScene(scene);
        stage.show();
        
        startOSCListeners();
    }
    
    public void startOSCListeners(){
        try {
            OSCPortIn receiver = new OSCPortIn(8338);
            receiver.addListener("/gesture/eyebrow/left", new LeftEyebrowListener(this));
            
            receiver.startListening();
        } catch (SocketException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateLeftEyebrowCurrent(float value){
        triggerSettingsController.leftBrowCurrent.setText((value+"").substring(0, 3));
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
