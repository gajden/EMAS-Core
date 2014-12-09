package Logic;

import Settings.EnvironmentSettings;
import Settings.SimulationSettings;
import Agent.Agent;
import com.google.common.eventbus.EventBus;

/**
 * Created by Joanna on 2014-11-25.
 */
public class Simulation implements ISimulation {
    private Environment environment;
    private EnvironmentSettings environmentSettings;
    private boolean inProgress = false;
    private SimulationSettings simulationSettings;
    private int currentIteration;
    private EventBus eventBus;


    @Override
    public void init(DataProvider dataProvider, EventBus eventBus) {
        this.eventBus = eventBus;
        this.environmentSettings = dataProvider.getEnvironmentSettings();
        this.setEnvironment();
        this.evolution();
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
        environment.create(environmentSettings);
        this.fillEnvironment();
    }

    private void fillEnvironment(){
        environment.getFirst();
        while (environment.hasNext()){
            environment.setAgent(new Agent());
            environment.getNext();
        }
    }

    private void evolution(){
        while (currentIteration < simulationSettings.getIterations()){
            this.iterateIslands();
            ++currentIteration;
            this.generateStatistics();
        }
        this.inProgress = false;
    }

    private void iterateIslands(){
        int islands = environment.getNumberOfIslands();
        for (int i = 0; i < islands; ++i){
            environment.chooseIsland(i);
            this.iterateGrid();
        }
    }

    private void iterateGrid(){
        environment.getFirst();
        while(environment.hasNext()){
            this.chooseAction(environment.getCurrent(), environment.getNeighbours());
        }
    }

    private void chooseAction(Agent agent, Agent[] neighbours){
        Agent temp = neighbours[0];
        for(int i = 1; i < neighbours.length; i++){
            if(!temp.better(neighbours[i])){
                temp = neighbours[i];
            }
        }

    }

    private void generateStatistics(){

    }
}
