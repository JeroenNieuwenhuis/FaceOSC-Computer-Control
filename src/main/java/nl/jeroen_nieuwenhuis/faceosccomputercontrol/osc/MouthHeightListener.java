/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jeroen_nieuwenhuis.faceosccomputercontrol.osc;

import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCMessage;
import java.util.Date;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.MainApp;

/**
 *
 * @author Jeroen
 */
public class MouthHeightListener implements OSCListener {
    
    MainApp app;
    
    public MouthHeightListener(MainApp app){
        this.app = app;
    }

    @Override
    public void acceptMessage(Date date, OSCMessage oscm) {
        app.updateMouthHeightCurrent((float) oscm.getArguments().get(0));
    }

}