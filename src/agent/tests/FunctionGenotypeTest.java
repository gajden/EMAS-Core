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
		f= new SimpleFunction();
	}

	@Test
	public void constructorTest() {
		gen = new FunctionGenotype(f);
		double[] maxDomain = gen.getMaxDomain();
		assert(maxDomain.length==1 && maxDomain[0]==10);
		double[] minDomain = gen.getMinDomain();
		assert(minDomain.length==1 && minDomain[0]==-10);
		assert(gen.getN()==1);
		assert(gen.getP().length==2);
	}

	@Test
	public void hybridizeZeroRandomnessTest(){
		gen = new FunctionGenotype(f);
		FunctionGenotype gen2 = new FunctionGenotype(f);
		
		double[][] P = new double [2][1];
	    P[0][0]=0;
		P[1][0]=1;
		gen.setP(P);
		
		double[][] P2 = new double [2][1];
	    P[0][0]=1;
		P[1][0]=0;
		gen2.setP(P2);
		
		FunctionGenotype gen3 = (FunctionGenotype) gen.hybridize(gen2, 0.0);
		
		assert(gen3.getP().length==2 && gen3.getP()[0][0]==0.5 && gen3.getP()[1][0]==0.5);
		
	}
	
	@Test
	public void hybridizeTest(){
		gen = new FunctionGenotype(f);
		FunctionGenotype gen2 = new FunctionGenotype(f);
		
		double[][] P = new double [2][1];
	    P[0][0]=0;
		P[1][0]=1;
		gen.setP(P);
		
		double[][] P2 = new double [2][1];
	    P[0][0]=1;
		P[1][0]=0;
		gen2.setP(P2);
		
		FunctionGenotype gen3 = (FunctionGenotype) gen.hybridize(gen2, 0.5);
		
		assert(gen3.getP().length==2 && gen3.getP()[0][0]<=10 && gen3.getP()[0][0]>=-10 && gen3.getP()[1][0]<=10 && gen3.getP()[1][0]>=-10);
		
	}
}
