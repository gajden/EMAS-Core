package Events;

import Settings.SimulationSettings;

/**
 * Created by Joanna on 2014-12-02.
 */
public class SimulationStartEvent {
    private SimulationSettings settings;

    public void setSettings(SimulationSettings settings){
        this.settings = settings;
    }

    public SimulationSettings getSettings(){
        return settings;
    }
}
