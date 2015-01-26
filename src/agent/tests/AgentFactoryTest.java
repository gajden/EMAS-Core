package agent.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import agent.exceptions.WrongGenotypeException;
import agent.fitness_evaluator.IFitnessProxy;
import agent.fitness_evaluator.SimpleFunctionFitnessProxy;
import agent.function.SimpleFunction;
import agent.agent.Agent;
import agent.agent.AgentFactory;

@SuppressWarnings("unused")
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
		assertEquals(a.getEnergy(), 100, 0.0);
	}
}
