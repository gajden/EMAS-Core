package core.logic;

import core.settings.AgentSettings;
import core.settings.EnvironmentSettings;
import core.settings.SimulationSettings;

import java.util.Map;


/**
 * Created by Joanna on 2014-11-24.
 */
public interface IDataProvider {
    public void initDataProvider(Map<String, Double> settings);
    public EnvironmentSettings getEnvironmentSettings();
    public AgentSettings getAgentsSettings();
    public SimulationSettings getSimulationSettings();
}
