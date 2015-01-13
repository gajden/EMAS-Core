package core.settings;

/**
 * Created by Joanna on 2014-12-02.
 */
public class EnvironmentSettings {
    private int numberOfIslands;
    private int numberOfAgents;

    public int getNumberOfIslands() {
        return numberOfIslands;
    }

    public void setNumberOfIslands(int numberOfIslands) {
        this.numberOfIslands = numberOfIslands;
    }

    public int getNumberOfAgents() {
        return numberOfAgents;
    }

    public void setNumberOfAgents(int numberOfAgents) {
        this.numberOfAgents = numberOfAgents;
    }

    public void setDefaultNumberOfIslands(){
        this.numberOfIslands = 2;
    }

    public void setDefaultNumberOfAgents(){
        this.numberOfAgents = 202;
    }


}

