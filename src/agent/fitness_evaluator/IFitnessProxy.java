package fitness_evaluator;

import exceptions.WrongGenotypeException;
import genotype.Genotype;

public interface IFitnessProxy {
	public double evaluateFitness(Genotype genotype) throws WrongGenotypeException;
	public Genotype createGenotype();
}
