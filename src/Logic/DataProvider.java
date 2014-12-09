package Logic;

import Logic.IDataProvider;
import Settings.AgentSettings;
import Settings.DataForGui;
import Settings.EnvironmentSettings;
import Settings.SimulationSettings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joanna on 2014-11-25.
 */
public class DataProvider implements IDataProvider {
    private AgentSettings agentSettings;
    private EnvironmentSettings environmentSettings;
    private SimulationSettings simulationSettings;
    private DataForGui dataForGui;
    private Map<String, Float> settings;

    @Override
    public void initDataProvider(HashMap<String, Float> settings) {
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

    @Override
    public void updateDataForGui(DataForGui data) {

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
