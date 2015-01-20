package core.logic;

import agent.agent.Agent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import py4j.GatewayServer;
import gui.java.StackEntryPoint;
import gui.java.Stack;

import java.util.List;

/**
 * Created by Joanna on 2014-11-24.
 */
@SuppressWarnings("unused")
public class Core implements ICore {
	private Process p = null;
	private StackEntryPoint entryPoint;
	private GatewayServer gatewayServer;
    private Simulation simulation;
    private DataProvider dataProvider;
    private Stack stack;
    private boolean ready = false;



    @Override
    public void init() {
        this.createComponents();
        ready = true;
    }
    /*
    private void loadSettings(HashMap<String, Double> settings){
        dataProvider.initDataProvider(settings);
    }
*/
    private void createComponents(){
    	this.entryPoint = new StackEntryPoint();
    	this.gatewayServer=new GatewayServer(this.entryPoint, 25336);
        this.simulation = new Simulation();
        this.dataProvider = new DataProvider();
        this.gatewayServer.start();
        this.stack = this.entryPoint.getStack();
        System.out.println("Gateway Server Started!");
        System.out.println("Stos: " + this.stack.size());
		try {
			this.p = Runtime.getRuntime().exec("python ./src/gui/python/emasgui.py ");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
    
    public void start(){
    	this.distributeData();
    }
    
    public void initProv(Map<String, Double> settings){
    	while (!this.stack.ifR()){}
    	System.out.println("Stos: " + this.stack.size());
    	this.dataProvider.initDataProvider(settings);
    }
    
    public void setData(String a){
    	stack.push(a);
    }
    public List<String> getData(){
    	return stack.getInternalList();
    }
    
    public Map<String, Double> parseData(List<String> a){
    	Map<String, Double> map = new HashMap<String, Double>();
    	for(String str : a){
    		String delims = "=";
    		String[] tokens = str.split(delims);
    		map.put(tokens[0], Double.parseDouble(tokens[1]));
    	}
    	return map;
    }
    
    private void distributeData(){
        simulation.init(dataProvider);
    }
    public void clean (){
    	this.p.destroy();
    	this.gatewayServer.shutdown();
    	System.out.println("Gateway Server & GUI Shutdown");
    }
}
