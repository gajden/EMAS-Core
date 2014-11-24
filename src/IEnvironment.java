import java.util.Map;

/**
 * Created by Joanna on 2014-11-24.
 */
public interface IEnvironment {
    public void create(Map<String, int[]> settings);
    public void addAgent(int x, int y, Agent agent);
    public void deleteAgent(Agent agent);
    public Agent getFirst();
    public Agent getLast();
    public Agent getNext();
    public Agent getPrev();
    public Agent[] getNeighbours(Agent agent);
    public int getNumberOfIslands();
    public int getNumberOfAgents();
    public void chooseIsland(int island);
    public void swap(Agent firstAgent, Agent secondAgent);
    public int[] find(Agent agent);
    public Agent getAgent(int[] position);
}
