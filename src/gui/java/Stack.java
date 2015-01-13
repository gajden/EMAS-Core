package gui.java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ant6 on 2015-01-02.
 */

public class Stack {
    private List<String> internalList = new LinkedList<String>();

    public void push(String ele){
        internalList.add(ele);
    }

    public String pop(){
        return internalList.remove(0);//internalList.size()-1);
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
