package Settings;
/**
 * Created by Joanna on 2014-12-02.
 */
public class AgentSettings {
    private double minEnergy;
    private double energyOnStart;
    private double energyLossFactor;
    private double genotypeRandomnessFactor;
    private int dim;
       
    
    public double getMinEnergy(){
        return this.minEnergy;
    }
    public void setMinEnergy(double e){
        this.minEnergy=e;
    }
    
    public double getEnergyOnStart(){
        return this.energyOnStart;
    }    
    public void setEnergyOnStart(double e){
        this.energyOnStart=e;
    }
    
    public double getEnergyLossFactor(){
        return this.energyLossFactor;
    } 
    public void setEnergyLossFactor(double e){
        this.energyLossFactor=e;
    }
    
    public double getEenotypeRandomnessFactor(){
        return this.genotypeRandomnessFactor;
    } 
    public void setGenotypeRandomnessFactor(double e){
        this.genotypeRandomnessFactor=e;
    }
        
    public int getDim(){
        return this.dim;
    } 
    public void setDim(int e){
        this.dim=e;
    }

    public void setDefaultEnergyOnStart() {
        this.energyOnStart=100;
    }

    public void setDefaultLossFactor() {
        this.energyLossFactor=20;
    }
}