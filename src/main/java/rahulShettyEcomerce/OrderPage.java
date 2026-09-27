package rahulShettyEcomerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.ReusableMethods;

public class OrderPage extends ReusableMethods {
	WebDriver driver;
	

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[contains(@class,'table table-border')]//td[2]")
	private List<WebElement> Orders;

	public Boolean CheckOrder(String name) {
		Boolean match = Orders.stream().allMatch(order -> order.getText().equalsIgnoreCase(name));
		return match;
	}

}
