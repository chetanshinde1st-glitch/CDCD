package rahulShettyEcomerce;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Login {

	public static void main(String[] args) {
	    String name="ZARA COAT 3";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LandingPage LandingPage= new LandingPage(driver);
		LandingPage.Goto();
		ProductCataloge ProductCataloge=LandingPage.LogintoApp("chetanshinde@gmail.com", "Chetan@123");
		
		
		ProductCataloge.AddProductToCard(name);	
		MyCart MyCart=ProductCataloge.GoTocard();
		
		boolean nameofItem =MyCart.CardItom(name);
		Assert.assertTrue(nameofItem);
		MyCart.CheckOut();
		PaymentPage PaymentPage=new PaymentPage(driver);
		PaymentPage.Date();
		PaymentPage.month();
		PaymentPage.cvv();
		PaymentPage.nameOnCard();
		PaymentPage.country();
		PaymentPage.placeOrder();
		PlacedOrder PlacedOrder=new PlacedOrder(driver);
		PlacedOrder.success();

		
		
     




	}

}
