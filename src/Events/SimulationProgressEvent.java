package Events;



import java.util.HashMap;

/**
 * Created by Joanna on 2014-12-02.
 */
public class SimulationProgressEvent {
    private HashMap<String, Float> currentState;
    private float average;
    private float best;
    private float worst;
    private int iteration;


    public double getAverage() {
        return average;
    }

    public void setAverage(float average) {
        currentState.put("average", average);
        this.average = average;
    }

    public double getBest() {
        return best;
    }

    public void setBest(float best) {
        currentState.put("best", best);
        this.best = best;
    }

    public double getWorst() {
        return worst;
    }

    public void setWorst(float worst) {
        currentState.put("worst", worst);
        this.worst = worst;
    }

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {

        this.iteration = iteration;
    }


}
