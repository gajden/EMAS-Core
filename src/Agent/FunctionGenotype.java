package Agent;

import java.util.Random;

/**
 * Created by Joanna on 2014-12-08.
 */
public class FunctionGenotype extends Genotype{

    private int n; //dimensions
    private double[][] P; //simplex vertices

    private IFunction f;

    private double minDomain[];
    private double maxDomain[];

    public FunctionGenotype(IFunction f){
        this.f=f;
        this.n=f.getDimensions();
        P=new double[n+1][n];
        minDomain=f.getLowerDomainBound();
        maxDomain=f.getUpperDomainBound();

        Random r = new Random();
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n;j++){

                P[i][j] = minDomain[j] + (maxDomain[j] - minDomain[j]) * r.nextDouble();
            }

        }

    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double[][] getP() {
        return P;
    }

    public void setP(double[][] p) {
        P = p;
    }

    public double[] getMinDomain() {
        return minDomain;
    }

    public void setMinDomain(double[] minDomain) {
        this.minDomain = minDomain;
    }

    public double[] getMaxDomain() {
        return maxDomain;
    }

    public void setMaxDomain(double[] maxDomain) {
        this.maxDomain = maxDomain;
    }


    public Genotype hybridize(Genotype gen2, double randomnessFactor) {

        FunctionGenotype genotype2 = (FunctionGenotype) gen2;
        FunctionGenotype gen3 = new FunctionGenotype(f);
        double[][] P3=new double[n+1][n];

        for(int i=0; i<n+1;i++){
            for(int j=0;j<n;j++){
                P3[i][j]=(P[i][j]+genotype2.getP()[i][j])/2;
            }
        }

        int k=(int) (n*randomnessFactor);

        Random r = new Random();
        for(int l=0; l<k;l++){
            int t= r.nextInt(n);
            for(int j=0;j<n;j++){

                P[t][j] = minDomain[j] + (maxDomain[j] - minDomain[j]) * r.nextDouble();
            }

        }
        gen3.setP(P3);
        return gen3;
    }



}