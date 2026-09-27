package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulShettyEcomerce.MyCart;
import rahulShettyEcomerce.OrderPage;

public class ReusableMethods {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public ReusableMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//button[@tabindex='0'])[3]")
	WebElement cardButton;
	
	@FindBy(xpath="//button[text()=' HOME ']")
	WebElement Orderbutton;
	
	By Loading = By.xpath("//div[contains(@class,'ng-animating')]");

	public void waitElementToAppear(By findby) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby));
	}

	public void WaitInvisibility(By FindBy) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(FindBy));
	}

	public void WaitUntilWebElementVisible(WebElement FindBy) {
		wait.until(ExpectedConditions.visibilityOf(FindBy));
	}

	public MyCart GoTocard() {

		cardButton.click();
		MyCart MyCart = new MyCart(driver);
		return MyCart;
	}
	public OrderPage GoToOrderPage() {
		Orderbutton.click();
		OrderPage OrderPage=new OrderPage(driver);
		return OrderPage;
	}

}
