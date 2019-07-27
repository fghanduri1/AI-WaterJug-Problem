/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import cm3038.search.State;
import cm3038.search.*;
import java.util.*;


/**
 *JugA is described in the report as jug3 and JugB is described in the report as jug5
 * @author Fatima Ghanduri 
 * this implements the state class which
 */
public class JugState  implements State {
    private final int jugA;
    private final int jugB;
    private final int jugAMaximum;
    private final int jugBMaximum;
 
    //setters
    public JugState(int jugA, int jugB, int jugAMaximum, int jugBMaximum) {
        
        this.jugA = jugA;
        this.jugB = jugB;
        this.jugAMaximum = jugAMaximum;
        this.jugBMaximum = jugBMaximum;
    }
    //    JugState(int jugANew, int jugBNew, int jugAMax, int jugBMax) {
        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //    }
//getters 
    public int getJugA() {
        return jugA;
    }
    
    public int getJugB() {
        return jugB;
    }
    
    public int getJugAMaximum() {
        return jugAMaximum;
    }
    
    public int getJugBMaximum() {
        return jugBMaximum;
    }

    //creating this equals method to distiguish is the goalstate has been reached
    public boolean equals(Object o) {
        
        boolean isEqual;
       
        if (!(o instanceof JugState)) {
            isEqual = false;
            

        } else {
 
                JugState newProbelemState = (JugState)o;
                isEqual = (this.getJugA() == newProbelemState.getJugA() && (this.getJugB() == newProbelemState.getJugB()));
                
                }
        return isEqual;
    }

    public int hashCode() {
        
        int hashVariable = (this.getJugA() + this.getJugB() + (this.getJugAMaximum() + this.getJugBMaximum()));
        return hashVariable;
    }

    //the successor method
    //Successor of an input node can also be defined as the node with the smallest key greater than the key of input node.
    @Override
    public List<ActionStatePair> successor() {
        
 
        List<ActionStatePair> actionStateList = new ArrayList<>();

        if (this.getJugA() < this.getJugAMaximum()) {
            JugAction fillTapA = new JugAction(this, 1, 0);  
            ActionStatePair actionTapA = new ActionStatePair(fillTapA, fillTapA.applyAction());
 
            actionStateList.add(actionTapA);
        }

        if (this.getJugA() > 0) {

            JugAction emptyA = new JugAction(this, 1, 2);  

            ActionStatePair actionEmptyA = new ActionStatePair(emptyA, emptyA.applyAction());
     
            actionStateList.add(actionEmptyA);
        }
       
        if (this.getJugB() < this.getJugBMaximum()) { 
            JugAction fillTapB = new JugAction(this, 2, 0);  
            ActionStatePair actionTapB = new ActionStatePair(fillTapB, fillTapB.applyAction());

            actionStateList.add(actionTapB); 
        }

        if (this.getJugB() > 0) {
            JugAction emptyB = new JugAction(this, 2, 2); 
            ActionStatePair actionEmptyB = new ActionStatePair(emptyB, emptyB.applyAction());
            actionStateList.add(actionEmptyB);
        }
        
        
        if ((this.getJugA() < this.getJugAMaximum()) && (this.getJugB() > 0)) {
            JugAction pourB = new JugAction(this, 1, 1);  
            ActionStatePair actionPourB = new ActionStatePair(pourB, pourB.applyAction());
            actionStateList.add(actionPourB);
        }
 
        if ((this.getJugB() < this.getJugBMaximum()) && (this.getJugA() > 0)) {
            JugAction pourA = new JugAction(this, 2, 1);  
            ActionStatePair actionPourA = new ActionStatePair(pourA, pourA.applyAction());

            actionStateList.add(actionPourA);
        }
        
        return actionStateList;
    }
    //strimng method
    @Override
    public String toString() {
     String tester = "";
     return tester;
    }
    

}
