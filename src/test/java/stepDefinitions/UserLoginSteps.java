package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//import com.sun.tools.javac.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginSteps {
	WebDriver driver;
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.manage().window().maximize();
	}
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
	    driver.get("https://the-internet.herokuapp.com/login");
	}
//	@When("User enters credentials")
//	public void user_enters_credentials() {
//		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("tomsmith");
//		WebElement password = driver.findElement(By.id("password"));
//    	password.sendKeys("SuperSecretPassword!");
//		driver.findElement(By.tagName("button")).click();
//	}
	
//	@When("User enters {string} and {string}")
//	public void user_enters_and(String name, String password) {
//		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(name);
//	   WebElement pass = driver.findElement(By.id("password"));
//    	pass.sendKeys(password);
//		driver.findElement(By.tagName("button")).click();
//	}
	
//	@When("User enters credentials")
//	public void user_enters_credentials(DataTable dataTable) {
//		List<List<String>> users=dataTable.asLists();
//		String name=users.get(0).get(0);
//		String password=users.get(0).get(1);
//		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(name);
//		 WebElement pass = driver.findElement(By.id("password"));
//	    pass.sendKeys(password);
//		driver.findElement(By.tagName("button")).click();
//	}
	
	//Fetching lists of Map from Datatable
	@When("User enters credentials")
	public void user_enters_credentials(DataTable dataTable) {
		List<Map<String,String>> users=dataTable.asMaps();
		String name=users.get(0).get("username");
		String password=users.get(0).get("password");
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(name);
		 WebElement pass = driver.findElement(By.id("password"));
	    pass.sendKeys(password);
		driver.findElement(By.tagName("button")).click();
	}
	
//	@Then("Should display Success Msg")
//	public void should_display_success_msg() {
//		boolean isUserValid = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
//    	Assert.assertTrue(isUserValid);
//	}
	@Then("Should display Success Msg")
	public void should_display_success_msg(DataTable dataTable) {
	List<String> msgs=dataTable.asList();
	String expmsg=msgs.get(0);
	Assert.assertEquals("You logged into a secure area!",expmsg);
	}
	
}
