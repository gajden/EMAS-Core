package gui.java;

import py4j.GatewayServer;

/**
 * Created by ant6 on 2015-01-02.
 */
public class StackEntryPoint {
    private Stack stack;

    public StackEntryPoint(){
        stack = new Stack();
    }

    public Stack getStack(){
        return stack;
    }

    public static void main(String[] args){
        GatewayServer gatewayServer = new GatewayServer(new StackEntryPoint(), 25336);
        gatewayServer.start();
        System.out.println("Gateway Server Started");
    }
}
