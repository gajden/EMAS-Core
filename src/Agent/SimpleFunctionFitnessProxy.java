package Agent;

/**
 * Created by Joanna on 2014-12-08.
 */
public class SimpleFunctionFitnessProxy implements IFitnessProxy {

    private IFunction f;
    private int n; //dimensions

    public SimpleFunctionFitnessProxy(IFunction function) {
        super();
        this.f = function;
        n=f.getDimensions();
    }


    public double stepResult(double[][] P){



        //get point with highest value from simplex
        double[] pointWithHighestValue;
        pointWithHighestValue=P[0];
        double highestValue;
        highestValue=f.getValueAt(P[0]);

        for(int i=1;i<n+1;i++){
            if(f.getValueAt(P[i])>highestValue){
                highestValue=f.getValueAt(P[i]);
                pointWithHighestValue=P[i];
            }
        }
        //get point with lowest value in simplex
        double[] pointWithLowestValue;
        pointWithLowestValue=P[0];
        double lowestValue;
        lowestValue=f.getValueAt(P[0]);

        for(int i=1;i<n+1;i++){
            if(f.getValueAt(P[i])<lowestValue){
                lowestValue=f.getValueAt(P[i]);
                pointWithLowestValue=P[i];
            }
        }

        //get mean point in simplex
        double[] meanPoint = new double[n];
        for(int i=0;i<n;i++){
            meanPoint[i]=-pointWithHighestValue[i]/n;
        }
        for(int i =0; i<n+1;i++){
            for(int j=0; j<n;j++){
                meanPoint[j]=meanPoint[j]+P[i][j]/n;
            }
        }


        double[] tmpPoint = new double[n];
        for(int i=0;i<n;i++){
            tmpPoint[i]=2*meanPoint[i]-pointWithHighestValue[i];
        }

        double[] tmpPoint2 = new double[n];
        if(f.getValueAt(tmpPoint)<=lowestValue){
            for(int i=0;i<n;i++){
                tmpPoint2[i]=3*meanPoint[i]-pointWithHighestValue[i];
            }
        }
        else{
            for(int i=0;i<n;i++){
                tmpPoint2[i]=3*meanPoint[i]/2-pointWithHighestValue[i]/2;
            }
        }

        if(f.getValueAt(tmpPoint)>=f.getValueAt(tmpPoint2)){
            //put tmpPoint2 instead of pointWithHighestValue
            for(int i=0;i<n;i++){
                pointWithHighestValue[i]=tmpPoint2[i];
            }
        }
        else{
            //put tmpPoint instead of pointWithHighestValue
            for(int i=0;i<n;i++){
                pointWithHighestValue[i]=tmpPoint[i];
            }
        }
        return lowestValue;
    }


    @Override
    public Genotype createGenotype() {
        Genotype gen= new FunctionGenotype(f);
        return gen;
    }

    @Override
    public double evaluateFitness(Genotype genotype) throws WrongGenotypeException {
        FunctionGenotype fgenotype= (FunctionGenotype) genotype;
        if(fgenotype==null) throw new WrongGenotypeException();

        double[][] P=fgenotype.getP();
        return stepResult(P);
    }




}