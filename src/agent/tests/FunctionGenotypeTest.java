package agent.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import agent.function.IFunction;
import agent.function.SimpleFunction;
import agent.genotype.FunctionGenotype;
import agent.genotype.Genotype;

@SuppressWarnings("unused")
public class FunctionGenotypeTest {
	private IFunction f;
	private FunctionGenotype gen;

	@Before
	public void setUp() throws Exception {
		f = new SimpleFunction();
	}

	@Test
	public void constructorTest() {
		gen = new FunctionGenotype(f);
		double[] maxDomain = gen.getMaxDomain();
		assertEquals(maxDomain.length, 1);
		assertEquals(maxDomain[0], 10, 0.0);
		double[] minDomain = gen.getMinDomain();
		assertEquals(minDomain.length, 1);
		assertEquals(minDomain[0], -10, 0.0);
		assertEquals(gen.getN(), 1);
		assertEquals(gen.getP().length, 2);
	}

	@Test
	public void hybridizeZeroRandomnessTest() {
		gen = new FunctionGenotype(f);
		FunctionGenotype gen2 = new FunctionGenotype(f);

		double[][] P = new double[2][1];
		P[0][0] = 0;
		P[1][0] = 1;
		gen.setP(P);

		double[][] P2 = new double[2][1];
		P2[0][0] = 1;
		P2[1][0] = 0;
		gen2.setP(P2);

		FunctionGenotype gen3 = (FunctionGenotype) gen.hybridize(gen2, 0.0);

		assertEquals(gen3.getP().length, 2);
		assertEquals(gen3.getP()[0][0], 0.5, 0.0);
		assertEquals(gen3.getP()[1][0], 0.5, 0.0);

	}

	@Test
	public void hybridizeTest() {
		gen = new FunctionGenotype(f);
		FunctionGenotype gen2 = new FunctionGenotype(f);

		double[][] P = new double[2][1];
		P[0][0] = 0;
		P[1][0] = 1;
		gen.setP(P);

		double[][] P2 = new double[2][1];
		P[0][0] = 1;
		P[1][0] = 0;
		gen2.setP(P2);

		FunctionGenotype gen3 = (FunctionGenotype) gen.hybridize(gen2, 0.5);

		assertEquals(gen3.getP().length, 2);
		assertTrue(gen3.getP()[0][0] <= 10 && gen3.getP()[0][0] >= -10
				&& gen3.getP()[1][0] <= 10 && gen3.getP()[1][0] >= -10);

	}
}
