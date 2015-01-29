package core.logic;

import core.settings.EnvironmentSettings;

import java.util.LinkedList;
import java.util.Map;

import agent.agent.Agent;



/**
 * Created by Joanna on 2014-11-24.
 */
@SuppressWarnings("unused")
public interface IEnvironment {
    public void create(EnvironmentSettings settings);
    public Agent getFirst();
    public Agent getLast();
    public Agent getNext();
    public Agent getPrev();
    public LinkedList<Agent> getNeighbours();
    public int getNumberOfIslands();
    public int getNumberOfAgents();
    public void chooseIsland(int island);
    public void swap(Agent firstAgent, Agent secondAgent);
    public Agent getAgent(int position);
    public Agent getCurrent();
    public boolean hasNext();
	void resetCurrent();
}
