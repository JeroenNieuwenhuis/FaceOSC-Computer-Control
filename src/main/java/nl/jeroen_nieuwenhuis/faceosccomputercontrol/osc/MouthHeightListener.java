/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jeroen_nieuwenhuis.faceosccomputercontrol.osc;

import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCMessage;
import java.util.Date;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.KeyPresser.KeyPresser;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.MainApp;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.model.Face;

/**
 *
 * @author Jeroen
 */
public class MouthHeightListener implements OSCListener {
    
    Face face;
    KeyPresser presser;
    
    public MouthHeightListener(Face face, KeyPresser presser){
        this.face = face;
        this.presser = presser;
    }

    @Override
    public void acceptMessage(Date date, OSCMessage oscm) {
        presser.pressKey(face.updateMouthHeight((float) oscm.getArguments().get(0)));
    }

}
