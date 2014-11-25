

import java.util.Map;

/**
 * Created by Joanna on 2014-11-25.
 */
public class Environment implements IEnvironment {
    @Override
    public void create(Map<String, int[]> settings) {

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
    public Agent[] getNeighbours(Agent agent) {
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
    public Agent getBest();
}
