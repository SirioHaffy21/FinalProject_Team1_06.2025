package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.MayRuaChenBat_PageLocator;
import automation.utils.CheckList;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.*;
import org.testng.annotations.*;

public class MayRuaChenBat_Test extends CommonBase {
	private MayRuaChenBat_PageLocator mayruachen;
	private String quantity = "10";
	private String keyword = "bosch";
	private String price = "> 15.000.000";
	private String origin = "Germany";

	@BeforeMethod
	@Parameters("browser")
	public void initBrowser(String browser) {
		setupDriver(browser);
		driver.get(CT_PageURL.SyHa_MayRuaChen_URL);
		mayruachen = new MayRuaChenBat_PageLocator(driver);
	}

	@Test
	public void searchByBranch_checkItemInList() {
		mayruachen.searchByBranch(keyword);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		@SuppressWarnings("unchecked")
		// div[contains(@class, 'product-list')]//a[contains(@href, 'bosch')]
		List<WebElement> resultsSearchBranch = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//a[contains(@href, '" + keyword + "')]"));
		assertTrue(resultsSearchBranch.size() > 0);
	}

	@Test
	public void searchByPrice_checkItemInList() {
		mayruachen.searchByPrice(price);
		List<WebElement> resultSearchPrice = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')]"));
		for (WebElement webElement : resultSearchPrice) {
			String text = webElement.getText().replace("đ", "").replace(".", "").replace(" ", "").replace("₫", "");
			int realPrice = Integer.parseInt(text);
			assertTrue(realPrice > 15000000);
		}
	}

	@Test
	public void searchByOrigin_checkItemInList() {
		mayruachen.searchByOrigin(origin);
		// pause(5000);
		clickByJS(By.xpath("//a[contains(@href, 'bosch-sms6zci42e')]"));
		pause(3000);
		WebElement resultcheck = driver
				.findElement(By.xpath("(//span[contains(text(), 'Xuất xứ')]/following-sibling::span)[1]"));
		String text = resultcheck.getText();
		assertEquals(origin.toUpperCase(), text);
	}

	@Test
	public void searchByQuantity_checkItemInList() {
		mayruachen.searchByQuantity(quantity);
		clickByJS(By.xpath("//a[contains(@href, 'bosch-sps4emi60e')]"));
		pause(3000);
		By xemThemBtn = By.xpath("(//span[text()='Xem thêm nội dung'])[1]");
		clickByJS(xemThemBtn);

		List<WebElement> listContentCheck = driver
				.findElements(By.xpath("//div[contains(@class,'info-detail')]//span"));
		for (WebElement webElement : listContentCheck) {
			String content = webElement.getText();
			if (content.toUpperCase().contains((quantity + " bộ").toUpperCase())) {
				assertTrue(content.toUpperCase().contains((quantity + " bộ").toUpperCase()));
				break;
			}
		}
	}

	@Test
	public void searchByBranchAndPrice_checklist() {
		mayruachen.searchByBranch(keyword);
		mayruachen.searchByPrice(price);
		pause(3000);
		@SuppressWarnings("unchecked")
		// div[contains(@class, 'product-list')]//a[contains(@href, 'bosch')]
		List<WebElement> resultsSearchBranch = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//a[contains(@href, '" + keyword + "')]"));
		assertTrue(resultsSearchBranch.size() > 0);

		List<WebElement> resultSearchPrice = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')]"));
		for (WebElement webElement : resultSearchPrice) {
			String text = webElement.getText().replace("đ", "").replace(".", "").replace(" ", "").replace("₫", "");
			int realPrice = Integer.parseInt(text);
			assertTrue(realPrice > 15000000);
		}
	}

	@Test
	public void searchByBranchAndOrigin_checklist() {
		mayruachen.searchByBranch(keyword);
		mayruachen.searchByOrigin(origin);
		pause(3000);
		@SuppressWarnings("unchecked")
		// div[contains(@class, 'product-list')]//a[contains(@href, 'bosch')]
		List<WebElement> resultsSearchBranch = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//a[contains(@href, '" + keyword + "')]"));
		assertTrue(resultsSearchBranch.size() > 0);

		WebElement resultOrigin = driver.findElement(By.xpath("//a[contains(@href, 'bosch-sps6ymi14e')]"));
		resultOrigin.click();
		pause(3000);
		WebElement resultcheck = driver
				.findElement(By.xpath("(//span[contains(text(), 'Xuất xứ')]/following-sibling::span)[1]"));
		String text = resultcheck.getText();
		assertEquals(origin.toUpperCase(), text.toUpperCase());
	}

	@Test
	public void searchByBranchAndQuantity_checklist() {
		mayruachen.searchByBranch(keyword);
		mayruachen.searchByQuantity(quantity);
		@SuppressWarnings("unchecked")
		// div[contains(@class, 'product-list')]//a[contains(@href, 'bosch')]
		List<WebElement> resultsSearchBranch = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//a[contains(@href, '" + keyword + "')]"));
		assertTrue(resultsSearchBranch.size() > 0);

		clickByJS(By.xpath("//a[contains(@href, 'bosch-sps4emi60e')]"));
		pause(3000);
		By xemThemBtn = By.xpath("(//span[text()='Xem thêm nội dung'])[1]");
		clickByJS(xemThemBtn);

		List<WebElement> listContentCheck = driver
				.findElements(By.xpath("//div[contains(@class,'info-detail')]//span"));
		for (WebElement webElement : listContentCheck) {
			String content = webElement.getText();
			if (content.toUpperCase().contains((quantity + " bộ").toUpperCase())) {
				assertTrue(content.toUpperCase().contains((quantity + " bộ").toUpperCase()));
				break;
			}
		}
	}

	@Test
	public void searchByPriceAndOrigin_checklist() {
		mayruachen.searchByPrice(price);
		mayruachen.searchByOrigin(origin);

		List<WebElement> resultSearchPrice = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')]"));
		int count = 1;
		for (WebElement webElement : resultSearchPrice) {
			String text = getText(By.xpath(
					"(//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')])[" + count + "]"))
					.replace("đ", "").replace(".", "").replace(" ", "").replace("₫", "");
			int realPrice = Integer.parseInt(text);
			assertTrue(realPrice > 15000000);
			count++;
		}

		clickByJS(By.xpath("//a[contains(@href, 'bosch-sms6zci42e')]"));
		pause(3000);
		String text = getText(By.xpath("(//span[contains(text(), 'Xuất xứ')]/following-sibling::span)[1]"));
		assertEquals(origin.toUpperCase(), text.toUpperCase());
	}

	@Test
	public void searchByPriceAndQuantity_checklist() {
		mayruachen.searchByPrice(price);
		mayruachen.searchByQuantity(quantity);

		List<WebElement> resultSearchPrice = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')]"));
		int count = 1;
		for (WebElement webElement : resultSearchPrice) {
			String text = getText(By.xpath(
					"(//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')])[" + count + "]"))
					.replace("đ", "").replace(".", "").replace(" ", "").replace("₫", "");
			int realPrice = Integer.parseInt(text);
			assertTrue(realPrice > 15000000);
			count++;
		}

		clickByJS(By.xpath("//a[contains(@href, 'bosch-sps4emi60e')]"));
		pause(3000);
		By xemThemBtn = By.xpath("(//span[text()='Xem thêm nội dung'])[1]");
		clickByJS(xemThemBtn);

		List<WebElement> listContentCheck = driver
				.findElements(By.xpath("//div[contains(@class,'info-detail')]//span"));
		for (WebElement webElement : listContentCheck) {
			String content = webElement.getText();
			if (content.toUpperCase().contains((quantity + " bộ").toUpperCase())) {
				assertTrue(content.toUpperCase().contains((quantity + " bộ").toUpperCase()));
				break;
			}
		}
	}

	@Test
	public void searchByOriginAndQuantity_checklist() {
		mayruachen.searchByOrigin(origin);
		mayruachen.searchByQuantity(quantity);
		pause(3000);
		clickByJS(By.xpath("//a[contains(@href, 'bosch-sps6ymi14e')]"));
		pause(3000);
		String text = getText(By.xpath("(//span[contains(text(), 'Xuất xứ')]/following-sibling::span)[1]"));
		assertEquals(origin.toUpperCase(), text.toUpperCase());

		pause(3000);
		By xemThemBtn = By.xpath("(//span[text()='Xem thêm nội dung'])[1]");
		clickByJS(xemThemBtn);

		List<WebElement> listContentCheck = driver
				.findElements(By.xpath("//div[contains(@class,'info-detail')]//span"));
		for (WebElement webElement : listContentCheck) {
			String content = webElement.getText();
			if (content.toUpperCase().contains((quantity + " bộ").toUpperCase())) {
				assertTrue(content.toUpperCase().contains((quantity + " bộ").toUpperCase()));
				break;
			}
		}
	}

	@Test
	public void searchByBranchAndPriceAndOrigin_checklist() {
		mayruachen.searchByBranch(keyword);
		mayruachen.searchByPrice(price);
		mayruachen.searchByOrigin(origin);
		pause(3000);
		@SuppressWarnings("unchecked")
		// div[contains(@class, 'product-list')]//a[contains(@href, 'bosch')]
		List<WebElement> resultsSearchBranch = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//a[contains(@href, '" + keyword + "')]"));
		assertTrue(resultsSearchBranch.size() > 0);

		List<WebElement> resultSearchPrice = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')]"));
		int count = 1;
		for (WebElement webElement : resultSearchPrice) {
			String text = getText(By.xpath(
					"(//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')])[" + count + "]"))
					.replace("đ", "").replace(".", "").replace(" ", "").replace("₫", "");
			int realPrice = Integer.parseInt(text);
			assertTrue(realPrice > 15000000);
			count++;
		}

		clickByJS(By.xpath("//a[contains(@href, 'bosch-sms6zci42e')]"));
		pause(3000);
		String text = getText(By.xpath("(//span[contains(text(), 'Xuất xứ')]/following-sibling::span)[1]"));
		assertEquals(origin.toUpperCase(), text.toUpperCase());
	}

	@Test
	public void searchByBranchAndOriginAndQuantity_checklist() {
		mayruachen.searchByBranch(keyword);
		pause(1000);
		mayruachen.searchByOrigin(origin);
		pause(1000);
		mayruachen.searchByQuantity(quantity);
		pause(3000);
		@SuppressWarnings("unchecked")
		// div[contains(@class, 'product-list')]//a[contains(@href, 'bosch')]
		List<WebElement> resultsSearchBranch = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//a[contains(@href, '" + keyword + "')]"));
		assertTrue(resultsSearchBranch.size() > 0);

		clickByJS(By.xpath("//a[contains(@href, 'bosch-sps6ymi14e')]"));
		pause(3000);
		WebElement resultcheck = driver
				.findElement(By.xpath("(//span[contains(text(), 'Xuất xứ')]/following-sibling::span)[1]"));
		String text = resultcheck.getText();
		assertEquals(origin.toUpperCase(), text.toUpperCase());
		pause(3000);
		By xemThemBtn = By.xpath("(//span[text()='Xem thêm nội dung'])[1]");
		clickByJS(xemThemBtn);

		List<WebElement> listContentCheck = driver
				.findElements(By.xpath("//div[contains(@class,'info-detail')]//span"));
		for (WebElement webElement : listContentCheck) {
			String content = webElement.getText();
			if (content.toUpperCase().contains((quantity + " bộ").toUpperCase())) {
				assertTrue(content.toUpperCase().contains((quantity + " bộ").toUpperCase()));
				break;
			}
		}
	}

	@Test
	public void searchByBranchAndPriceAndQuantity_checklist() {
		mayruachen.searchByBranch(keyword);
		mayruachen.searchByPrice(price);
		mayruachen.searchByQuantity(quantity);
		pause(3000);
		@SuppressWarnings("unchecked")
		// div[contains(@class, 'product-list')]//a[contains(@href, 'bosch')]
		List<WebElement> resultsSearchBranch = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//a[contains(@href, '" + keyword + "')]"));
		assertTrue(resultsSearchBranch.size() > 0);

		List<WebElement> resultSearchPrice = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')]"));
		int count = 1;
		for (WebElement webElement : resultSearchPrice) {
			String text = getText(By.xpath(
					"(//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')])[" + count + "]"))
					.replace("đ", "").replace(".", "").replace(" ", "").replace("₫", "");
			int realPrice = Integer.parseInt(text);
			assertTrue(realPrice > 15000000);
			count++;
		}

		clickByJS(By.xpath("//a[contains(@href, 'bosch-sps4emi60e')]"));
		pause(3000);
		By xemThemBtn = By.xpath("(//span[text()='Xem thêm nội dung'])[1]");
		clickByJS(xemThemBtn);

		List<WebElement> listContentCheck = driver
				.findElements(By.xpath("//div[contains(@class,'info-detail')]//span"));
		for (WebElement webElement : listContentCheck) {
			String content = webElement.getText();
			if (content.toUpperCase().contains((quantity + " bộ").toUpperCase())) {
				assertTrue(content.toUpperCase().contains((quantity + " bộ").toUpperCase()));
				break;
			}
		}
	}

	@Test
	public void searchByPriceAndOriginAndQuantity_checklist() {
		mayruachen.searchByPrice(price);
		mayruachen.searchByOrigin(origin);
		mayruachen.searchByQuantity(quantity);

		List<WebElement> resultSearchPrice = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')]"));
		int count = 1;
		for (WebElement webElement : resultSearchPrice) {
			String text = getText(By.xpath(
					"(//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')])[" + count + "]"))
					.replace("đ", "").replace(".", "").replace(" ", "").replace("₫", "");
			int realPrice = Integer.parseInt(text);
			assertTrue(realPrice > 15000000);
			count++;
		}

		clickByJS(By.xpath("//a[contains(@href, 'bosch-sps6ymi14e')]"));
		pause(3000);
		WebElement resultcheck = driver
				.findElement(By.xpath("(//span[contains(text(), 'Xuất xứ')]/following-sibling::span)[1]"));
		String text = resultcheck.getText();
		assertEquals(origin.toUpperCase(), text.toUpperCase());
		pause(3000);
		By xemThemBtn = By.xpath("(//span[text()='Xem thêm nội dung'])[1]");
		clickByJS(xemThemBtn);

		List<WebElement> listContentCheck = driver
				.findElements(By.xpath("//div[contains(@class,'info-detail')]//span"));
		for (WebElement webElement : listContentCheck) {
			String content = webElement.getText();
			if (content.toUpperCase().contains((quantity + " bộ").toUpperCase())) {
				assertTrue(content.toUpperCase().contains((quantity + " bộ").toUpperCase()));
				break;
			}
		}
	}

	@Test
	public void searchByBranchAndPriceAndOriginAndQuantity_checklist() {
		mayruachen.searchByBranch(keyword);
		mayruachen.searchByPrice(price);
		mayruachen.searchByOrigin(origin);
		mayruachen.searchByQuantity(quantity);
		pause(3000);
		@SuppressWarnings("unchecked")
		// div[contains(@class, 'product-list')]//a[contains(@href, 'bosch')]
		List<WebElement> resultsSearchBranch = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//a[contains(@href, '" + keyword + "')]"));
		assertTrue(resultsSearchBranch.size() > 0);

		List<WebElement> resultSearchPrice = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')]"));
		int count = 1;
		for (WebElement webElement : resultSearchPrice) {
			String text = getText(By.xpath(
					"(//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')])[" + count + "]"))
					.replace("đ", "").replace(".", "").replace(" ", "").replace("₫", "");
			int realPrice = Integer.parseInt(text);
			assertTrue(realPrice > 15000000);
			count++;
		}

		clickByJS(By.xpath("//a[contains(@href, 'bosch-sps6ymi14e')]"));
		pause(3000);
		WebElement resultcheck = driver
				.findElement(By.xpath("(//span[contains(text(), 'Xuất xứ')]/following-sibling::span)[1]"));
		String text = resultcheck.getText();
		assertEquals(origin.toUpperCase(), text.toUpperCase());
		pause(3000);
		By xemThemBtn = By.xpath("(//span[text()='Xem thêm nội dung'])[1]");
		clickByJS(xemThemBtn);

		List<WebElement> listContentCheck = driver
				.findElements(By.xpath("//div[contains(@class,'info-detail')]//span"));
		for (WebElement webElement : listContentCheck) {
			String content = webElement.getText();
			if (content.toUpperCase().contains((quantity + " bộ").toUpperCase())) {
				assertTrue(content.toUpperCase().contains((quantity + " bộ").toUpperCase()));
				break;
			}
		}
	}

	@Test
	public void filterByDiscount_checkList() {
		mayruachen.filterByBigDiscount();
		pause(3000);
		List<WebElement> listProductDiscount = driver
				.findElements(By.xpath("//a[contains(@href, 'may-rua-bat')]//div[contains(@class,'text-white')]"));
		int[] listDiscount = new int[listProductDiscount.size()];
		int count = 0;
		for (WebElement webElement : listProductDiscount) {
			String text = webElement.getText().replace("%", "").replace("-", "");
			listDiscount[count] = Integer.parseInt(text);
			count++;
		}

		assertTrue(CheckList.isDescending(listDiscount));
	}

	@Test
	public void filterByMinPrice_checkList() {
		mayruachen.filterByMinPrice();
		pause(3000);
		List<WebElement> resultMinPrice = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')]"));
		int[] listPrice = new int[resultMinPrice.size()];
		int count = 0;
		for (WebElement webElement : resultMinPrice) {
			String text = webElement.getText().replace(".", "").replace("đ", "").replace("₫", "").replace(" ", "");
			listPrice[count] = Integer.parseInt(text);
			count++;
		}

		assertTrue(CheckList.isAscending(listPrice));
	}

	@Test
	public void filterByMaxPrice_checkList() {
		mayruachen.filterByMaxPrice();
		pause(3000);
		List<WebElement> resultMaxPrice = getListElementDOM(
				By.xpath("//div[contains(@class, 'product-list')]//span[contains(@class, 'sale-price')]"));
		int[] listPrice = new int[resultMaxPrice.size()];
		int count = 0;
		for (WebElement webElement : resultMaxPrice) {
			String text = webElement.getText().replace(".", "").replace("đ", "").replace("₫", "").replace(" ", "");
			listPrice[count] = Integer.parseInt(text);
			count++;
		}
		assertTrue(CheckList.isDescending(listPrice));
	}

	@Test
	public void viewDetailsAProduct_checkProduct() {
		mayruachen.viewDetailProduct();
		assertTrue(mayruachen.isDisplayedDetails());
	}

	@AfterMethod
	public void endBrowser() {
		closeDriver();
	}
}
