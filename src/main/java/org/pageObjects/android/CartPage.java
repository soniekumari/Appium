package org.pageObjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {

	public AndroidDriver driver;

	public CartPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrice;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalPurchaseAmmount;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private List<WebElement> checkbox;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedBtn;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement terms;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement acceptBtn;

	public double getProductSum() {
		int size = productPrice.size();
		double productSum = 0;
		for (int i = 0; i < size; i++) {
			String amountPrice = productPrice.get(i).getText();
			Double price = getFormattedAmount(amountPrice);
			productSum = productSum + price;
		}
		return productSum;
	}

	public double getTotalAmount() {
		
		return getFormattedAmount(totalPurchaseAmmount.getText());

	}
	
	public void termsAndConditions() {
		longPressActions(terms);
		acceptBtn.click();
	}
	
	public void proceedBtn() {
		checkbox.get(0).click();
		proceedBtn.click();
	}
}
