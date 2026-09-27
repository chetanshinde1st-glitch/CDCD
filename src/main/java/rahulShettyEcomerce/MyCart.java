package rahulShettyEcomerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.ReusableMethods;

public class MyCart extends ReusableMethods{
	
	WebDriver driver;
	
	public MyCart(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//div[@class='cartSection']//h3")
	private List<WebElement> Carditems;
	@FindBy (xpath="//*[text()='Checkout']")
	private WebElement Checkout;
	
	public boolean CardItom(String name) {
		boolean nameofItem = Carditems.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(name.trim()));
		return nameofItem;
	}
	public PaymentPage CheckOut() {
		Checkout.click();
		PaymentPage PaymentPage=new PaymentPage(driver);
		return PaymentPage;
	}
	
	
	

}
