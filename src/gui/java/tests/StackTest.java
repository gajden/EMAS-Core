package gui.java.tests;

import gui.java.Stack;
import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.List;

public class StackTest extends TestCase {

    public void testPush() throws Exception {
        Stack stack = new Stack();
        stack.push("test");
        assertEquals("test", stack.pop());
    }

    public void testPop() throws Exception {
        Stack stack = new Stack();
        stack.push("test");
        assertEquals("test", stack.pop());
    }

    public void testGetInternalList() throws Exception {
        Stack stack = new Stack();
        stack.push("test");
        LinkedList<String> list = new LinkedList<String>();
        list.add("test");
        assertEquals(list, stack.getInternalList());
    }

    public void testSize() throws Exception {
        Stack stack = new Stack();
        stack.push("test1");
        stack.push("test2");
        assertEquals(2, stack.size());
    }

    public void testPushAll() throws Exception {
        Stack stack = new Stack();
        List<String> eles = new LinkedList<String>();
        eles.add("czy");
        eles.add("to");
        eles.add("działa");
        stack.pushAll(eles);
        assertEquals(3, stack.size());
    }
}