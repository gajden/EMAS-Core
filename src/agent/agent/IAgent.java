package agent.agent;

import agent.exceptions.WrongGenotypeException;
import agent.genotype.Genotype;

/**
 * Created by Joanna on 2015-01-13.
 */
public interface IAgent {
    void setEnergy(double energy);

    void setFitness(double fitness);

    Genotype getGenotype();

    void setGenotype(Genotype genotype);

    double getEnergy();

    double getFitness();

    void fight(Agent agent2);

    Agent hybridize(Agent agent2) throws WrongGenotypeException;
}
