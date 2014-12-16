package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import agent.Agent;
import exceptions.WrongGenotypeException;
import fitness_evaluator.IFitnessProxy;
import fitness_evaluator.SimpleFunctionFitnessProxy;
import function.SimpleFunction;

public class AgentTest {
	private IFitnessProxy proxy;
	@Before
	public void setUp() throws Exception {
		proxy = new SimpleFunctionFitnessProxy(new SimpleFunction());
	}

	@Test
	public void fightTest() throws WrongGenotypeException {
		Agent a1 = new Agent(50, 0.2, 100, proxy);
		Agent a2 = new Agent(50, 0.2, 100, proxy);
		
		a1.setFitness(0);
		a2.setFitness(1);
		
		a1.fight(a2);
		
		assert(a1.getFitness()==50 && a2.getFitness()==150);
	}

	
	@Test
	public void hybridizeZeroRandomnessFactorTest() throws WrongGenotypeException {
		Agent a1 = new Agent(50, 0.2, 100, proxy);
		Agent a2 = new Agent(50, 0.2, 100, proxy);
		
		a1.setFitness(0);
		a2.setFitness(1);
		
		Agent a3 = a1.hybridize(a2);
		assert(a1.getEnergy()==50 && a2.getEnergy()==50 && a3.getEnergy()==100 && a3.getFitness()==(a1.getFitness()+a2.getFitness())/2);
	}
	
	
}
