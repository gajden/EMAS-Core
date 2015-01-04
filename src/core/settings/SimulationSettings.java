package core.settings;

/**
 * Created by Joanna on 2014-12-02.
 */
public class SimulationSettings {
    private int iterations;

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public void setDefaultIterations(){
        this.iterations = 10;
    }
}
