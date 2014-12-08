package Logic;

import Events.SimulationEndEvent;
import Events.SimulationProgressEvent;
import Events.SimulationStartEvent;

/**
 * Created by Joanna on 2014-11-24.
 */
public interface ICore {
    public void init();
    public void startSimulationEventHandler(SimulationStartEvent event);
    public void simulationProgressEventHandler(SimulationProgressEvent event);
    public void simulationEndEvent(SimulationEndEvent event);
}
