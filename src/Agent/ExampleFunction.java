package Agent;

/**
 * Created by Joanna on 2014-12-08.
 */
public class ExampleFunction implements IFunction{
    int n=3;
    public double getValueAt(double[] args){
        double result=0;
        int sgn=1;
        for(int i=0; i<args.length; i++){
            result = result + sgn*args[i]*args[i];
            sgn=2*sgn;
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