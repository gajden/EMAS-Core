package core.logic;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Joanna on 2014-12-02.
 */
public class App {
    public static void main(String[] args) {
        Core core = new Core();
        core.init();
        //core.isReady();
        try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
        Map<String, Double> map = core.parseData(core.getData());
        core.initProv(map);
        core.start();
        core.clean();
    }
}