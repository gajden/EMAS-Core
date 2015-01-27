package core.logic;

import gui.java.Stack;

import java.util.LinkedList;

import core.settings.AgentSettings;
import core.settings.EnvironmentSettings;
import core.settings.SimulationSettings;
import agent.agent.Agent;
import agent.agent.AgentFactory;
import agent.exceptions.WrongGenotypeException;
import agent.fitness_evaluator.SimpleFunctionFitnessProxy;
import agent.function.SimpleFunction;

/**
 * Created by Joanna on 2014-11-25.
 */
public class Simulation implements ISimulation {
	double inf = Double.POSITIVE_INFINITY;
	private double bestFitness = inf;
    private Environment environment;
    private EnvironmentSettings environmentSettings;
    private boolean inProgress = false;
    private SimulationSettings simulationSettings;
    private int currentIteration;
    private AgentFactory agentFactory;
    private AgentSettings agentSettings;
    private Stack stack;
    
    public Simulation(Stack s){
    	this.stack=s;
    }

    @Override
    public void init(DataProvider dataProvider) {
    	SimpleFunctionFitnessProxy asdasd = new SimpleFunctionFitnessProxy(new SimpleFunction());
    	this.simulationSettings = dataProvider.getSimulationSettings();
        this.environmentSettings = dataProvider.getEnvironmentSettings();
        this.currentIteration = 1;
        this.agentSettings = dataProvider.getAgentsSettings();
        this.agentFactory = new AgentFactory(dataProvider.getAgentsSettings().getEnergyLossFactor(), 
				dataProvider.getAgentsSettings().getEenotypeRandomnessFactor(), 
				dataProvider.getAgentsSettings().getEnergyOnStart(), 
				asdasd);
        this.setEnvironment();
    }

    @Override
    public void start() {
        this.evolution();
    }

    @Override
    public boolean isInProgress(){
        return inProgress;
    }

    private void setEnvironment(){
        environment = new Environment();
        environment.create(this.environmentSettings);
        try {
			this.fillEnvironment();
		} catch (WrongGenotypeException e) {
			e.printStackTrace();
		}
    }

    private void fillEnvironment() throws WrongGenotypeException{
    	for(int i=0; i < environmentSettings.getNumberOfIslands(); i++){
    		environment.chooseIsland(i);    		
    		for(int j = 0; j < environmentSettings.getNumberOfAgents(); j++){
    			environment.setAgent(this.agentFactory.createAgent());
    		}
    		environment.resetCurrent();
    	}
    }

    private void evolution(){
        while (this.currentIteration <= this.simulationSettings.getIterations()){
            this.iterateIslands();
            if( ( this.currentIteration % this.simulationSettings.getIterationStat() ) == 0)
            {
            	this.generateStatistics();
            }
            ++currentIteration;
        }
        this.inProgress = false;
    }

    private void iterateIslands(){
        int islands = environment.getNumberOfIslands();
        for (int i = 0; i < islands; ++i){
            environment.chooseIsland(i);
            this.iterateAgents();
        }
    }

    private void iterateAgents(){
        environment.getFirst();
        while(environment.hasNext()){
            this.chooseAction(environment.getCurrent(), environment.getNeighbours());
        }
    }

<<<<<<< HEAD
    private void chooseAction(Agent agent, Agent[] neighbours){
        if (agent != null){

            if(neighbours.length > 1){
                if(!tryCrossing(agent, neighbours[0]))
                    if(!tryCrossing(agent, neighbours[1]))
                        agent.fight(neighbours[0]);

            }else if (neighbours.length == 1){
                if(neighbours[0] != null)
                    if(!tryCrossing(agent, neighbours[0])){
                        agent.fight(neighbours[0]);
                    }
            }
        }

        checkForDead(agent, neighbours);
    }

    private boolean tryCrossing(Agent agent1, Agent agent2){
        if(agent1.getEnergy() >= agentSettings.getCrossingMinEnergy() && agent2.getEnergy() >= agentSettings.getCrossingMinEnergy()){
=======
    private void chooseAction(Agent agent, LinkedList<Agent> linkedList){
        Agent fightCandidate = linkedList.getFirst();
        for(Agent ag : linkedList){
        	fightCandidate = ag;
            if(fightCandidate.getFitness() > ag.getFitness()){
                fightCandidate = ag;
            }
        }
        agent.fight(fightCandidate);
        if(agent.getFitness() < this.bestFitness) this.bestFitness=agent.getFitness();
        if(fightCandidate.getFitness() < this.bestFitness) this.bestFitness=fightCandidate.getFitness();
        
        if(environment.getCurrent().getEnergy() < agentSettings.getMinEnergy())
>>>>>>> origin/collaboration
            try {
                environment.tryPut(agent1.hybridize(agent2));
            }catch (Exception e){}
            return true;
        } else
            return false;
    }

<<<<<<< HEAD
    private void checkForDead(Agent agent, Agent[] agents){

=======
        }
>>>>>>> origin/collaboration
    }

    private void generateStatistics(){
   		this.stack.push("iteracja="+this.currentIteration + ",bestFitness=" + this.bestFitness);
    }
}
