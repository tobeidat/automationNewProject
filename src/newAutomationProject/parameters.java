package newAutomationProject;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class parameters {
	WebDriver driver = new ChromeDriver();

	public void website_login() {
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/inventory.html");
	}

	public void loginFunction(String username, String password) throws InterruptedException, IOException {
		WebElement userNameElement = driver.findElement(By.cssSelector("#user-name"));
		WebElement userPasswordElement = driver.findElement(By.cssSelector("#password"));
		WebElement loginButtonElement = driver.findElement(By.className("btn_action"));
		userNameElement.sendKeys(username);
		userPasswordElement.sendKeys(password);
		Thread.sleep(1000);
		loginButtonElement.click();
		Date currentDate = new Date();
		String folderName = currentDate.toString().replace(":", "-");
		TakesScreenshot src = ((TakesScreenshot) driver);
		File srcFile = src.getScreenshotAs(OutputType.FILE);
		File destenation = new File("src/screenshot/" + folderName + ".png");
		FileUtils.copyFile(srcFile, destenation);
		Thread.sleep(2000);

	}

	public void addTwoRandomProductFunction(List<WebElement> alladdToCartElements) {

		List<WebElement> addToCartElements = alladdToCartElements;
		Random rand = new Random();
		int firstRandomNumber = rand.nextInt(addToCartElements.size());
		addToCartElements.get(firstRandomNumber).click();
		int secondRandomNumber = rand.nextInt(addToCartElements.size());

		while (secondRandomNumber == firstRandomNumber) {
			secondRandomNumber = rand.nextInt(addToCartElements.size());
		}

		addToCartElements.get(secondRandomNumber).click();

	}

}
