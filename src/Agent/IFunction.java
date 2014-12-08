package Agent;

/**
 * Created by Joanna on 2014-12-08.
 */
public interface IFunction {
    public double getValueAt(double[] args);
    public double[] getUpperDomainBound();
    public double[] getLowerDomainBound();
    public int getDimensions();
}