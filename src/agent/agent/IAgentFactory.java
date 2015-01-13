package agent.agent;

import agent.exceptions.WrongGenotypeException;

/**
 * Created by Joanna on 2015-01-13.
 */
public interface IAgentFactory {
    void setEnergyLossFactor(double energyLossFactor);

    void setGenotypeRandomnessFactor(double genotypeRandomnessFactor);

    void setEnergyOnStart(double energyOnStart);

    Agent createAgent() throws WrongGenotypeException;
}
