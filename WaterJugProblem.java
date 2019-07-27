/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import cm3038.search.Node;
import cm3038.search.State;
import cm3038.search.informed.BestFirstSearchProblem;
import cm3038.search.*;
import java.util.*;

/**
 *This class creates a heuristic function and returns it through the isGoal method
 * @author Fatima Ghanduri
 */
public class WaterJugProblem extends BestFirstSearchProblem{
    public WaterJugProblem (State initialState, State goalState) {
        super(initialState, goalState);
    }
    
    public double heuristicSearch(State theCurrentState) {//creats the heuristic function
        
        JugState problemState = (JugState)theCurrentState;
        JugState problemGoal = (JugState)this.goalState;
        
        int diffJugA = Math.abs(problemState.getJugA() - probGoal.getJugA());
        int diffJugB = Math.abs(problemState.getJugB() - probGoal.getJugB());
        double heuristic = (diffJugA+diffJugB) - 1;
        
        return heuristic;
    }
    //the evaluation node gettingthe cost
    public double evaluation(Node node) {//node cost is defined
        double evaluation = node.getCost() + this.heuristicSearch(node.state);
        return evaluation;
    }
    //the goal is reached at this state
    public boolean isGoal(State state) {
        boolean goalReached = state.equals(this.goalState);
        return goalReached;
    }

 




}
