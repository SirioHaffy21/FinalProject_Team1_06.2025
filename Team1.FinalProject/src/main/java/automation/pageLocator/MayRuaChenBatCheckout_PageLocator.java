package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import automation.common.CommonBase;

public class MayRuaChenBatCheckout_PageLocator extends CommonBase {
	private WebDriver driver;
	private WebDriverWait wait;
	private By contentPage = By.xpath("//h1[contains(text(), 'Đặt hàng')]");
	private By nameText = By.xpath("//input[@placeholder='Nhập họ và tên']");
	private By phoneText = By.xpath("//input[@placeholder='Nhập số điện thoại']");
	private By addressText = By.xpath("//input[@placeholder='Nhập số nhà, tên đường, phường/ xã, quận/huyện, tỉnh/ thành phố']");
	private By checkoutBtn = By.xpath("//span[text()='Thanh toán']//ancestor::button");
	
	public MayRuaChenBatCheckout_PageLocator(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	public boolean isDisplayedCheckout() {
		return isElementDisplayed(contentPage);
	}
	
	public void checkout(String name, String phone, String address) {
		type(nameText, name);
		type(phoneText, phone);
		type(addressText, address);
		clickByJS(checkoutBtn);
	}
}
