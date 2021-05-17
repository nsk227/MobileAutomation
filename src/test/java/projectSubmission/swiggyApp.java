package projectSubmission;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class swiggyApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver <MobileElement> driver;
		URL url =new URL ("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11.0.0");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("appPackage", "in.swiggy.android");
		capabilities.setCapability("appActivity", "in.swiggy.android.activities.HomeActivity");
		driver = new AndroidDriver<MobileElement> (url, capabilities);
		System.out.println("Test of SiwggyApp Begin");
		Thread.sleep(20000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
		Thread.sleep(5000);

		System.out.println("Login of SiwggyApp Begin");

		List<MobileElement> buttons=driver.findElementsByClassName("android.widget.TextView");

		for (MobileElement button:buttons) {
			System.out.println(button.getText());
			if(button.getText().equals("(260) 715-7424")) {
				button.click();
			}
		}
		Thread.sleep(2000);

		List<MobileElement> fields=driver.findElementsByClassName("android.widget.EditText");

		for (MobileElement field:fields) {
			if(field.getText().equals("+126071574")) {
				field.sendKeys("8067466771");
			}
		}
		Thread.sleep(5000);

		driver.findElement(By.xpath("//android.widget.TextView[@text='CONTINUE']")).click();
		Thread.sleep(20000);

		driver.findElement(By.xpath("//android.widget.EditText[@text='EMAIL ADDRESS']")).sendKeys("khadkasnaresh@gmail.com");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.EditText[@text='NAME']")).sendKeys("NARESHKHADKA");
		Thread.sleep(5000);

		WebElement SignUp=driver.findElement(By.xpath("//android.widget.TextView[@text='SIGN UP']"));
		SignUp.click();
		
		if(SignUp.getText().equals("SIGN UP")) {
			System.out.println("Test PASS, Signup button is displayed and active");
		}
		else {
			System.out.println("Test FAIL");
		}

		Thread.sleep(5000);
		System.out.println("Test Complete");

	}

}



