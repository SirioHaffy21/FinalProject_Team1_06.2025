package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.MayRuaChenBat_PageLocator;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.*;
import org.testng.annotations.*;

public class MayRuaChenBat_Test extends CommonBase {
	private MayRuaChenBat_PageLocator mayruachen;

	@BeforeMethod
	@Parameters("browser")
	public void initBrowser(@Optional("edge") String browser) {
		setupDriver(browser);
		driver.get(CT_PageURL.SyHa_MayRuaChen_URL);
		mayruachen = new MayRuaChenBat_PageLocator(driver);
	}

	@Test
	public void searchByBranch() {
		String keyword = "bosch";
		mayruachen.searchByBranch(keyword);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		@SuppressWarnings("unchecked")
		// div[contains(@class, 'product-list')]//a[contains(@href, 'bosch')]
		List<WebElement> resultsSearchBranch = driver.findElements(
				By.xpath("//div[contains(@class, 'product-list')]//a[contains(@href, '" + keyword + "')]"));
		assertTrue(resultsSearchBranch.size() > 0);
	}

	@AfterMethod
	public void endBrowser() {
		closeDriver();
	}
}
