package rahulShettyEcomerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.ReusableMethods;

public class ProductCataloge extends ReusableMethods{

	WebDriver driver;
	public ProductCataloge(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@class='row'])[3]//div[@class='card']")
	private List <WebElement> products;
	
	
	
	private By listOfProduct=By.xpath("(//div[@class='row'])[3]//div[@class='card']");
	private By addToCard=By.xpath(".//button[2]");
	private By successmsg=By.xpath("//*[@id='toast-container']");
	private By Loading=By.xpath("//div[contains(@class,'ng-animating')]");
	
	public List<WebElement> getList() {
		waitElementToAppear(listOfProduct);
		return products;
		
	}
	public WebElement getReqProd(String name) {
		WebElement required = products.stream().filter(product->product.findElement(By.xpath(".//b")).getText().equals(name)).findFirst().orElse(null);
		return required;
	}
	public void AddProductToCard(String name) {
		waitElementToAppear(addToCard);
		WebElement prod= getReqProd( name);
		prod.findElement(addToCard).click(); 
		waitElementToAppear(successmsg);
		WaitInvisibility(Loading);
	}
	
	

	

}
