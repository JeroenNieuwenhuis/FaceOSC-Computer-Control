/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jeroen_nieuwenhuis.faceosccomputercontrol.model;

import nl.jeroen_nieuwenhuis.faceosccomputercontrol.KeyPresser.KeyPresser;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.MainApp;

/**
 *
 * @author Jeroen
 */
public class Face {

    private MainApp app;
    private KeyPresser presser;

    public Face(MainApp app, KeyPresser presser) {
        this.app = app;
        this.presser = presser;
    }

    private float leftEyebrowHeight = -1f;
    private float rightEyebrowHeight = -1f;
    private float mouthHeight = -1f;

    public float leftEyebrowUpTrigger = -1f;
    public float leftEyebrowDownTrigger = -1f;

    public float rightEyebrowUpTrigger = -1f;
    public float rightEyebrowDownTrigger = -1f;

    public float mouthOpenTrigger = -1f;
    public float mouthClosedTrigger = -1f;
    
    public boolean leftEyebrowUpTriggered = false;
    public boolean leftEyebrowDownTriggered = false;

    public boolean rightEyebrowUpTriggered = false;
    public boolean rightEyebrowDownTriggered = false;

    public boolean mouthOpenTriggered = false;
    public boolean mouthClosedTriggered = false;

    private boolean enabled = false;

    public boolean enable() {
        if (isReady()) {
            this.enabled = true;
        }
        return this.enabled;
    }

    public void disable() {
        this.enabled = false;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isReady() {
        return leftEyebrowHeight != -1f && rightEyebrowHeight != -1f && mouthHeight != -1f
                && leftEyebrowUpTrigger != -1f && leftEyebrowDownTrigger != -1f
                && rightEyebrowUpTrigger != -1f && rightEyebrowDownTrigger != -1f
                && mouthOpenTrigger != -1f && mouthClosedTrigger != -1f;
    }

    public Trigger updateLeftEyebrowHeight(float value) {
        this.leftEyebrowHeight = value;
        app.updateLeftEyebrowCurrent(value);
        
        if (enabled) {
            if (leftEyebrowHeight > leftEyebrowUpTrigger && !leftEyebrowUpTriggered) {
                leftEyebrowUpTriggered = true;
                return Trigger.LEFT_EYEBROW_UP;
            } else if (leftEyebrowHeight < leftEyebrowDownTrigger && ! leftEyebrowDownTriggered) {
                leftEyebrowDownTriggered = true;
                return Trigger.LEFT_EYEBROW_DOWN;
            } else if (leftEyebrowHeight > leftEyebrowDownTrigger && leftEyebrowHeight < leftEyebrowUpTrigger){
                if (leftEyebrowUpTriggered){
                    leftEyebrowUpTriggered = false;
                    return Trigger.LEFT_EYEBROW_UP_RELEASED;
                } else if (leftEyebrowDownTriggered){
                    leftEyebrowDownTriggered = false;
                    return Trigger.LEFT_EYEBROW_DOWN_RELEASED;
                }
            }
        }
        return Trigger.NONE;
    }

    public Trigger updateRightEyebrowHeight(float value) {
        app.updateRightEyebrowCurrent(value);
        this.rightEyebrowHeight = value;
        
        if (enabled) {
            if (rightEyebrowHeight > rightEyebrowUpTrigger && !rightEyebrowUpTriggered) {
                rightEyebrowUpTriggered = true;
                return Trigger.RIGHT_EYEBROW_UP;
            } else if (rightEyebrowHeight < rightEyebrowDownTrigger && ! rightEyebrowDownTriggered) {
                rightEyebrowDownTriggered = true;
                return Trigger.RIGHT_EYEBROW_DOWN;
            } else if (rightEyebrowHeight > rightEyebrowDownTrigger && rightEyebrowHeight < rightEyebrowUpTrigger){
                if (rightEyebrowUpTriggered){
                    rightEyebrowUpTriggered = false;
                    return Trigger.RIGHT_EYEBROW_UP_RELEASED;
                } else if (rightEyebrowDownTriggered){
                    rightEyebrowDownTriggered = false;
                    return Trigger.RIGHT_EYEBROW_DOWN_RELEASED;
                }
            }
        }
        return Trigger.NONE;
    }

    public Trigger updateMouthHeight(float value) {
        app.updateMouthHeightCurrent(value);
        this.mouthHeight = value;
        
        if (enabled) {
            if (mouthHeight > mouthOpenTrigger && !mouthOpenTriggered) {
                mouthOpenTriggered = true;
                mouthClosedTriggered = false;
                return Trigger.MOUTH_OPEN;
            } else if (mouthHeight < mouthClosedTrigger && !mouthClosedTriggered) {
                mouthClosedTriggered = true;
                mouthOpenTriggered = false;
                return Trigger.MOUTH_CLOSED;
            }
        }
        return Trigger.NONE;
    }
}
