package gui.java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ant6 on 2015-01-02.
 */

public class Stack {
    private List<String> internalList;
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
}
