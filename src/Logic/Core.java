package Logic;

import Events.SimulationEndEvent;
import Events.SimulationProgressEvent;
import Events.SimulationStartEvent;
import Agent.Agent;
import mock.GUI;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joanna on 2014-11-24.
 */
public class Core implements ICore {
    private GUI gui;
    private Simulation simulation;
    private DataProvider dataProvider;
    private EventBus eventBus;
    private boolean ready = false;



    @Override
    public void init() {
        this.createComponents();
        this.registerEvents();
        ready = true;
    }

    @Override
    @Subscribe public void startSimulationEventHandler(SimulationStartEvent event) {
        if(!simulation.isInProgress()) {
            this.loadSettings(event.getSettings());
            this.distributeData();
            simulation.start();
        }
    }

    @Override
    @Subscribe public void simulationProgressEventHandler(SimulationProgressEvent event) {
        //gui to powinno obsluzyc
    }

    @Override
    @Subscribe public void simulationEndEvent(SimulationEndEvent event) {

    }

    private void loadSettings(HashMap<String, Float> settings){
        dataProvider.initDataProvider(settings);
    }

    private void createComponents(){
        gui = new GUI();
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
        eventBus.register(gui);
    }

}
