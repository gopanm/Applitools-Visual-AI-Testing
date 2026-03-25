package maven.applitools;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.applitools.eyes.selenium.Eyes;

public class AppTest {
	
	public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        Eyes eyes = new Eyes();

        // Applitools API key
        eyes.setApiKey("kRiLcAL72ozDa110kXVCLqubU5AeY3rdma0gtrdh683Kk110");

        try {

            driver = eyes.open(driver, "SauceDemo App", "Login Page Visual Test");

            driver.get("https://www.saucedemo.com/");

            // Visual checkpoint (Login page)
            eyes.checkWindow("Login Page");

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Visual checkpoint (Products page)
            eyes.checkWindow("Products Page");

            eyes.close();

        } 
        finally {

            driver.quit();
            eyes.abortIfNotClosed();

        }
    }
}
