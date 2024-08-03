import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://fitpeo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Thread.sleep(1000);
		driver.findElement(By.linkText("Revenue Calculator")).click();
		Thread.sleep(3000);

		WebElement searcheElement = driver
				.findElement(By.xpath("//*[contains(@class, 'MuiTypography-root MuiTypography-body1 inter')]"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].scrollIntoView()", searcheElement);

		WebElement slider = driver.findElement(By.xpath("//*[contains(@class, 'MuiSlider-track')]"));
		Actions move = new Actions(driver);
		move.dragAndDropBy(slider, 108, 0).release().perform();

		Thread.sleep(1000);// driver.findElement(By.xpath("//*[contains(@class, 'MuiInputBase-root
							// MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl
							// MuiInputBase-sizeSmall')]"));
		WebElement textField = driver.findElement(By.id(":r0:"));
		textField.sendKeys(Keys.BACK_SPACE);
		textField.sendKeys(Keys.BACK_SPACE);
		textField.sendKeys(Keys.BACK_SPACE);
		textField.sendKeys(Keys.BACK_SPACE);
		textField.sendKeys(Keys.NUMPAD5);
		textField.sendKeys(Keys.NUMPAD6);
		textField.sendKeys(Keys.NUMPAD0);

		driver.findElement(By.xpath("//div[@class='MuiBox-root css-rfiegf']//div[1]//label[1]//span[1]//input[1]"))
				.click();
		driver.findElement(By.xpath("//div[@class='MuiBox-root css-1p19z09']//div[2]//label[1]//span[1]//input[1]"))
				.click();

		driver.findElement(By.xpath("//div[3]//label[1]//span[1]//input[1]")).click();
		driver.findElement(By.xpath("//div[8]//label[1]//span[1]//input[1]")).click();

		String result = driver.findElement(By.xpath("//p[normalize-space()='$75600']")).getText();
		if (result != "$75600") {
			System.out.println("Verified successfully ");
		} else {
			System.out.println("Not Verified");
		}

	}

}
