package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AgentFactoryTest.class, AgentTest.class,
		FunctionGenotypeTest.class, SimpleFunctionProxyTest.class })
public class AllTests {

}
