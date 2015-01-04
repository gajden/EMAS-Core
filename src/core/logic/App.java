package core.logic;

import java.io.IOException;

/**
 * Created by Joanna on 2014-12-02.
 */
public class App {
    public static void main(String[] args) {
        Core core = new Core();
        core.init();
        core.setData("Dzien dobry jestem Core");
        try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println(core.getData());
        core.clean();
    }
}