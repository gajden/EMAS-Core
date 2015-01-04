package agent.fitness_evaluator;

import agent.exceptions.WrongGenotypeException;
import agent.genotype.Genotype;

public interface IFitnessProxy {
	public double evaluateFitness(Genotype genotype) throws WrongGenotypeException;
	public Genotype createGenotype();
}
