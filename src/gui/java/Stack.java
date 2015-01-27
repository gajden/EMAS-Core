package gui.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ant6 on 2015-01-02.
 */

public class Stack {
    private Queue<String> internalList;
    private boolean r = false;
    private final int ILOSC_PARAM = 9;

    public void isR(){
    	while(this.internalList.size()<ILOSC_PARAM){}
    	this.r=true;
    }
    
    public boolean ifR(){
    	return r;
    }
    
    public Stack(){
    	this.internalList = new LinkedList<String>();
    }
    
    public void push(String ele){
        internalList.offer(ele);
    }

    public String pop(){
        return internalList.poll();
    }

    public Queue<String> getInternalList(){
        return internalList;
    }

    public int size(){
        return internalList.size();
    }

    public void pushAll(List<String> eles){
        for(String ele : eles){
            this.push(ele);
        }
    }
}
