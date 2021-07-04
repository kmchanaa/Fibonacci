package sg.edu.iss.fibonacci.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fibonacci {
	
	private List<Long> fibonacci;
	
	private List<Long> sorted;
	
	public Fibonacci() {
		
	}
	
	public Fibonacci(List<Long> fibonacci, List<Long> sorted) {
		this.fibonacci = fibonacci;
		this.sorted = sorted;
	}
	
	@JsonProperty
	public List<Long> getFibonacci(){
		return fibonacci;
	}

	@JsonProperty
	public List<Long> getSorted(){
		return sorted;
	}
	
	public void setFibonacci(Integer elements){
		
		this.fibonacci = fibonacciSequence(elements);

	}
	
	public void setSorted(Integer elements){
		
		List<Long> fibonacci = fibonacciSequence(elements);
		
		List<Long> evenList = new ArrayList<>();
		
		List<Long> oddList = new ArrayList<>();
		
		List<Long> sortedList = new ArrayList<>();
		
		for (int i = 0; i<fibonacci.size(); i++) {
			
			if (fibonacci.get(i)%2==0)
				//add the fibonacci number in evenList if the number is even number
				evenList.add(fibonacci.get(i));
			else
				//add the fibonacci number in oddList if the number is odd number
				oddList.add(fibonacci.get(i));
		}
	
		//sort the evenList in descending order
		Collections.reverse(evenList);
		//sort the oddList in descending order
		Collections.reverse(oddList);
		
		//add sorted evenList to sortedList
		sortedList.addAll(evenList);
		
		//add sorted oddList to sortedList
		sortedList.addAll(oddList);
		
		this.sorted = sortedList;
	}
	
	public static List<Long> fibonacciSequence(int n) {
		
		List<Long> fibonacci = new ArrayList<>();
		
	    long first = 0, second = 1;
		
	    //add the first fibonacci number to the list
		fibonacci.add(first);
		
		if (n>1)
			//add the second fibonacci number to the list
			fibonacci.add(second);	    

	    long next;
	    
	    for (int i = 2; i < n; i++) {
	    	
	    	//calculate the next fibonacci number and add to the list    	
	    	next = first + second;
	    	fibonacci.add(next);
	    	
	    	first = second;
	    	second = next;
	    }
	    
	    return fibonacci;
	}
}
