package automation.testsuite;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.*;

public class MayRuaChenBatCheckout_Tests extends CommonBase{
	private MayRuaChenBat_PageLocator mayruachen;
	private MayRuaChenBatDetails_PageLocator mayruachen_detail;
	private MayRuaChenBatCheckout_PageLocator mayruachen_checkout;
	private String name = "Super Man";
	private String phone = "0355555555";
	private String address = "USA";
	private By messageFailedCheckout = By.xpath("//small[contains(text(), 'không hợp lệ')]");
	
	@BeforeMethod
	@Parameters("browser")
	public void initProcess(@Optional("chrome") String browser) {
		setupDriver(browser);
		driver.get(CT_PageURL.SyHa_MayRuaChen_URL);
		mayruachen = new MayRuaChenBat_PageLocator(driver);
		mayruachen.viewDetailProduct();
		assertTrue(mayruachen.isDisplayedDetails());
		pause(3000);
		mayruachen_detail = new MayRuaChenBatDetails_PageLocator(driver);
		mayruachen_detail.buyNow();
		pause(3000);
		mayruachen_checkout = new MayRuaChenBatCheckout_PageLocator(driver);
		assertTrue(mayruachen_checkout.isDisplayedCheckout());
	}
	
	@Test
	public void payment_Failed_With_Empty_Phone() {
		mayruachen_checkout.checkout("", phone, address);
		assertTrue(isElementDisplayed(messageFailedCheckout));
	}
	
	@Test
	public void payment_Failed_With_Empty_Address() {
		mayruachen_checkout.checkout(name, "", address);
		assertTrue(isElementDisplayed(messageFailedCheckout));
	}
	
	@Test
	public void payment_Failed_With_Empty_Name() {
		mayruachen_checkout.checkout(name, phone, "");
		assertTrue(isElementDisplayed(messageFailedCheckout));
	}
	
	@AfterMethod
	public void endProcess() {
		closeDriver();
	}
}
