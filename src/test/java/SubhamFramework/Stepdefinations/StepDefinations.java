package SubhamFramework.Stepdefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import SeleniumFrameworks.pageobjects.CheckOutPage;
import SeleniumFrameworks.pageobjects.ConfirmationPage;
import SeleniumFrameworks.pageobjects.LandingPage;
import SeleniumFrameworks.pageobjects.ProductCheckoutPage;
import SeleniumFrameworks.pageobjects.productCataloguePage;
import SubhamFramework.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinations extends BaseTest{
	
	LandingPage obj;
	productCataloguePage pcat;
	CheckOutPage checkout;
	ConfirmationPage confirmpage;
	
	
	@Given("user landed on the Ecommerce page")
	public void user_landed_on_the_Ecommerce_page() throws IOException
	{
		GlobalHooks.node = GlobalHooks.test.createNode("Given: user landed on the Ecommerce page");
		obj = launchApplication();
	}
	
	@Given("^User login with username (.+) and password (.+)$")
	public void User_login_with_username_and_password(String username,String password)
	{
		GlobalHooks.node = GlobalHooks.test.createNode("Given : User login with username " + username + " and password "+ password);
		pcat = obj.loginPage(username,password);
	}
	
	@When("^User added the product (.+) to the cart$")
	public void User_added_the_product_to_the_cart(String product)
	{
		GlobalHooks.node = GlobalHooks.test.createNode("When : User added the product " + product + " to the cart");
		List<WebElement> products = pcat.getproductList();
		pcat.addProductToCart(product);
	}
	@And("^user checks the product in the cart page (.+) and submit the order with (.+) country$")
	public void user_checks_the_product_in_the_cart_page_and_submit_the_order_with_country(String product,String country) throws InterruptedException
	{

		GlobalHooks.node = GlobalHooks.test.createNode("And : user checks the product in the cart page " + product + " and submit the order with " + country + " country");
		ProductCheckoutPage prodcheck = pcat.clickToCart();
		Boolean expects = prodcheck.getMatchingProduct(product);
		Assert.assertTrue(expects);
		Thread.sleep(1000);
		checkout = prodcheck.scrollPage();
		checkout.selectCountry(country);
		confirmpage = checkout.submitOrder();
	}
	@Then("{string} message got displayed in the confirmation page")
	public void message_got_displayed_in_the_confirmation_page(String msg)
	{
		GlobalHooks.node = GlobalHooks.test.createNode("Then: " + msg + " message got displayed in the confirmation page");
		String message = confirmpage.getConfirmationMessage();
		Assert.assertEquals(message,msg);
		teardown();
	}

}
