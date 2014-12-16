package function;

public interface IFunction {
	public double getValueAt(double[] args);
	public double[] getUpperDomainBound();
	public double[] getLowerDomainBound();
	public int getDimensions(); 
}
