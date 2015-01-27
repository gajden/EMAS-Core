package core.logic;

import agent.agent.Agent;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
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
        while (!this.stack.ifR()){}
    }

    private void createComponents(){
    	this.entryPoint = new StackEntryPoint();
    	this.gatewayServer=new GatewayServer(this.entryPoint, 25336);
        this.dataProvider = new DataProvider();
        this.gatewayServer.start();
        this.stack = this.entryPoint.getStack();
        System.out.println("Gateway Server Started!");
        this.simulation = new Simulation(this.stack);
		try {
			this.p = Runtime.getRuntime().exec("python ./src/gui/python/emasgui.py ");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
    
    public void start(){
    	this.distributeData();
    	this.simulation.start();
    }
    
    public void initProv(Map<String, Double> settings){
    	this.dataProvider.initDataProvider(settings);
    }
    
    public void setData(String a){
    	stack.push(a);
    }
    public List<String> getData(){
    	List<String> lista = new LinkedList<String>();
    	while(this.stack.size() > 0)
    		lista.add(this.stack.pop());
    	return lista;
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
    	try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	this.gatewayServer.shutdown();
    	this.p.destroy();
    	System.out.println("Gateway Server & GUI Shutdown");
    }
    
	public void printStackforTests() {
		this.stack.rForGui();
		for(String a : this.stack.getInternalList()){
			System.out.println(a);
		}
	}
}
