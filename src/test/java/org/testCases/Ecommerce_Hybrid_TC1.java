package org.testCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.pageObjects.android.CartPage;
import org.pageObjects.android.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.AndroidActions;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Ecommerce_Hybrid_TC1 extends BaseTest {
	ProductCatalogue productCatalogue;
	CartPage cartPage;

	@Test(priority = 1)
	public void fileForm() throws InterruptedException {
		Thread.sleep(2000);

		formPage.setNameField("sonie maurya");
		formPage.setGender("Female");
		formPage.setCountrySelection("Argentina");
		productCatalogue = formPage.submitButton();

	}

	@Test(priority = 2)
	public void addCardItem() {
		AndroidActions actions = new AndroidActions(driver);
		actions.waitForVisibility(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));

		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		cartPage = productCatalogue.cartBtn();
	}

	@Test(priority = 3)
	public void verifyAmount() {

		double productSum = cartPage.getProductSum();
		double totalAmount = cartPage.getTotalAmount();

		Assert.assertEquals(productSum, totalAmount);

		cartPage.termsAndConditions();
		cartPage.proceedBtn();
	}

	@Test(priority = 4)
	public void verifyHybridApp() throws InterruptedException {

		Set<String> contextHandles = driver.getContextHandles();
		for (String contextName : contextHandles) {
			System.out.println(contextName);
		}

//		Thread.sleep(5000);

		driver.context("WEBVIEW_chrome");
		driver.findElement(By.name("q")).sendKeys("appium documetation");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
}
