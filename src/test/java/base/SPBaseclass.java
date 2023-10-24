package base;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import listeners.Listeners;
import utilities.SPUtilityPgm;

public class SPBaseclass extends SPUtilityPgm{

	Listeners listeners;
	@BeforeMethod	
	public void startup() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		//driver.get("https://www.spicejet.com/search?from=DEL&to=BLR&tripType=1&departure=2023-12-18&adult=2&child=1&srCitizen=0&infant=0&currency=USD&redirectTo=/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
		InilializeWebDriverWait();
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
