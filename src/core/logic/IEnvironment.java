package Logic;

import Settings.EnvironmentSettings;

import java.util.Map;

import Agent.Agent;



/**
 * Created by Joanna on 2014-11-24.
 */
@SuppressWarnings("unused")
public interface IEnvironment {
    public void create(EnvironmentSettings settings);
    public void addAgent(int x, int y, Agent agent);
    public void deleteAgent(Agent agent);
    public Agent getFirst();
    public Agent getLast();
    public Agent getNext();
    public Agent getPrev();
    public Agent[] getNeighbours();
    public int getNumberOfIslands();
    public int getNumberOfAgents();
    public void chooseIsland(int island);
    public void swap(Agent firstAgent, Agent secondAgent);
    public int[] find(Agent agent);
    public Agent getAgent(int[] position);
    public Agent getCurrent();
    public void setAgent(Agent agent);
    public boolean hasNext();
    public Agent getBest();
    public float getAverage();
    public float getWorst();
}