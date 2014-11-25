/**
 * Created by Joanna on 2014-11-24.
 */
public interface ISimulation {
    public void start(DataProvider dataProvider);
    public void currentState();
    public boolean inProgress();
}
