package rahulShettyEcomerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.ReusableMethods;

public class PlacedOrder extends ReusableMethods {
	

WebDriver driver;
	
	public PlacedOrder(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);}
	
	@FindBy(xpath="//*[@class='hero-primary']")
	private WebElement successMSG;
	
	public void success() {
		String msg=successMSG.getText();
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
	}
	
	

}
