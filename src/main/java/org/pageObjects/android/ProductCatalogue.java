package org.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidActions {

	AndroidDriver driver;

	public ProductCatalogue(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); // initElements will call once in a beginning to all locators what we have This line will construct to the @ annotation locators

	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"ADD TO CART\"]")
	public List<WebElement> addToCart;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartbtn;

	public void addItemToCartByIndex(int index) {
		addToCart.get(index).click();
	}

	public CartPage cartBtn() {
		cartbtn.click();
		return new CartPage(driver);
	}
}
