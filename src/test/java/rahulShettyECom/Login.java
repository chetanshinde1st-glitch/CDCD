package rahulShettyECom;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulShettyEcomerce.MyCart;
import rahulShettyEcomerce.OrderPage;
import rahulShettyEcomerce.PaymentPage;
import rahulShettyEcomerce.PlacedOrder;
import rahulShettyEcomerce.ProductCataloge;
import testComponent.BaseTest;

public class Login extends BaseTest {
	String name = "ZARA COAT 3";

	@Test (dataProvider = "dataset",groups="mutipleDataset")
	public void Purchase(HashMap<String,String>dataset) throws IOException {

		ProductCataloge ProductCataloge = LandingPage.LogintoApp(dataset.get("email"),dataset.get("password"));

		ProductCataloge.AddProductToCard(dataset.get("product"));
		MyCart MyCart = ProductCataloge.GoTocard();

		boolean nameofItem = MyCart.CardItom(dataset.get("product"));
		Assert.assertTrue(nameofItem);
		PaymentPage PaymentPage = MyCart.CheckOut();
		PaymentPage.Date();
		PaymentPage.month();
		PaymentPage.cvv();
		PaymentPage.nameOnCard();
		PaymentPage.country();
		PaymentPage.placeOrder();
		PlacedOrder PlacedOrder = new PlacedOrder(driver);
		PlacedOrder.success();
	}

	@Test
	public void orderConfirmation() {
		ProductCataloge ProductCataloge = LandingPage.LogintoApp("chetanshinde1@gmail.com", "Chetan@123");
		OrderPage OrderPage = ProductCataloge.GoToOrderPage();
		Assert.assertTrue(OrderPage.CheckOrder(name));

	}

	@DataProvider
	public Object[][] dataset() {
		HashMap<String, String>map=new HashMap<String, String>();
		map.put("email","chetanshinde1@gmail.com");
		map.put("password", "Chetan@123");
		map.put("product", "ZARA COAT 3" );
		
		HashMap<String, String>map2=new HashMap<String, String>();
		map2.put("email","chetanshinde@gmail.com");
		map2.put("password", "Chetan@123");
		map2.put("product", "ADIDAS ORIGINAL"  );
		
//		return new Object[][] { { "chetanshinde1@gmail.com", "Chetan@123", "ZARA COAT 3" },
//				{ "chetanshinde@gmail.com", "Chetan@123", "ADIDAS ORIGINAL" } };
		 return new Object[][] {{map},{map2}};
	}

}
