import java.util.Map;

/**
 * Created by Joanna on 2014-11-24.
 */
public interface IDataProvider {
    public void initDataProvider(String path);
    public void updateData(String path);
    public Map<String, int[]> getEnvironmentSettings();
    public Map<String, int[]> getAgentsSettings();
    public void updateDataForGui();
}
