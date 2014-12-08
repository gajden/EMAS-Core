package Logic;

import Settings.AgentSettings;
import Settings.DataForGui;
import Settings.EnvironmentSettings;
import Settings.SimulationSettings;


/**
 * Created by Joanna on 2014-11-24.
 */
public interface IDataProvider {
    public void initDataProvider();
    public void updateConfigData(String path);
    public EnvironmentSettings getEnvironmentSettings();
    public AgentSettings getAgentsSettings();
    public void updateDataForGui(DataForGui data);
    public SimulationSettings getSimulationSettings();
}
