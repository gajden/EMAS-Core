package core.settings;

/**
 * Created by Joanna on 2014-12-02.
 */
public class SimulationSettings {
    private int iterations;
    private int iterationStat;

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public void setDefaultIterations(){
        this.iterations = 10;
    }
    
    public void setIterationStat(int iterations) {
        this.iterationStat = iterations;
    }
    
    public void setDefaultIterationStat(){
        this.iterationStat = 1;
    }
    
    public int getIterationStat() {
        return iterationStat;
    }
}
