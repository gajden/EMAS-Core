package Agent;

/**
 * Created by Joanna on 2014-12-08.
 */
public abstract class Genotype {
    public abstract Genotype hybridize(Genotype genotype2, double randomnessFactor);
}