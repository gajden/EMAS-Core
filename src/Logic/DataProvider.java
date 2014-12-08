package Logic;

import Logic.IDataProvider;
import Settings.AgentSettings;
import Settings.DataForGui;
import Settings.EnvironmentSettings;
import Settings.SimulationSettings;

import java.util.Map;

/**
 * Created by Joanna on 2014-11-25.
 */
public class DataProvider implements IDataProvider {
    private AgentSettings agentSettings;
    private EnvironmentSettings environmentSettings;
    private SimulationSettings simulationSettings;
    private DataForGui dataForGui;

    @Override
    public void initDataProvider() {

    }

    @Override
    public void updateConfigData(String path) {

    }

    @Override
    public EnvironmentSettings getEnvironmentSettings() {
        return null;
    }

    @Override
    public AgentSettings getAgentsSettings() {
        return null;
    }

    @Override
    public void updateDataForGui(DataForGui data) {

    }

    @Override
    public SimulationSettings getSimulationSettings() {
        return null;
    }
}
