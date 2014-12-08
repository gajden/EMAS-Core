package Logic;

import Settings.EnvironmentSettings;
import Settings.SimulationSettings;

/**
 * Created by Joanna on 2014-11-24.
 */
public interface ISimulation {
    public void init(DataProvider dataProvider);
    public void start();
}
