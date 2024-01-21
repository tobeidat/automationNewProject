package newAutomationProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCases extends parameters {

	@BeforeTest
	public void setup() {
		website_login();

	}

	@Test(priority = 1)
	public void loginToWebsite() throws IOException, InterruptedException {
		loginFunction(driver.findElement(By.cssSelector("#user-name")),
				driver.findElement(By.cssSelector("#password")));

	}

	@Test(priority = 2)
	public void addTwoRandomItems() {
		addTwoRandomProductFunction(driver.findElements(By.className("btn")));

	}

	@Test(priority = 3)
	public void checkoutProcess() throws InterruptedException {
		WebElement cart = driver.findElement(By.className("shopping_cart_link"));
		cart.click();
		Thread.sleep(2000);
		WebElement checkoutButton = driver.findElement(By.id("checkout"));
		checkoutButton.click();
		Thread.sleep(2000);
		WebElement firstName = driver.findElement(By.id("first-name"));
		WebElement lastName = driver.findElement(By.id("last-name"));
		WebElement postalCode = driver.findElement(By.id("postal-code"));
		WebElement continueButton = driver.findElement(By.id("continue"));
		firstName.sendKeys("leen");
		lastName.sendKeys("omar");
		postalCode.sendKeys("123467890");
		Thread.sleep(2000);
		continueButton.click();
		Thread.sleep(2000);
		WebElement finishButton = driver.findElement(By.id("finish"));
		finishButton.click();

	}

	@Test(priority = 5)
	public void logout() throws InterruptedException {
		WebElement optionsMenu = driver.findElement(By.id("react-burger-menu-btn"));
		optionsMenu.click();
		Thread.sleep(2000);
		WebElement logoutButtondriver = driver.findElement(By.id("logout_sidebar_link"));
		logoutButtondriver.click();
	}

}
