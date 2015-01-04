package agent.function;

public class SimpleFunction implements IFunction{
	int n=1;
	public double getValueAt(double[] args){
		double result=0; 
		for(int i=0; i<args.length; i++){
			result = result + args[i];
		}
		return result;
	}
	
	public double[] getUpperDomainBound(){
		double[] result=new double[n];
		for(int i=0;i<n;i++)
			result[i]=10;
		return result;
		
	}
	
	public double[] getLowerDomainBound(){
		double[] result=new double[n];
		for(int i=0;i<n;i++)
			result[i]=-10;
		return result;
		
	}
	
	public int getDimensions(){
		return n;
	}
}
