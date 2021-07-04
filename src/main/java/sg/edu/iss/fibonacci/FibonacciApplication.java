package sg.edu.iss.fibonacci;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import sg.edu.iss.fibonacci.health.ApplicationHealthCheck;
import sg.edu.iss.fibonacci.resources.FibonacciResource;

public class FibonacciApplication extends Application<FibonacciConfiguration> {

    public static void main(final String[] args) throws Exception {
        new FibonacciApplication().run(args);
    }

    @Override
    public String getName() {
        return "Fibonacci";
    }

    @Override
    public void initialize(final Bootstrap<FibonacciConfiguration> bootstrap) {
    	
    }

    @Override
    public void run(final FibonacciConfiguration configuration,
                    final Environment environment) {
    	
        final FibonacciResource resource = new FibonacciResource(configuration.getDefaultNumber());      
        final ApplicationHealthCheck healthCheck = new ApplicationHealthCheck();
        
        environment.healthChecks().register("application", healthCheck);
        environment.jersey().register(resource);
        
    }

}
