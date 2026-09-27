package rahulShettyECom;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulShettyEcomerce.MyCart;
import rahulShettyEcomerce.ProductCataloge;
import testComponent.BaseTest;
import testComponent.Retry;

public class ErrroValidation extends BaseTest {

	@Test(groups="ErrorHandelling",retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException {

		LandingPage.LogintoApp("chetanshinde@gmail.com", "Cddhetan@1234");
		Assert.assertEquals("Incorrect email or password.", LandingPage.ErrorValidationMSG());

	}

	@Test
	public void AddToCartValidation() {

		String name = "ZARA COAT 3";

		ProductCataloge ProductCataloge = LandingPage.LogintoApp("chetanshinde@gmail.com", "Chetan@123");

		ProductCataloge.AddProductToCard(name);
		MyCart MyCart = ProductCataloge.GoTocard();

		boolean nameofItem = MyCart.CardItom("ZARA COAT 322");
		Assert.assertFalse(nameofItem);

	}

}
