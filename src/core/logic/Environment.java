package core.logic;

import core.logic.IEnvironment;
import core.settings.EnvironmentSettings;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import agent.agent.Agent;

/**
 * Created by Joanna on 2014-11-25.
 */
@SuppressWarnings("unused")
public class Environment implements IEnvironment {
	
    private ArrayList<LinkedList<Agent>> islands;
    private ArrayList<Integer> agentsNumber;
    private int currentIsland;
    private int currentAgent;
    private EnvironmentSettings settings;
    private int margin = 10;
    
    @Override
    public void create(EnvironmentSettings settings) {
    	this.settings = settings;
    	this.currentIsland = 0;//indeks
    	this.currentAgent = 0;//indeks
    	this.islands = new ArrayList<LinkedList<Agent>>();
    	for (int i = 0; i<this.settings.getNumberOfIslands(); i++){
    		islands.add(new LinkedList<Agent>());
    	}
   }

    @Override
    public void deleteAgent(Agent agent) {

    }

    @Override
    public Agent getFirst() {
    	this.currentAgent=0;
        return islands.get(currentIsland).getFirst();
    }

    @Override
    public Agent getLast() {
        return islands.get(currentIsland).getLast();
    }

    @Override
    public Agent getNext() {
    	if((currentAgent+1)<settings.getNumberOfAgents()){
    		this.currentAgent++;
    		return islands.get(currentIsland).get(currentAgent);
        }
    	return null;
    }

    @Override
    public Agent getPrev() {
    	if(this.currentAgent>0){
    		return islands.get(currentIsland).get(currentAgent-1);
    	}
        return null;
    }

    @Override
    public LinkedList<Agent> getNeighbours() {
    	LinkedList<Agent> n = new LinkedList<Agent>();
    	Agent a = this.getPrev();
    	if(a != null )
    		n.add(a);
    	a = this.getNext();
    	if(a != null)
    	   	n.add(a);
    	return n;
    }

    @Override
    public int getNumberOfIslands() {
        return settings.getNumberOfIslands();
    }

    @Override
    public int getNumberOfAgents() {
        return settings.getNumberOfAgents();
    }

    @Override
    public void chooseIsland(int island) {
    	this.currentIsland = island;
    }

    @Override
    public void swap(Agent firstAgent, Agent secondAgent) {

    }

    @Override
    public Agent getAgent(int position) {
        return islands.get(currentIsland).get(position);
    }

    @Override
    
    public void resetCurrent(){
    	this.currentAgent = 0;
    }
    
    public Agent getCurrent() {
        return islands.get(currentIsland).get(currentAgent);
    }

    @Override
    public boolean hasNext() {
        return this.currentAgent+1 < agentsNumber.get(currentIsland);
    }

    @Override
    public Agent getBest() {
        return null;
    }

    @Override
    public float getAverage() {
        return 0;
    }

    @Override
    public float getWorst() {
        return 0;
    }

    @Override
    public void setAgent(Agent agent) {
    	//this.islands.get(currentIsland).get(currentAgent) = agent;
    	currentAgent++;
    }

    public void tryPut(Agent agent){
        if(agentsNumber.get(currentIsland) <= settings.getNumberOfAgents() + margin){
            this.islands.get(currentIsland).add(agent);
        }
    }

    public void removeAgent(Agent agent){
        if(this.islands.get(currentIsland).contains(agent))
            this.islands.get(currentIsland).remove(agent);
    }
}
