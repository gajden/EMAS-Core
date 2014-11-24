import java.util.Map;

/**
 * Created by Joanna on 2014-11-24.
 */
public interface IValidator {
    public boolean checkSettings();
    public Map<String, int[]> getDafault(String functionType);
    public Map<String, int[]> fixSettings(String functionType);
}
