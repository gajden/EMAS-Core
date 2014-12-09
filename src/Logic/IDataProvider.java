package Logic;

import Settings.AgentSettings;
import Settings.DataForGui;
import Settings.EnvironmentSettings;
import Settings.SimulationSettings;

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
