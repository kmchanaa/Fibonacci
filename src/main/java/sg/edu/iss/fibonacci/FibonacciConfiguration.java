package sg.edu.iss.fibonacci;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class FibonacciConfiguration extends Configuration{

	@NotNull
	private Integer defaultNumber = 1;

	
	@JsonProperty
	public Integer getDefaultNumber() {
		return defaultNumber;
	}
	
	@JsonProperty
	public void setDefaultNumber(Integer number) {
		this.defaultNumber = number;
	}

}
