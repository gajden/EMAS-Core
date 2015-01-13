package core.logic;

import core.logic.IDataProvider;
import core.settings.AgentSettings;
import core.settings.EnvironmentSettings;
import core.settings.SimulationSettings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joanna on 2014-11-25.
 */
public class DataProvider implements IDataProvider {
    private AgentSettings agentSettings;
    private EnvironmentSettings environmentSettings;
    private SimulationSettings simulationSettings;
    private Map<String, Double> settings;

    public DataProvider(){
    	this.agentSettings = new AgentSettings();
    	this.environmentSettings = new EnvironmentSettings();
    	this.simulationSettings = new SimulationSettings();
    	this.settings = new HashMap<String, Double>();
    }
    
    
    @Override
    public void initDataProvider(Map<String, Double> settings) {
        this.settings = settings;
        this.sortSettings();
    }

    @Override
    public void updateConfigData(String path) {

    }

    @Override
    public EnvironmentSettings getEnvironmentSettings() {
        return environmentSettings;
    }

    @Override
    public AgentSettings getAgentsSettings() {
        return agentSettings;
    }

    @Override
    public SimulationSettings getSimulationSettings() {
        return simulationSettings;
    }

    private void sortSettings(){
        this.extractSimulationSettings();
        this.extractAgentSettings();
        this.extractEnvironmentSettings();
    }

    private void extractAgentSettings(){
        if(settings.containsKey("energyOnStart"))
            agentSettings.setEnergyOnStart(settings.get("energyOnStart"));
        else
            agentSettings.setDefaultEnergyOnStart();


        if(settings.containsKey("energyLossFactor"))
            agentSettings.setEnergyLossFactor(settings.get("energyLossFactor"));
        else
            agentSettings.setDefaultLossFactor();
        
        if(settings.containsKey("minEnergy"))
            agentSettings.setMinEnergy(settings.get("minEnergy"));
        else
            agentSettings.setDefaultMinEnergy();

    }

    private void extractEnvironmentSettings(){
        if(settings.containsKey("numberOfIslands"))
            environmentSettings.setNumberOfIslands(settings.get("numberOfIslands").intValue());
        else
            environmentSettings.setDefaultNumberOfIslands();

        if(settings.containsKey("numberOfAgents"))
            environmentSettings.setNumberOfAgents(settings.get("numberOfAgents").intValue());
        else
            environmentSettings.setDefaultNumberOfAgents();

    }

    private void extractSimulationSettings(){
        if(settings.containsKey("iterations"))
            simulationSettings.setIterations(settings.get("iterations").intValue());
        else
            simulationSettings.setDefaultIterations();
    }
}
