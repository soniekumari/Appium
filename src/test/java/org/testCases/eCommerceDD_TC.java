package org.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class eCommerceDD_TC extends BaseTest {
	
	@BeforeMethod
	public void preSetup() {
		
		formPage.setActivity();
		
	}

	@Test(dataProvider = "setData")
	public void getData(String name, String gender, String countryName) throws InterruptedException{
		Thread.sleep(2000);

		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.setCountrySelection(countryName);
		formPage.submitButton();
	}

	@DataProvider
	public Object[][] setData() {

		return new Object[][] { { "Sonie Maurya", "female", "Algeria" },
			{"Sima", "male", "Argentina"}
		};
	}
}
