package core.logic;

import core.settings.AgentSettings;
import core.settings.EnvironmentSettings;
import core.settings.SimulationSettings;

import java.util.HashMap;


/**
 * Created by Joanna on 2014-11-24.
 */
public interface IDataProvider {
    public void initDataProvider(HashMap<String, Float> settings);
    public void updateConfigData(String path);
    public EnvironmentSettings getEnvironmentSettings();
    public AgentSettings getAgentsSettings();
    public SimulationSettings getSimulationSettings();
}
