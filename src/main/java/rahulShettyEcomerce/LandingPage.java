package rahulShettyEcomerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.ReusableMethods;

public class LandingPage extends ReusableMethods {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='userEmail']")
	private WebElement user;

	@FindBy(xpath = "//input[@id='userPassword']")
	private WebElement Passkey;

	@FindBy(xpath = "//input[@id='login']")
	private WebElement Login;

	@FindBy(css="[class*='flyInOut']")
	private WebElement errorMSG;
	
	public ProductCataloge LogintoApp(String username, String Password) {
		user.sendKeys(username);
		Passkey.sendKeys(Password);
		Login.click();
		ProductCataloge ProductCataloge = new ProductCataloge(driver);
		return ProductCataloge;
	}

	public void Goto() {
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
	public String ErrorValidationMSG() {
		WaitUntilWebElementVisible(errorMSG);
		String massage = errorMSG.getText();
		return massage;
	}

}
