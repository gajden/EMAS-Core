package exceptions;

import genotype.Genotype;

public class WrongGenotypeException extends Exception{
	private Genotype genotype;
	public WrongGenotypeException(Genotype genotype){
		this.genotype=genotype;
	}
}
