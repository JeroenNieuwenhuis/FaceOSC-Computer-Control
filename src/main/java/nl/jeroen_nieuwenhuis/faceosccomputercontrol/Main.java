/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jeroen_nieuwenhuis.faceosccomputercontrol;

import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPort;
import com.illposed.osc.OSCPortIn;
import java.net.SocketException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.jeroen_nieuwenhuis.faceosccomputercontrol.osc.OSCPortInNotDamon;

/**
 *
 * @author Jeroen
 */
public class Main {
    public static void main(String[] args){
        try {
            OSCPortInNotDamon receiver = new OSCPortInNotDamon(8338);
            OSCListener listener = new OSCListener() {
                public void acceptMessage(java.util.Date time, OSCMessage message) {
                    System.out.println(message.getArguments().get(0));
                }
            };
            receiver.addListener("/gesture/eyebrow/right", listener);
            receiver.startListening();
        } catch (SocketException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Main(){
        try {
            OSCPortIn receiver = new OSCPortIn(8338);
            receiver.addListener("/found", new FoundListener());
            System.out.println("start");
            receiver.startListening();
            System.out.println("stop");
            
        } catch (SocketException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private class FoundListener implements OSCListener {
        
        @Override
        public void acceptMessage(Date date, OSCMessage oscm) {
            System.out.println(oscm.toString());
        }
    }
}
