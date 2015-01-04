package agent.agent;


import agent.exceptions.WrongGenotypeException;
import agent.fitness_evaluator.IFitnessProxy;
import agent.fitness_evaluator.SimpleFunctionFitnessProxy;
import agent.function.IFunction;
import agent.genotype.Genotype;


public class Agent{

	private double energy; 
	private double fitness;
	private Genotype genotype; 
	
	private double energyLossFactor=50;
	private double genotypeRandomnessFactor=0.2; //factor which defines the probability of mutation
	private double energyOnStart=100;

	private IFitnessProxy fitnessEvaluator;
	
	public Agent(double energyLossFactor,
			double genotypeRandomnessFactor, double energyOnStart,
			IFitnessProxy fitnessEvaluator) throws WrongGenotypeException {
		super();
		this.energy = energyOnStart;
		this.energyLossFactor = energyLossFactor;
		this.genotypeRandomnessFactor = genotypeRandomnessFactor;
		this.energyOnStart = energyOnStart;
		this.fitnessEvaluator = fitnessEvaluator;
		this.genotype= fitnessEvaluator.createGenotype();
		this.fitness = this.fitnessEvaluator.evaluateFitness(genotype);
	}
	
	public Agent() {
		// TODO Auto-generated constructor stub
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}


	public Genotype getGenotype() {
		return genotype;
	}

	public void setGenotype(Genotype genotype) {
		this.genotype = genotype;
	}

	public double getEnergy() {
		return energy;
	}

	public double getFitness() {
		return fitness;
	}

	public void fight(Agent agent2) {
		if(agent2.getFitness()<fitness){
			
			agent2.energy=agent2.energy-energyLossFactor;
			energy=energy+energyLossFactor;
		}
		else{
		
			agent2.energy=agent2.energy+energyLossFactor;
			energy=energy-energyLossFactor;
		}
		
	}

	
	public Agent hybridize(Agent agent2) throws WrongGenotypeException {
		Genotype gen= genotype.hybridize(agent2.getGenotype(), genotypeRandomnessFactor);
		AgentFactory factory = new AgentFactory(energyLossFactor, genotypeRandomnessFactor, energyOnStart, fitnessEvaluator);
		
		Agent agent3 = factory.createAgent();
		agent3.setGenotype(gen);
		
		energy=energy-energyOnStart/2;
		agent2.energy=agent2.energy-energyOnStart/2;
		return agent3;
	}

}
