package agent.exceptions;

import agent.genotype.Genotype;

public class WrongGenotypeException extends Exception{
	private Genotype genotype;
	public WrongGenotypeException(Genotype genotype){
		this.genotype=genotype;
	}
}
