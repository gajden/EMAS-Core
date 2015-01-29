package agent.function;
import agent.function.IFunction;


public class RastriginFunction implements IFunction{
	int n;
	
	public RastriginFunction(int n){
		this.n=n;
	}
	
	@Override
	public double getValueAt(double[] args) {
		double result=10*args.length; 
		for(int i=0; i<args.length; i++){
			result = result + args[i]*args[i]-10*Math.cos(2*Math.PI*args[i]);
		}
		return result;
	}

	public double[] getUpperDomainBound() {
		double[] result = new double[n];
		for (int i = 0; i < n; i++)
			result[i] = 5.12;
		return result;
	}

	@Override
	public double[] getLowerDomainBound() {
		double[] result = new double[n];
		for (int i = 0; i < n; i++)
			result[i] = -.12;
		return result;
	}

	@Override
	public int getDimensions() {
		return n;
	}
	
}
