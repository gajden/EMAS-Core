package gui.java.tests;

import gui.java.Stack;
import gui.java.StackEntryPoint;
import junit.framework.TestCase;

public class StackEntryPointTest extends TestCase {

    public void testGetStack() throws Exception {
        StackEntryPoint sep = new StackEntryPoint();
        Stack stack = sep.getStack();
        assertTrue(stack.getClass().toString().contains("Stack"));
    }
}