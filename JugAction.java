/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cm3038.search.*;

/**
 *
 * @author Fatima Ghanduri
 * * This class is used to define the sections that will be used in the project
 */
public class JugAction extends Action{
 
    private JugState oldState;
    private JugState newState;
    private final double ACTION_COST;
    private int selectJug;
         
//creating the constructor
    public JugAction(JugState oldState, int selectJug, int selectAction) { 
        
        this.oldState = oldState;
        
        this.selectJug = selectJug;
        
  //the cost of each action

        if (selectAction == 0) { 
            this.ACTION_COST = 2.0;
        } 
        else if (selectAction == 1) {
            this.ACTION_COST = 1.0;
        } 
        else {
            this.ACTION_COST = 10.0;
        }
    }
    
    public JugState applyAction() {
        //apply action method creats a before and after variables. 
        //this method has an old state and a new state
        //this method also defines based on the action cost the selected jug
 
        int jugANew, jugBNew, differenceBeforeAfter;
        
        //if the cost was equal totwo rhen it would set the old state and the new state
        //this is done for all the costs 
        //this is also  
            if (ACTION_COST == 2.0) {
  
                if (selectJug == 1) {
                  
                    jugANew = oldState.getJugAMaximum();
                    jugBNew = oldState.getJugB();
                    newState = new JugState(jugANew, jugBNew, oldState.getJugAMaximum(), oldState.getJugBMaximum());
                    differenceBeforeAfter = jugANew - oldState.getJugA();
                    cost = ACTION_COST * differenceBeforeAfter;
                }
                else {
                    jugANew = oldState.getJugA();
                    jugBNew = oldState.getJugBMaximum();
                    newState = new JugState(jugANew, jugBNew, oldState.getJugAMaximum(), oldState.getJugBMaximum());
                    differenceBeforeAfter = jugBNew - oldState.getJugB();
                    cost = ACTION_COST * differenceBeforeAfter;
                }
            } else if (ACTION_COST == 1.0) {
                if (selectJug == 1) {
                    if (((oldState.getJugA() == 0) && (oldState.getJugB() == 0)) || (oldState.getJugA() == oldState.getJugAMaximum())) {
   
                    } else if ((oldState.getJugA() + oldState.getJugB()) > oldState.getJugAMaximum()) {
                        
                       
                        differenceBeforeAfter = oldState.getJugAMaximum() - oldState.getJugA();
                        
                        jugBNew = oldState.getJugB() - differenceBeforeAfter;
               
                        jugANew = oldState.getJugA() + differenceBeforeAfter;
                 
                        newState = new JugState(jugANew, jugBNew, oldState.getJugAMaximum(), oldState.getJugBMaximum());
              
                        cost = ACTION_COST;
                    }
                    else {
                     
                        differenceBeforeAfter = oldState.getJugB();
                      
                        jugANew = oldState.getJugA() + differenceBeforeAfter;
                    
                        jugBNew = 0;
                       
                        newState = new JugState(jugANew, jugBNew, oldState.getJugAMaximum(), oldState.getJugBMaximum()); 
                      
                        cost = ACTION_COST;
                    }
                } else {
                 
                    if (((oldState.getJugA() == 0) && (oldState.getJugB() == 0)) || (oldState.getJugB() == oldState.getJugBMaximum())) {
                    
                    } else if ((oldState.getJugA() + oldState.getJugB()) > oldState.getJugBMaximum()) {
                        
                        differenceBeforeAfter = oldState.getJugBMaximum() - oldState.getJugB();
                  
                        jugANew = oldState.getJugA() - differenceBeforeAfter;
                        
                        jugBNew = oldState.getJugB() + differenceBeforeAfter;
                        newState = new JugState(jugANew, jugBNew, oldState.getJugAMaximum(), oldState.getJugBMaximum());

                        cost = ACTION_COST;
                    }
                    else {
                        
                        differenceBeforeAfter = oldState.getJugA();
                        
                        jugBNew = oldState.getJugB() + differenceBeforeAfter;
                        
                        jugANew = 0;
                       
                        newState = new JugState(jugANew, jugBNew, oldState.getJugAMaximum(), oldState.getJugBMaximum()); 
                        
                        cost = ACTION_COST;
                    }
                }
                    
            }
            else {//the action cost is found where it wold be multiplied by the difference between the before and the after
                if (selectJug == 1) {
                                       differenceBeforeAfter = oldState.getJugA();
                    cost = ACTION_COST * differenceBeforeAfter;
                    jugANew = 0;
                    jugBNew = oldState.getJugB();
                    newState = new JugState(jugANew, jugBNew, oldState.getJugAMaximum(), oldState.getJugBMaximum());
                }
                else {
                    differenceBeforeAfter = oldState.getJugB();
                    cost = ACTION_COST * differenceBeforeAfter;
                    jugBNew = 0;
                    jugANew = oldState.getJugA();
                    newState = new JugState(jugANew, jugBNew, oldState.getJugAMaximum(), oldState.getJugBMaximum());
                }
            }
    //returning the new state
    return newState;
    }
    
        @Override
    public String toString() {
     String tester = "";
     return tester;
    }

}
