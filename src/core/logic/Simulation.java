package core.logic;

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
    private Environment environment;
    private EnvironmentSettings environmentSettings;
    private boolean inProgress = false;
    private SimulationSettings simulationSettings;
    private int currentIteration;
    private AgentFactory agentFactory;
    private AgentSettings agentSettings;


    @Override
    public void init(DataProvider dataProvider) {
    	SimpleFunctionFitnessProxy asdasd = new SimpleFunctionFitnessProxy(new SimpleFunction());
    	this.simulationSettings = dataProvider.getSimulationSettings();
        this.environmentSettings = dataProvider.getEnvironmentSettings();
        this.currentIteration = 1;
        this.agentFactory = new AgentFactory(dataProvider.getAgentsSettings().getEnergyLossFactor(), 
				dataProvider.getAgentsSettings().getEenotypeRandomnessFactor(), 
				dataProvider.getAgentsSettings().getEnergyOnStart(), 
				asdasd);
        this.setEnvironment();        
        
        //this.evolution();
        //System.out.println("ile iteracji: " + this.simulationSettings.getIterations() + ", current Iteration: " + this.currentIteration);
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
    		//System.out.println("Wybrano wyspe: " + (i+1));    		
    		for(int j = 0; j < environmentSettings.getNumberOfAgents(); j++){
    			environment.setAgent(this.agentFactory.createAgent());
    			//System.out.println(environment.getCurrent().getEnergy());
    			//System.out.println("dodano dziada!");
    		}
    		//System.out.println("Wypelniono wyspe: " + (i+1));
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
            //this.iterateAgents(); //wykomentowane bo sie sypie
        }
    }

    private void iterateAgents(){
        environment.getFirst();
        while(environment.hasNext()){
            this.chooseAction(environment.getCurrent(), environment.getNeighbours());
        }
    }

    private void chooseAction(Agent agent, Agent[] neighbours){
        Agent fightCandidate = neighbours[0];
        for(int i = 1; i < neighbours.length; i++){
            if(fightCandidate.getFitness() > neighbours[i].getFitness()){ //tu sie sypie
                fightCandidate = neighbours[i];
                
            }
        }
        agent.fight(fightCandidate);

        if(environment.getCurrent().getEnergy() < agentSettings.getMinEnergy())
            try {
                environment.setAgent(agentFactory.createAgent());
            }catch (Exception e){ }
        else if(fightCandidate.getEnergy() <  agentSettings.getMinEnergy()){

        }

    }

    private void generateStatistics(){
    	System.out.println("Generuje jakies tam statystyki jeszcze nie wiem jakie.");
    }
}
