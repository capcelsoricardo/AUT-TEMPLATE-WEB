package curso.treinamento.setup;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import curso.treinamento.utils.Helper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static WebDriver driver;
	public static ResourceBundle bundle = ResourceBundle.getBundle("project");
	public static int TIMEOUT_DEFAULT = Integer.parseInt(bundle.getString("env.timeout.default"));
	
	@Before
	public void start_test(Scenario scenario) {
														
		switch (bundle.getString("env.navegador").toUpperCase()) {
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", Helper.get_path_driver(bundle.getString("env.navegador")));
			break;						
		default:			
			Assert.fail("Opção de navegador inválida.");
			break;
		}
						
		driver = new ChromeDriver();
				
		//driver.manage().timeouts().implicitlyWait(TIMEOUT_DEFAULT, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(bundle.getString("env.url"));									
	}
	
	@After
	public void tear_down(Scenario scenario) { 
		Helper.screenshot(scenario);
		driver.close();
	}
	
	public static WebDriver getDriver() { 
		return driver;
	}
}