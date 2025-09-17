package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import automation.common.CommonBase;

public class MayRuaChenBat_PageLocator extends CommonBase {
	private WebDriver driver;
	private WebDriverWait wait;

	private By xemthemOrigin = By.xpath("(//span[text()='Xem thêm'])[2]");
	private By xemthemQuantity = By.xpath("(//span[text()='Xem thêm'])[3]");
	private By bigDiscountFilter = By.xpath("//a[text()='Giảm giá nhiều']");
	private By minPriceFilter = By.xpath("//a[text()='Giá thấp']");
	private By maxPriceFilter = By.xpath("//a[text()='Giá cao']");
	private By productSelect = By.xpath("//a[contains(@href, 'sms63l08ea')]");
	private By breadcrumb = By.xpath("//span[contains(text(), 'SMS63L08EA') and contains(@class, 'breadcrumb')]");
	private By productList = By.xpath("//div[contains(@class, 'product-list')]//a[contains(@href, 'bosch')]");
	
	public MayRuaChenBat_PageLocator(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

	public void searchByBranch(String keyword) {
		By branchOption = By.xpath("(//a[contains(@href, '" + keyword + "')])[1]");
		clickByJS(branchOption);
	}

	public void searchByPrice(String keyword) {
		By priceOption = By.xpath("//span[contains(text(), '" + keyword + "')]");
		clickByJS(priceOption);
	}

	public void searchByOrigin(String keyword) {
		clickByJS(xemthemOrigin);
		By originOption = By.xpath("//span[text()='" + keyword + "']");
		clickByJS(originOption);
	}

	public void searchByQuantity(String number) {
		clickByJS(xemthemQuantity);
		By quantityOption = By.xpath("//span[text()='" + number + " bộ']");
		clickByJS(quantityOption);
	}

	public void filterByBigDiscount() {
		clickByJS(bigDiscountFilter);
	}

	public void filterByMinPrice() {
		clickByJS(minPriceFilter);
	}

	public void filterByMaxPrice() {
		clickByJS(maxPriceFilter);
	}

	public void viewDetailProduct() {
		clickByJS(productSelect);
	}
	
	public boolean isDisplayedDetails() {
		return !isElementDisplayed(breadcrumb);
	}
}
