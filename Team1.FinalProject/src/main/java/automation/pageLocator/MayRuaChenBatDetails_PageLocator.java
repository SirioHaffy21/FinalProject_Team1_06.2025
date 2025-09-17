package automation.pageLocator;

import org.openqa.selenium.*;
import java.time.Duration;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import automation.common.CommonBase;

public class MayRuaChenBatDetails_PageLocator extends CommonBase{
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By survey = By.xpath("(//span[contains(text(), 'khảo sát')])[1]");
	private By installment = By.xpath("(//span[contains(text(), 'Mua trả góp')])[1]");
	private By buyNow = By.xpath("(//span[contains(text(), 'Mua ngay')])[1]");
	private By surveyModal = By.xpath("//h3[contains(text(), 'Đăng kí tư vấn')]/ancestor::div[contains(@class, 'modal-content')]");
	private By installmentModal = By.xpath("//h3[contains(text(), 'mua trả góp')]/ancestor::div[contains(@class, 'modal-content')]");
	private By nameText_surveyModal = By.xpath("(//input[@placeholder='Nhập họ và tên'])[1]");
	private By phoneText_surveyModal = By.xpath("(//input[@placeholder='Nhập số điện thoại'])[1]");
	private By addressText_surveyModal = By.xpath("(//input[@placeholder='Nhập địa chỉ'])[1]");
	private By nameText_installmentModal = By.xpath("(//input[@placeholder='Nhập họ và tên'])[2]");
	private By phoneText_installmentModal = By.xpath("(//input[@placeholder='Nhập số điện thoại'])[2]");
	private By addressText_installmentModal = By.xpath("(//input[@placeholder='Nhập địa chỉ'])[2]");
	private By breadcrumb = By.xpath("//span[contains(text(), 'SMS63L08EA') and contains(@class, 'breadcrumb')]");
	
	public MayRuaChenBatDetails_PageLocator(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	public void surveySetUp() {
		clickByJS(survey);
	}
	
	public void receiveConsult(String name, String phone, String address) {
		clickByJS(survey);
		WebElement modal = getElementPresentDOM(surveyModal);
		WebElement nameText = modal.findElement(nameText_surveyModal);
		WebElement phoneText = modal.findElement(phoneText_surveyModal);
		WebElement addressText = modal.findElement(addressText_surveyModal);
		nameText.sendKeys(name);
		phoneText.sendKeys(phone);
		addressText.sendKeys(address);
	}
	
	public void buyinstallmentment(String name, String phone, String address) {
		clickByJS(installment);
		WebElement modal = getElementPresentDOM(installmentModal);
		WebElement nameText = modal.findElement(nameText_installmentModal);
		WebElement phoneText = modal.findElement(phoneText_installmentModal);
		WebElement addressText = modal.findElement(addressText_installmentModal);
		nameText.sendKeys(name);
		phoneText.sendKeys(phone);
		addressText.sendKeys(address);
	}
	
	public void buyNow() {
		clickByJS(buyNow);
	}
	
	public boolean isDisplayedDetails() {
		return isElementDisplayed(breadcrumb);
	}
}
