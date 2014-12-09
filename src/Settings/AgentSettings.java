package Settings;

/**
 * Created by Joanna on 2014-12-02.
 */
public class AgentSettings {
    private float energyOnStart;
    private float energyLossFactor;


    public float getEnergyLossFactor() {
        return energyLossFactor;
    }

    public void setEnergyLossFactor(float energyLossFactor) {
        this.energyLossFactor = energyLossFactor;
    }

    public float getEnergyOnStart() {
        return energyOnStart;
    }

    public void setEnergyOnStart(float energyOnStart) {
        this.energyOnStart = energyOnStart;
    }

    public void setDefaultEnergyOnStart(){

    }

    public void setDefaultLossFactor(){

    }


}
