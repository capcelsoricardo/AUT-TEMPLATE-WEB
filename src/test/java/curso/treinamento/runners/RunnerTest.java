package curso.treinamento.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features = {"src/test/resources/features/"},
		glue	 = {"curso.treinamento.steps", "curso.treinamento.setup"},
		tags = "@LoginComSucesso",		
		snippets =  SnippetType.UNDERSCORE,		
		monochrome = true,
		plugin = {"pretty", "json:target/cucumber.json", 
				"pretty:target/cucumber-pretty.txt"} 
		
		)

public class RunnerTest extends AbstractTestNGCucumberTests {}
