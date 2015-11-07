import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class launchIE {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		String iedriverPath = System.getProperty("user.dir")
				+ "\\resources\\IEDriverServer32.exe";
		System.setProperty("webdriver.ie.driver", iedriverPath);

		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		// this line of code is to resolve protected mode issue
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY,
				true);

		driver = new InternetExplorerDriver(capabilities);

		driver.manage().window().maximize();

		driver.get("https://www.google.com");

	}
}