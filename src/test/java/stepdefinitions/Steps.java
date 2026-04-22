package stepdefinitions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	WebDriver driver;

	ChromeOptions options;

	@Given("the user Open a web browser and navigate to the specified pet store URL")
	public void navigateToUrl() {
		options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();

		// Disables the 'Change your password' leak detection popup
		prefs.put("profile.password_manager_leak_detection", false);
		options.setExperimentalOption("prefs", prefs);
		
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://petstore.octoperf.com/");
	}

	@Given("the user Click on the Enter the Store link to access the main page")
	public void the_user_click_on_the_enter_the_store_link_to_access_the_main_page() {
		driver.findElement(By.xpath("//a[normalize-space()='Enter the Store']")).click();
	}

	@Given("the clicks Click on the Sign In link to log into the store")
	public void the_clicks_click_on_the_sign_in_link_to_log_into_the_store() {
		driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
	}

	@When("the user enters valid credentials \\(username: {string}, password: {string})")
	public void the_user_enters_valid_credentials_username_password(String name, String pswd)
			throws InterruptedException {
		WebElement username = driver.findElement(By.xpath("//input[@name = 'username']"));
		username.clear();
		username.sendKeys(name);
		WebElement pass = driver.findElement(By.xpath("//input[@name = 'password']"));
		pass.clear();
		pass.sendKeys(pswd);

		driver.findElement(By.xpath("//input[@name = 'signon']")).click();

	}

	@When("the user Click on various product links to view details and add them to the cart")
	public void the_user_click_on_various_product_links_to_view_details_and_add_them_to_the_cart() {
		driver.findElement(By.xpath("//a[contains(@href, 'FISH')]")).click();
		driver.findElement(By.xpath("//a[contains(@href, 'FI-SW-02')]")).click();
		driver.findElement(By.xpath("//a[@class='Button' and contains(@href, 'EST-3')]")).click();

		driver.findElement(By.xpath("//a[contains(@href, 'CATS')]")).click();
		driver.findElement(By.xpath("//a[contains(@href, 'FL-DSH-01')]")).click();
		driver.findElement(By.xpath("//a[@class='Button' and contains(@href, 'EST-15')]")).click();

	}

	@Then("the user Proceed to checkout after adding each product to the cart")
	public void the_user_proceed_to_checkout_after_adding_each_product_to_the_cart() {
		driver.findElement(By.xpath("//a[@class='Button' and contains(@href, 'newOrderForm')]")).click();
	}

	
	@Then("the user Close the web browser after completing the actions")
	public void the_user_close_the_web_browser_after_completing_the_actions() {
		driver.quit();
	}

}
