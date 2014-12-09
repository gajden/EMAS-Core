package Logic;

import Logic.IEnvironment;
import Settings.EnvironmentSettings;

import java.awt.*;
import java.util.LinkedList;
import java.util.Map;
import Agent.Agent;

/**
 * Created by Joanna on 2014-11-25.
 */
public class Environment implements IEnvironment {
    private LinkedList<Agent[]> islands;
    private int currentIsland;
    private int[] currentAgent;
    private int numberOfIslands;
    private int numberOfAgents;


    @Override
    public void create(EnvironmentSettings settings) {

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
        return 0;
    }

    @Override
    public int getNumberOfAgents() {
        return 0;
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
