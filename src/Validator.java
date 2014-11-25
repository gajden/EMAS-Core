import java.util.Map;

/**
 * Created by Joanna on 2014-11-25.
 */
public class Validator implements IValidator {

    public Validator(String definitions){

    }

    @Override
    public boolean checkSettings() {
        return false;
    }

    @Override
    public Map<String, int[]> getDafault(String functionType) {
        return null;
    }

    @Override
    public Map<String, int[]> fixSettings(String functionType) {
        return null;
    }
}
