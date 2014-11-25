/**
 * Created by Joanna on 2014-11-24.
 */
public class Core implements ICore{
    private GUI gui;
    private Simulation simulation;
    private Validator validator;
    private DataProvider dataProvider;


    public Core(){
        simulation = new Simulation();
        dataProvider = new DataProvider();
    }

    @Override
    public void initGUI() {
        validator = new Validator("lolz.cfg");
        gui = new GUI(validator);
        gui.setDataProvider();  //albo setDataPath() nie wiem czy w koncu plik, czy normalnie
    }

    @Override
    public void startThisShit() {
        while(true) {
            this.waitForStart();
            this.startSimulation();
        }
    }

    private void startSimulation() {
        this.dataProvider.initDataProvider(gui.getFilePath());
        simulation.start(dataProvider);
    }

    private void waitForStart() {
        while(simulation.inProgress() || !gui.ready()){

        }
    }

    public static void main(String[] args) {
        Core core = new Core();
        core.initGUI();
        core.startThisShit();
    }
}
