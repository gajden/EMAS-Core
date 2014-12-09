package Logic;

import Settings.EnvironmentSettings;
import Settings.SimulationSettings;
import com.google.common.eventbus.EventBus;

/**
 * Created by Joanna on 2014-11-24.
 */
public interface ISimulation {
    public void init(DataProvider dataProvider, EventBus eventBus);
    public void start();
    public boolean isInProgress();
}
