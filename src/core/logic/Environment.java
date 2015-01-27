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
	
    private ArrayList<Agent[]> islands;
    private int currentIsland;
    private int currentAgent;
    private EnvironmentSettings settings;
    
    @Override
    public void create(EnvironmentSettings settings) {
    	this.settings = settings;
    	this.currentIsland = 0;//indeks
    	this.currentAgent = 0;//indeks
    	this.islands = new ArrayList<Agent[]>();
    	for (int i = 0; i<this.settings.getNumberOfIslands(); i++){
    		islands.add(new Agent[this.settings.getNumberOfAgents()]);
    	}
   }

    @Override
    public void deleteAgent(Agent agent) {

    }

    @Override
    public Agent getFirst() {
    	this.currentAgent=0;
        return islands.get(currentIsland)[0];
    }

    @Override
    public Agent getLast() {
        return islands.get(currentIsland)[settings.getNumberOfAgents()-1];
    }

    @Override
    public Agent getNext() {
    	if((currentAgent+1)<settings.getNumberOfAgents()){
    		this.currentAgent++;
    		return islands.get(currentIsland)[currentAgent];
        }
    	return null;
    }

    @Override
    public Agent getPrev() {
    	if(this.currentAgent>0){
    		return islands.get(currentIsland)[currentAgent-1];
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
        return islands.get(currentIsland)[position];
    }

    @Override
    
    public void resetCurrent(){
    	this.currentAgent = 0;
    }
    
    public Agent getCurrent() {
        return islands.get(currentIsland)[currentAgent];
    }

    @Override
    public boolean hasNext() {
        return this.currentAgent+1 < settings.getNumberOfAgents();
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
    	this.islands.get(currentIsland)[currentAgent] = agent;
    	currentAgent++;
    }

    public void tryPut(Agent agent){

    }
}
