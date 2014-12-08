package Agent;

/**
 * Created by Joanna on 2014-12-08.
 */


public interface IFitnessProxy {

    public double evaluateFitness(Genotype genotype) throws WrongGenotypeException;
    public Genotype createGenotype();
}