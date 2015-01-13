package agent.agent;

import agent.exceptions.WrongGenotypeException;
import agent.fitness_evaluator.IFitnessProxy;

public class AgentFactory {
	private double energyLossFactor=50;
	private double genotypeRandomnessFactor=0.2; //factor which defines the probability of mutation
	private double energyOnStart=100.0;
	
	private IFitnessProxy fitnessEvaluator;

	public AgentFactory(double energyLossFactor,
			double genotypeRandomnessFactor, double energyOnStart,
			IFitnessProxy fitnessEvaluator) {
		super();
		this.energyLossFactor = energyLossFactor;
		this.genotypeRandomnessFactor = genotypeRandomnessFactor;
		this.energyOnStart = energyOnStart;
		this.fitnessEvaluator = fitnessEvaluator;
		System.out.println("strata en: " + this.energyLossFactor + 
				", random: " + this.genotypeRandomnessFactor + 
				", energia startowa: " + this.energyOnStart );
	}

	
	
	public void setEnergyLossFactor(double energyLossFactor) {
		this.energyLossFactor = energyLossFactor;
	}



	public void setGenotypeRandomnessFactor(double genotypeRandomnessFactor) {
		this.genotypeRandomnessFactor = genotypeRandomnessFactor;
	}



	public void setEnergyOnStart(double energyOnStart) {
		this.energyOnStart = energyOnStart;
	}



	public AgentFactory(IFitnessProxy fitnessEvaluator) {
		super();
		this.fitnessEvaluator = fitnessEvaluator;
	}
	
	public Agent createAgent() throws WrongGenotypeException{
		Agent agent = new Agent(energyLossFactor, genotypeRandomnessFactor, energyOnStart,fitnessEvaluator);
		return agent;
	}
	
}
