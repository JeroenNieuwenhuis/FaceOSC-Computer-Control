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
import static java.awt.event.KeyEvent.*;
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
            case LEFT_EYEBROW_UP_RELEASED:  
                if (current.isLeftBrowUpReleasedEnabled()){
                    pressKey(current.getLeftBrowUpReleasedChar());
                }
                break;
            case LEFT_EYEBROW_DOWN_RELEASED:  
                if (current.isLeftBrowDownReleasedEnabled()){
                    pressKey(current.getLeftBrowDownReleasedChar());
                }
                break;
            case RIGHT_EYEBROW_UP_RELEASED:  
                if (current.isRightBrowUpReleasedEnabled()){
                    pressKey(current.getRightBrowUpReleasedChar());
                }
                break;
            case RIGHT_EYEBROW_DOWN_RELEASED:  
                if (current.isRightBrowDownReleasedEnabled()){
                    pressKey(current.getRightBrowDownReleasedChar());
                }
                break;
            case NONE:  
                break;
        }
    }
    
    private void pressKey(char ch) {
        type(ch);
    }
    
    public void type(char character) {
        switch (character) {
        case 'a': doType(VK_A); break;
        case 'b': doType(VK_B); break;
        case 'c': doType(VK_C); break;
        case 'd': doType(VK_D); break;
        case 'e': doType(VK_E); break;
        case 'f': doType(VK_F); break;
        case 'g': doType(VK_G); break;
        case 'h': doType(VK_H); break;
        case 'i': doType(VK_I); break;
        case 'j': doType(VK_J); break;
        case 'k': doType(VK_K); break;
        case 'l': doType(VK_L); break;
        case 'm': doType(VK_M); break;
        case 'n': doType(VK_N); break;
        case 'o': doType(VK_O); break;
        case 'p': doType(VK_P); break;
        case 'q': doType(VK_Q); break;
        case 'r': doType(VK_R); break;
        case 's': doType(VK_S); break;
        case 't': doType(VK_T); break;
        case 'u': doType(VK_U); break;
        case 'v': doType(VK_V); break;
        case 'w': doType(VK_W); break;
        case 'x': doType(VK_X); break;
        case 'y': doType(VK_Y); break;
        case 'z': doType(VK_Z); break;
        case 'A': doType(VK_SHIFT, VK_A); break;
        case 'B': doType(VK_SHIFT, VK_B); break;
        case 'C': doType(VK_SHIFT, VK_C); break;
        case 'D': doType(VK_SHIFT, VK_D); break;
        case 'E': doType(VK_SHIFT, VK_E); break;
        case 'F': doType(VK_SHIFT, VK_F); break;
        case 'G': doType(VK_SHIFT, VK_G); break;
        case 'H': doType(VK_SHIFT, VK_H); break;
        case 'I': doType(VK_SHIFT, VK_I); break;
        case 'J': doType(VK_SHIFT, VK_J); break;
        case 'K': doType(VK_SHIFT, VK_K); break;
        case 'L': doType(VK_SHIFT, VK_L); break;
        case 'M': doType(VK_SHIFT, VK_M); break;
        case 'N': doType(VK_SHIFT, VK_N); break;
        case 'O': doType(VK_SHIFT, VK_O); break;
        case 'P': doType(VK_SHIFT, VK_P); break;
        case 'Q': doType(VK_SHIFT, VK_Q); break;
        case 'R': doType(VK_SHIFT, VK_R); break;
        case 'S': doType(VK_SHIFT, VK_S); break;
        case 'T': doType(VK_SHIFT, VK_T); break;
        case 'U': doType(VK_SHIFT, VK_U); break;
        case 'V': doType(VK_SHIFT, VK_V); break;
        case 'W': doType(VK_SHIFT, VK_W); break;
        case 'X': doType(VK_SHIFT, VK_X); break;
        case 'Y': doType(VK_SHIFT, VK_Y); break;
        case 'Z': doType(VK_SHIFT, VK_Z); break;
        case '`': doType(VK_BACK_QUOTE); break;
        case '0': doType(VK_0); break;
        case '1': doType(VK_1); break;
        case '2': doType(VK_2); break;
        case '3': doType(VK_3); break;
        case '4': doType(VK_4); break;
        case '5': doType(VK_5); break;
        case '6': doType(VK_6); break;
        case '7': doType(VK_7); break;
        case '8': doType(VK_8); break;
        case '9': doType(VK_9); break;
        case '-': doType(VK_MINUS); break;
        case '=': doType(VK_EQUALS); break;
        case '~': doType(VK_SHIFT, VK_BACK_QUOTE); break;
        case '!': doType(VK_EXCLAMATION_MARK); break;
        case '@': doType(VK_AT); break;
        case '#': doType(VK_NUMBER_SIGN); break;
        case '$': doType(VK_DOLLAR); break;
        case '%': doType(VK_SHIFT, VK_5); break;
        case '^': doType(VK_CIRCUMFLEX); break;
        case '&': doType(VK_AMPERSAND); break;
        case '*': doType(VK_ASTERISK); break;
        case '(': doType(VK_LEFT_PARENTHESIS); break;
        case ')': doType(VK_RIGHT_PARENTHESIS); break;
        case '_': doType(VK_UNDERSCORE); break;
        case '+': doType(VK_PLUS); break;
        case '\t': doType(VK_TAB); break;
        case '\n': doType(VK_ENTER); break;
        case '[': doType(VK_OPEN_BRACKET); break;
        case ']': doType(VK_CLOSE_BRACKET); break;
        case '\\': doType(VK_BACK_SLASH); break;
        case '{': doType(VK_SHIFT, VK_OPEN_BRACKET); break;
        case '}': doType(VK_SHIFT, VK_CLOSE_BRACKET); break;
        case '|': doType(VK_SHIFT, VK_BACK_SLASH); break;
        case ';': doType(VK_SEMICOLON); break;
        case ':': doType(VK_COLON); break;
        case '\'': doType(VK_QUOTE); break;
        case '"': doType(VK_QUOTEDBL); break;
        case ',': doType(VK_COMMA); break;
        case '<': doType(VK_SHIFT, VK_COMMA); break;
        case '.': doType(VK_PERIOD); break;
        case '>': doType(VK_SHIFT, VK_PERIOD); break;
        case '/': doType(VK_SLASH); break;
        case '?': doType(VK_SHIFT, VK_SLASH); break;
        case ' ': doType(VK_SPACE); break;
        default:
            throw new IllegalArgumentException("Cannot type character " + character);
        }
    }

    private void doType(int... keyCodes) {
        doType(keyCodes, 0, keyCodes.length);
    }

    private void doType(int[] keyCodes, int offset, int length) {
        if (length == 0) {
            return;
        }

        robot.keyPress(keyCodes[offset]);
        doType(keyCodes, offset + 1, length - 1);
        try {
            Thread.sleep(25);
        } catch (InterruptedException ex) {
            Logger.getLogger(KeyPresser.class.getName()).log(Level.SEVERE, null, ex);
        }
        robot.keyRelease(keyCodes[offset]);
    }
}
