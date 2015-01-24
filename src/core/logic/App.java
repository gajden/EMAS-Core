package core.logic;

/*TODO:
->Simulation.iterateAgents(), sypie sie w chooseAction()
*/

import java.util.Map;

/**
 * Created by Joanna on 2014-12-02.
 */
public class App {
    public static void main(String[] args) {
        Core core = new Core();
        core.init();
        Map<String, Double> map = core.parseData(core.getData());  
        System.out.println("Dane z GUI: " + map);
        core.initProv(map);
        core.start();
        core.clean();
    }
}