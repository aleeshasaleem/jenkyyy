package playwright.playwright_TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AppTest {
    Playwright playwright;
    Browser browser;
    Page page;
    @BeforeMethod
    public void setup() {
    	playwright = Playwright.create();
    	browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    	page = browser.newPage();
    	page.navigate("https://www.saucedemo.com/");
    	
    	}
    @Test
	public void login() {
		 page.locator("#user-name").fill("standard_user");
	        page.waitForTimeout(1000);
	        page.locator("#password").fill("secret_sauce");
	        page.waitForTimeout(2000);
	        page.locator("#login-button").click();
    }
    @AfterMethod
    public void close() {
    	browser.close();
    	playwright.close();
    }
}
