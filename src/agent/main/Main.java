package agent.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import agent.agent.Agent;
import agent.agent.AgentFactory;
import agent.exceptions.WrongGenotypeException;
import agent.fitness_evaluator.SimpleFunctionFitnessProxy;
import agent.function.ExampleFunction;



public class Main {

	public static void main(String[] args) {
		List<Agent> list = new ArrayList<Agent>();

		
		
		SimpleFunctionFitnessProxy proxy = new SimpleFunctionFitnessProxy(new ExampleFunction());
		AgentFactory factory = new AgentFactory(50, 0.01, 300, proxy);
		
		for(int i=0; i<10; i++){
				try {
					list.add(factory.createAgent());
				} catch (WrongGenotypeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		Random r = new Random();
		
		while(list.size()>0){
			
			int size = list.size();
			System.out.println("#############################################################");
			for (int i=0; i< list.size(); i++)	{
				Agent e=(Agent)list.get(i);
				if(e.getEnergy()<10)
					list.remove(e);
				else{
					System.out.println("Agent:"+e.toString()+" Fitness: "+e.getFitness()+" Energy: "+e.getEnergy());
				}
			}
			size = list.size();
			int k = r.nextInt(size-1);
			int l = r.nextInt(size-1);
			while(k==l){
				l = r.nextInt(size-1);
			}
			
			if(k%2==0 && size>1)
				list.get(k).fight((Agent)list.get(k));
			
			if(k%2==1 && size>2){
				Agent a;
				try {
					a = (Agent) list.get(k).hybridize((Agent)list.get(l));
					list.add(a);
				} catch (WrongGenotypeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
