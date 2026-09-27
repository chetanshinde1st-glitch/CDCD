package rahulShettyEcomerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import abstractComponents.ReusableMethods;

public class PaymentPage extends ReusableMethods{
	
	WebDriver driver;
	
	public PaymentPage (WebDriver driver) {
	super(driver);
	this.driver=driver;
	}
	
	@FindBy(xpath="//*[@class='input ddl'][1]")
	private WebElement date;
	@FindBy(xpath="//*[@class='input ddl'][2]")
	private WebElement month;
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement CVV;
	@FindBy(xpath="(//input[@type='text'])[3]")
	private WebElement Name_on_Card;
	@FindBy(xpath="(//*[@class='input txt text-validated'])[2]")
	private WebElement County;
	@FindBy (xpath="(//span[@class='ng-star-inserted'])[2]")
	private WebElement India;
	@FindBy(xpath="//a[text()='Place Order ']")
	private WebElement PlaceOrder;
	
	By visibility=By.xpath("(//span[@class='ng-star-inserted'])[2]");
	
	
	public void Date() {
		Select s=new Select(date);
		s.selectByVisibleText("01");
	}
	public void month() {
		Select s=new Select(month);
		s.selectByVisibleText("04");
	}
	public void cvv() {
		CVV.sendKeys("111");
	}
	public void nameOnCard() {
		Name_on_Card.sendKeys("Chetan Shinde");
	}
	
	public void country() {
		County.sendKeys("India");
		waitElementToAppear(visibility);
		India.click();
	}
	public void placeOrder() {
		
		PlaceOrder.click();
	}
	
	
}
