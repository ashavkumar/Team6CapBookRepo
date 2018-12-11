package com.cg.capbook.boot;
import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"features"},
		glue= {"com.cg.banking.stepdefinition"}
		)
public class CapBookApplicationTests {
	@Test
	public void contextLoads() {
	}
}
