import sun.management.Agent;

/**
 * Created by Joanna on 2014-11-25.
 */
public class Simulation implements ISimulation {
    private Environment environment;
    private DataProvider dataProvider;
    private Agent agent;
    private boolean simulationInProgress = false;
    private int iterations;
    private int currentIteration;

    @Override
    public void start(DataProvider dataProvider) {
        simulationInProgress = true;
        this.dataProvider = dataProvider;
        this.setEnvironment();
        this.evolution();
    }

    @Override
    public void currentState() {

    }

    @Override
    public boolean inProgress() {
        return simulationInProgress;
    }

    private void setEnvironment(){
        environment = new Environment();
        environment.create(dataProvider.getEnvironmentSettings());
        this.fillEnvironment();
    }

    private void fillEnvironment(){
        agent = new Agent(dataProvider.getAgentsSettings());
        environment.getFirst();
        while (environment.hasNext()){
            environment.setAgent(agent.newAgent());
            environment.getNext();
        }
    }

    private void evolution(){
        while (currentIteration < iterations && !agent.goodEnough(environment.getBest())){
            this.iterateIslands();
            ++currentIteration;
        }
        this.simulationInProgress = false;
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
            environment.setAgent(this.chooseAction(environment.getCurrent()));
        }
    }

    private void chooseAction(Agent agent){
        lol
    }
}
