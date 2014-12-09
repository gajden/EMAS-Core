package Logic;

import Events.SimulationEndEvent;
import Events.SimulationProgressEvent;
import Events.SimulationStartEvent;
import Agent.Agent;
import mock.GUI;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Created by Joanna on 2014-11-24.
 */
public class Core implements ICore {
    private GUI gui;
    private Agent agent;
    private Simulation simulation;
    private DataProvider dataProvider;
    private EventBus eventBus;
    private boolean ready = false;



    @Override
    public void init() {
        this.createComponents();
        this.loadConfig();
        this.registerEvents();
    }

    @Override
    @Subscribe public void startSimulationEventHandler(SimulationStartEvent event) {
        if(!simulation.isInProgress()) {
            this.loadSettings();
            this.distributeData();
            simulation.start();
        }
    }

    @Override
    @Subscribe public void simulationProgressEventHandler(SimulationProgressEvent event) {

    }

    @Override
    @Subscribe public void simulationEndEvent(SimulationEndEvent event) {

    }

    private void loadSettings(){
        dataProvider.initDataProvider();
    }

    private void loadConfig(){

    }

    private void createComponents(){
        //gui = new GUI();
        simulation = new Simulation();
        dataProvider = new DataProvider();
        eventBus = new EventBus();
    }

    private void distributeData(){
        simulation.init(dataProvider, eventBus);
    }

    private void registerEvents(){
        eventBus.register(this);
        eventBus.register(simulation);
    }

}
