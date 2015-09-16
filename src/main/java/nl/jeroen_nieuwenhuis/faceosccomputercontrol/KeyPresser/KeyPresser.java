/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jeroen_nieuwenhuis.faceosccomputercontrol.KeyPresser;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.KeyStroke;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.model.Trigger;

/**
 *
 * @author Jeroen
 */
public class KeyPresser {
    private List<KeyPressConfiguration> configurations;
    private KeyPressConfiguration current;
    private Robot robot;
    
    public KeyPresser(){
        try {
            configurations = new ArrayList<>();
            KeyPressConfiguration c = new KeyPressConfiguration("Conf 1");
            configurations.add(c);
            current = c;
            this.robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(KeyPresser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<String> getConfNames(){
        List<String> returnList = new ArrayList<>();
        for(KeyPressConfiguration k: configurations){
            returnList.add(k.getName());
        }
        return returnList;
    }
    
    public void setCurrent(int number){
        if (number > -1 && number < configurations.size()){
            current = configurations.get(number);
        }
    }
    
    public void addConf(KeyPressConfiguration k){
        configurations.add(k);
    }

    public KeyPressConfiguration getCurrent() {
        return current;
    }
    
    public void pressKey(Trigger trigger){
        switch (trigger) {
            case LEFT_EYEBROW_UP:  
                if (current.isLeftBrowUpEnabled()){
                    pressKey(current.getLeftBrowUpChar());
                }
                break;
            case LEFT_EYEBROW_DOWN:  
                if (current.isLeftBrowDownEnabled()){
                    pressKey(current.getLeftBrowDownChar());
                }
                break;
            case RIGHT_EYEBROW_UP:  
                if (current.isRightBrowUpEnabled()){
                    pressKey(current.getRightBrowUpChar());
              }
                break;
            case RIGHT_EYEBROW_DOWN:  
                if (current.isRightBrowDownEnabled()){
                    pressKey(current.getRightBrowDownChar());
                }
                break;
            case MOUTH_OPEN:  
                if (current.isMouthOpenEnabled()){
                    pressKey(current.getMouthOpenChar());
                 }
                break;
            case MOUTH_CLOSED:  
                if (current.isMouthClosedEnabled()){
                    pressKey(current.getMouthClosedChar());
                }
                break;
            case NONE:  
                break;
        }
    }
    
    private void pressKey(char ch) {
        KeyStroke ks = KeyStroke.getKeyStroke(ch, 0);
        int key = ks.getKeyCode();
        robot.keyPress(key);
        robot.keyRelease(key);
    }
}
