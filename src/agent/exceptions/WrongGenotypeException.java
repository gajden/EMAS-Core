package agent.exceptions;

import agent.genotype.Genotype;

@SuppressWarnings("serial")
public class WrongGenotypeException extends Exception{
	@SuppressWarnings("unused")
	private Genotype genotype;
	public WrongGenotypeException(Genotype genotype){
		this.genotype=genotype;
	}
}
