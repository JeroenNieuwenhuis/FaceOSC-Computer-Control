/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jeroen_nieuwenhuis.faceosccomputercontrol.model;

/**
 *
 * @author Jeroen
 */
public class Face {
        
    private float leftEyebrowHeight = -1f;
    private float rightEyebrowHeight = -1f;
    private float mouthHeight = -1f;

    public float leftEyebrowUpTrigger = -1f;
    public float leftEyebrowDownTrigger = -1f;
    
    public float rightEyebrowUpTrigger = -1f;
    public float rightEyebrowDownTrigger = -1f;
    
    public float mouthOpenTrigger = -1f;
    public float mouthClosedTrigger = -1f;
    
    public Trigger updateLeftEyebrowHeight(float value){
        this.leftEyebrowHeight = value;
        if (leftEyebrowHeight > leftEyebrowUpTrigger){
            return Trigger.LEFT_EYEBROW_UP;
        } else if (leftEyebrowHeight < leftEyebrowDownTrigger) {
            return Trigger.LEFT_EYEBROW_DOWN;
        } else {
            return Trigger.NONE;
        }
    }
    
    public Trigger updateRightEyebrowHeight(float value){
        this.rightEyebrowHeight = value;
        if (rightEyebrowHeight > rightEyebrowUpTrigger){
            return Trigger.RIGHT_EYEBROW_UP;
        } else if (rightEyebrowHeight < rightEyebrowDownTrigger) {
            return Trigger.RIGHT_EYEBROW_DOWN;
        } else {
            return Trigger.NONE;
        }
    }
    
    public Trigger updateMouthHeight(float value){
        this.mouthHeight = value;
        if (mouthHeight > mouthOpenTrigger){
            return Trigger.MOUTH_OPEN;
        } else if (mouthHeight < mouthClosedTrigger) {
            return Trigger.MOUTH_CLOSED;
        } else {
            return Trigger.NONE;
        }
    }
}
