/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import cm3038.search.Path;

/**
 *this class runs the method and displays them to the user
 * in this class, the jug states can be implemented and changed by their size and their valus in the JugState initialState 
 * and in the JugState goalState. 
 * @author Fatima Ghanduri 
 */
public class Main {

public static int jugAMax, jugBMax, jugAInt, jugBInt, jugAGoal, jugBGoal; 
    
    public static void main(String[] args) {
 
        //enter the inital state
        JugState initialState = new JugState(0, 0, 5, 3);
        //enter the goal state here
        JugState goalState = new JugState(4, 0, 5, 3);
        System.out.println("The states entered:");
        System.out.println(initialState.toString());//initial state
        System.out.println(goalState.toString());//goal state
 
        jugAMax = 5;
        jugBMax = 3;
        jugAInt = 0;
        jugBInt = 0;
        jugAGoal = 4;
        jugBGoal = 0;
        
        //JugState initialState = new JugState(jugAInt, jugBInt, jugAMax, jugBMax);
        //JugState goalState = new JugState(jugAGoal, jugBGoal, jugAMax, jugBMax);
        
        System.out.println("Going from " + jugAInt + " (A) " + jugBInt + " (B)" +  " to " + jugAGoal + " (A) " + jugBGoal + " (B) ");
        
        WaterJugProblem s = new WaterJugProblem(initialState, goalState);
        
        Path solution = s.search();
        System.out.println("Search is Finished");
        
        if (solution == null) {
            System.out.println("No Solution has beenFound");
        } else {
            System.out.println("Solution Found");
            System.out.println("\n The Nodes that have been Searched are " + s.nodeVisited + ", and total cost is  " + solution.cost);
            solution.print();
        }
        
        
			//WaterJugRun JugRun = new cm3038CWGhanduriFatima1602571();
			//JugRun.generateJugSets();
			
			//WaterJugRun JugRun = new cm3038CWGhanduriFatima1602571();
//JugRun.generateJugSets();



//Search search = new IterativeDeepeningSearch();
//SearchAgent agent = new SearchAgent(problem, search);
//List<Action> actions = agent.getActions();
//System.out.println(actions);
//System.out.println("IDS PathCost: " + search.getMetrics().get(QueueSearch.ACTION_COST));
//System.out.println("IDS Nodes Expanded: " + search.getMetrics().get(QueueSearch.METRIC_NODES_EXPANDED));


        
    }
    
}


