package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.WrongGenotypeException;
import fitness_evaluator.IFitnessProxy;
import fitness_evaluator.SimpleFunctionFitnessProxy;
import function.SimpleFunction;
import agent.Agent;
import agent.AgentFactory;

public class AgentFactoryTest {
	private IFitnessProxy proxy;
	@Before
	public void setUp() throws Exception {
		proxy = new SimpleFunctionFitnessProxy(new SimpleFunction());
	}

	
	@Test
	public void createAgent() throws WrongGenotypeException {
		AgentFactory factory = new AgentFactory(10, 0.1, 100, proxy);
		Agent a = factory.createAgent();
		assert(a.getEnergy()==100);
	}

}
