package gui.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ant6 on 2015-01-02.
 */

public class Stack {
    private List<String> internalList;
    private int r = 0;
    private final int ILOSC_PARAM = 9;

    public void isR(){
    	while(this.internalList.size()<ILOSC_PARAM){}
    	this.r=1;
    }
    
    public boolean ifR(){
    	return (r == 1);
    }
    
    public Stack(){
    	this.internalList = new LinkedList<String>();
    }
    
    public void push(String ele){
        internalList.add(ele);
    }

    public String pop(){
        return internalList.remove(0);
    }

    public List<String> getInternalList(){
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
    
    public void rForGui(){
    	this.r=2;
    }
    
    public boolean gui(){
    	return this.r==2;
    }
}
