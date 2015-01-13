package core.logic;

import core.logic.IEnvironment;
import core.settings.EnvironmentSettings;

import java.awt.*;
import java.util.LinkedList;
import java.util.Map;

import agent.agent.Agent;

/**
 * Created by Joanna on 2014-11-25.
 */
@SuppressWarnings("unused")
public class Environment implements IEnvironment {
    private LinkedList<Agent[]> islands;
    private int currentIsland;
    private int[] currentAgent;
    private EnvironmentSettings settings;


    @Override
    public void create(EnvironmentSettings settings) {
    	this.settings = settings;
    	this.currentIsland = 0;
    	this.islands = new LinkedList<Agent[]>();
    	for (int i = 0; i<this.settings.getNumberOfIslands(); i++){
    		Agent[] a = new Agent[this.settings.getNumberOfAgents()];
    		islands.add(a);
    	}
    	System.out.println("ilosc wysp: "+this.settings.getNumberOfIslands() +" ilosc agentow: "+ this.settings.getNumberOfAgents());
    }

    @Override
    public void addAgent(int x, int y, Agent agent) {

    }

    @Override
    public void deleteAgent(Agent agent) {

    }

    @Override
    public Agent getFirst() {
        return null;
    }

    @Override
    public Agent getLast() {
        return null;
    }

    @Override
    public Agent getNext() {
        return null;
    }

    @Override
    public Agent getPrev() {
        return null;
    }

    @Override
    public Agent[] getNeighbours() {
        return new Agent[0];
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

    }

    @Override
    public void swap(Agent firstAgent, Agent secondAgent) {

    }

    @Override
    public int[] find(Agent agent) {
        return new int[0];
    }

    @Override
    public Agent getAgent(int[] position) {
        return null;
    }

    @Override
    public Agent getCurrent() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public void setAgent(Agent agent) {

    }

    @Override
    public Agent getBest(){
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
}
