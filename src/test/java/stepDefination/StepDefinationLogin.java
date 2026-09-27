package stepDefination;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulShettyEcomerce.LandingPage;
import rahulShettyEcomerce.MyCart;
import rahulShettyEcomerce.OrderPage;
import rahulShettyEcomerce.PaymentPage;
import rahulShettyEcomerce.PlacedOrder;
import rahulShettyEcomerce.ProductCataloge;
import testComponent.BaseTest;

public class StepDefinationLogin extends BaseTest {
	public LandingPage landingPage;
	public ProductCataloge ProductCataloge;
	public OrderPage OrderPage;
	public MyCart MyCart;
	public PlacedOrder PlacedOrder;

	@Given("user at Ecomerce website")
	public void user_at_Ecomerce_website() throws IOException {
		landingPage = LaunchApplication();
	}

	@Given("^Logged in with username(.+) and password(.+)$")
	public void Logged_in_with_username_and_password(String username, String password) {
		ProductCataloge = LandingPage.LogintoApp(username, password);
	}

	@When("^I add product to cart (.+)$")
	public void I_add_product_to_cart(String product) {

		ProductCataloge.AddProductToCard(product);

	}

	@When("^checkout (.+)and submit the order$")
	public void checkout__and_submit_the_order(String Product) {
		MyCart = ProductCataloge.GoTocard();
		boolean nameofItem = MyCart.CardItom(Product);
		Assert.assertTrue(nameofItem);
		PaymentPage PaymentPage = MyCart.CheckOut();
		PaymentPage.Date();
		PaymentPage.month();
		PaymentPage.cvv();
		PaymentPage.nameOnCard();
		PaymentPage.country();
		PaymentPage.placeOrder();

	}

	@Then("comfirmation msg dispayed {string}")
	public void comfirmation_msg_dispayed(String string) {
		PlacedOrder = new PlacedOrder(driver);
		PlacedOrder.success();
		driver.close();
	}

	@Then("System give {string}")
	public void System_give(String string) {
		Assert.assertEquals("Incorrect email or password.", LandingPage.ErrorValidationMSG());
		
	}
}
