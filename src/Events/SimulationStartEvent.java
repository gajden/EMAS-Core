package Events;

import Settings.SimulationSettings;

import java.util.HashMap;

/**
 * Created by Joanna on 2014-12-02.
 */
public class SimulationStartEvent {
    private HashMap<String, Float> settings;

    public void setSettings(HashMap<String, Float> settings){
        this.settings = settings;
    }

    public HashMap<String, Float> getSettings(){
        return settings;
    }
}
