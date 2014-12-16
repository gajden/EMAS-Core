package Logic;

/**
 * Created by Joanna on 2014-11-24.
 */
public interface ISimulation {
    public void init(DataProvider dataProvider);
    public void start();
    public boolean isInProgress();
}
