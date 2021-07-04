package sg.edu.iss.fibonacci.resources;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import sg.edu.iss.fibonacci.api.Fibonacci;

@Path("/fibonacci")
@Produces(MediaType.APPLICATION_JSON)
public class FibonacciResource {
	
	private Integer defaultNumber;
	
	public FibonacciResource(Integer defaultNumber) {
		this.defaultNumber = defaultNumber;
	}
	
	@GET
	@Timed
	public Fibonacci getFibonacci(@QueryParam("elements") Optional<Integer> elements) {
		
		Integer number = elements.orElse(defaultNumber);
		
		Fibonacci fibonacci = new Fibonacci();
		
		if (number>=1 && number<=100) {
			fibonacci.setFibonacci(number);
			fibonacci.setSorted(number);
		}
		
		return fibonacci;
	}

}
