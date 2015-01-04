package agent.genotype;

public abstract class Genotype {
	public abstract Genotype hybridize(Genotype genotype2, double randomnessFactor);
}
