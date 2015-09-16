/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jeroen_nieuwenhuis.faceosccomputercontrol.KeyPresser;

/**
 *
 * @author Jeroen
 */
public class KeyPressConfiguration {
    private String name;
    
    private boolean leftBrowUpEnabled;
    private boolean leftBrowDownEnabled;
    private boolean rightBrowUpEnabled;
    private boolean rightBrowDownEnabled;
    
    private boolean leftBrowUpReleasedEnabled;
    private boolean leftBrowDownReleasedEnabled;
    private boolean rightBrowUpReleasedEnabled;
    private boolean rightBrowDownReleasedEnabled;
    
    private boolean mouthOpenEnabled;
    private boolean mouthClosedEnabled;
    
    private char leftBrowUpChar;
    private char leftBrowDownChar;
    private char rightBrowUpChar;
    private char rightBrowDownChar;
    
    private char leftBrowUpReleasedChar;
    private char leftBrowDownReleasedChar;
    private char rightBrowUpReleasedChar;
    private char rightBrowDownReleasedChar;
    
    private char mouthOpenChar;
    private char mouthClosedChar;
    
    public KeyPressConfiguration(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLeftBrowUpReleasedEnabled() {
        return leftBrowUpReleasedEnabled;
    }

    public void setLeftBrowUpReleasedEnabled(boolean leftBrowUpReleasedEnabled) {
        this.leftBrowUpReleasedEnabled = leftBrowUpReleasedEnabled;
    }

    public boolean isLeftBrowDownReleasedEnabled() {
        return leftBrowDownReleasedEnabled;
    }

    public void setLeftBrowDownReleasedEnabled(boolean leftBrowDownReleasedEnabled) {
        this.leftBrowDownReleasedEnabled = leftBrowDownReleasedEnabled;
    }

    public boolean isRightBrowUpReleasedEnabled() {
        return rightBrowUpReleasedEnabled;
    }

    public void setRightBrowUpReleasedEnabled(boolean rightBrowUpReleasedEnabled) {
        this.rightBrowUpReleasedEnabled = rightBrowUpReleasedEnabled;
    }

    public boolean isRightBrowDownReleasedEnabled() {
        return rightBrowDownReleasedEnabled;
    }

    public void setRightBrowDownReleasedEnabled(boolean rightBrowDownReleasedEnabled) {
        this.rightBrowDownReleasedEnabled = rightBrowDownReleasedEnabled;
    }

    public char getLeftBrowUpReleasedChar() {
        return leftBrowUpReleasedChar;
    }

    public void setLeftBrowUpReleasedChar(char leftBrowUpReleasedChar) {
        this.leftBrowUpReleasedChar = leftBrowUpReleasedChar;
    }

    public char getLeftBrowDownReleasedChar() {
        return leftBrowDownReleasedChar;
    }

    public void setLeftBrowDownReleasedChar(char leftBrowDownReleasedChar) {
        this.leftBrowDownReleasedChar = leftBrowDownReleasedChar;
    }

    public char getRightBrowUpReleasedChar() {
        return rightBrowUpReleasedChar;
    }

    public void setRightBrowUpReleasedChar(char rightBrowUpReleasedChar) {
        this.rightBrowUpReleasedChar = rightBrowUpReleasedChar;
    }

    public char getRightBrowDownReleasedChar() {
        return rightBrowDownReleasedChar;
    }

    public void setRightBrowDownReleasedChar(char rightBrowDownReleasedChar) {
        this.rightBrowDownReleasedChar = rightBrowDownReleasedChar;
    }

    public boolean isLeftBrowUpEnabled() {
        return leftBrowUpEnabled;
    }

    public void setLeftBrowUpEnabled(boolean leftBrowUpEnabled) {
        this.leftBrowUpEnabled = leftBrowUpEnabled;
    }

    public boolean isLeftBrowDownEnabled() {
        return leftBrowDownEnabled;
    }

    public void setLeftBrowDownEnabled(boolean leftBrowDownEnabled) {
        this.leftBrowDownEnabled = leftBrowDownEnabled;
    }

    public boolean isRightBrowUpEnabled() {
        return rightBrowUpEnabled;
    }

    public void setRightBrowUpEnabled(boolean rightBrowUpEnabled) {
        this.rightBrowUpEnabled = rightBrowUpEnabled;
    }

    public boolean isRightBrowDownEnabled() {
        return rightBrowDownEnabled;
    }

    public void setRightBrowDownEnabled(boolean rightBrowDownEnabled) {
        this.rightBrowDownEnabled = rightBrowDownEnabled;
    }

    public boolean isMouthOpenEnabled() {
        return mouthOpenEnabled;
    }

    public void setMouthOpenEnabled(boolean mouthOpenEnabled) {
        this.mouthOpenEnabled = mouthOpenEnabled;
    }

    public boolean isMouthClosedEnabled() {
        return mouthClosedEnabled;
    }

    public void setMouthClosedEnabled(boolean mouthClosedEnabled) {
        this.mouthClosedEnabled = mouthClosedEnabled;
    }

    public char getLeftBrowUpChar() {
        return leftBrowUpChar;
    }

    public void setLeftBrowUpChar(char leftBrowUpChar) {
        this.leftBrowUpChar = leftBrowUpChar;
    }

    public char getLeftBrowDownChar() {
        return leftBrowDownChar;
    }

    public void setLeftBrowDownChar(char leftBrowDownChar) {
        this.leftBrowDownChar = leftBrowDownChar;
    }

    public char getRightBrowUpChar() {
        return rightBrowUpChar;
    }

    public void setRightBrowUpChar(char rightBrowUpChar) {
        this.rightBrowUpChar = rightBrowUpChar;
    }

    public char getRightBrowDownChar() {
        return rightBrowDownChar;
    }

    public void setRightBrowDownChar(char rightBrowDownChar) {
        this.rightBrowDownChar = rightBrowDownChar;
    }

    public char getMouthOpenChar() {
        return mouthOpenChar;
    }

    public void setMouthOpenChar(char mouthOpenChar) {
        this.mouthOpenChar = mouthOpenChar;
    }

    public char getMouthClosedChar() {
        return mouthClosedChar;
    }

    public void setMouthClosedChar(char mouthClosedChar) {
        this.mouthClosedChar = mouthClosedChar;
    }
    
    

}
