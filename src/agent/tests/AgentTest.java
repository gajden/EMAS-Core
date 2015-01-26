package agent.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import agent.agent.Agent;
import agent.exceptions.WrongGenotypeException;
import agent.fitness_evaluator.IFitnessProxy;
import agent.fitness_evaluator.SimpleFunctionFitnessProxy;
import agent.function.SimpleFunction;

@SuppressWarnings("unused")
public class AgentTest {
	private IFitnessProxy proxy;

	@Before
	public void setUp() throws Exception {
		proxy = new SimpleFunctionFitnessProxy(new SimpleFunction());
	}

	@Test
	public void fightTest() {
		try {
			Agent a1;
			a1 = new Agent(50, 0.2, 100, proxy);
			Agent a2;
			a2 = new Agent(50, 0.2, 100, proxy);
			a1.setFitness(0);
			a2.setFitness(1);
			a1.fight(a2);
			assertEquals(a1.getEnergy(), 50, 0.0);
			assertEquals(a2.getEnergy(), 150, 0.0);
		} catch (WrongGenotypeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void hybridizeZeroRandomnessFactorTest()
			throws WrongGenotypeException {
		Agent a1 = new Agent(50, 0.2, 100, proxy);
		Agent a2 = new Agent(50, 0.2, 100, proxy);

		a1.setFitness(0);
		a2.setFitness(1);

		Agent a3 = a1.hybridize(a2);

		assertEquals(a1.getEnergy(), 50, 0.0);
		assertEquals(a2.getEnergy(), 50, 0.0);
		assertEquals(a3.getEnergy(), 100, 0.0);

	}

}
