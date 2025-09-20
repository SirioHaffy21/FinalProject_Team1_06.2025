package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.testng.annotations.*;

public class MayRuaChenBatDetails_Test extends CommonBase{
	private MayRuaChenBat_PageLocator mayruachen;
	private MayRuaChenBatDetails_PageLocator mayruachen_detail;
	private By surveyModal = By.xpath("//h3[contains(text(), 'Đăng kí tư vấn')]/ancestor::div[contains(@class, 'modal-content')]");
	private By installmentModal = By.xpath("//h3[contains(text(), 'mua trả góp')]/ancestor::div[contains(@class, 'modal-content')]");
	private String name = "Super Man";
	private String phone = "0355555555";
	private String address = "USA";
	
	@BeforeMethod
	@Parameters("browser")
	public void initProcess(String browser) {
		setupDriver(browser);
		driver.get(CT_PageURL.SyHa_MayRuaChen_URL);
		mayruachen = new MayRuaChenBat_PageLocator(driver);
		mayruachen.viewDetailProduct();
		assertTrue(mayruachen.isDisplayedDetails());
		pause(3000);
		mayruachen_detail = new MayRuaChenBatDetails_PageLocator(driver);
	}
	
	@Test
	public void checkSurveyInDetails_openPopup() {
		mayruachen_detail.surveySetUp();
		WebElement modal = getElementPresentDOM(surveyModal);
		WebElement modalSurvey = modal.findElement(By.xpath("//h3[contains(text(), 'tư vấn lắp đặt')]"));
		assertTrue(modalSurvey.isDisplayed());
	}
	
	@Test
	public void checkBuyInstallments_openPopup() {
		mayruachen_detail.installments();
		WebElement modal = getElementPresentDOM(installmentModal);
		WebElement modalInstallment = modal.findElement(By.xpath("//h3[contains(text(), 'mua trả góp')]"));
		assertTrue(modalInstallment.isDisplayed());
	}
	
	@Test
	public void receiveConsult_Failed_With_Empty_Name() {
		mayruachen_detail.receiveConsult("", phone, address);
		WebElement modal = getElementPresentDOM(surveyModal);
		WebElement modalSurvey = modal.findElement(By.xpath("//h3[contains(text(), 'tư vấn lắp đặt')]"));
		assertTrue(modalSurvey.isDisplayed());
		WebElement failedSurvey = modal.findElement(By.xpath("(//small[contains(text(), 'không hợp lệ')])[1]"));
		assertTrue(failedSurvey.isDisplayed());
	}
	
	@Test
	public void receiveConsult_Failed_With_Empty_Phone() {
		mayruachen_detail.receiveConsult(name, "", address);
		WebElement modal = getElementPresentDOM(surveyModal);
		WebElement modalSurvey = modal.findElement(By.xpath("//h3[contains(text(), 'tư vấn lắp đặt')]"));
		assertTrue(modalSurvey.isDisplayed());
		WebElement failedSurvey = modal.findElement(By.xpath("(//small[contains(text(), 'không hợp lệ')])[1]"));
		assertTrue(failedSurvey.isDisplayed());
	}
	
	@Test
	public void receiveConsult_Failed_With_Empty_Address() {
		mayruachen_detail.receiveConsult(name, phone, "");
		WebElement modal = getElementPresentDOM(surveyModal);
		WebElement modalSurvey = modal.findElement(By.xpath("//h3[contains(text(), 'tư vấn lắp đặt')]"));
		assertTrue(modalSurvey.isDisplayed());
		WebElement failedSurvey = modal.findElement(By.xpath("(//small[contains(text(), 'không hợp lệ')])[1]"));
		assertTrue(failedSurvey.isDisplayed());
	}
	
	@Test
	public void buyInstallment_Failed_With_Empty_Name() {
		mayruachen_detail.buyInstallment("", phone, address);
		WebElement modal = getElementPresentDOM(installmentModal);
		WebElement modalInstallment = modal.findElement(By.xpath("//h3[contains(text(), 'mua trả góp')]"));
		assertTrue(modalInstallment.isDisplayed());
		WebElement failedBuyInstallment = modal.findElement(By.xpath("(//small[contains(text(), 'không hợp lệ')])[2]"));
		assertTrue(failedBuyInstallment.isDisplayed());
	}
	
	@Test
	public void buyInstallment_Failed_With_Empty_Phone() {
		mayruachen_detail.buyInstallment(name, "", address);
		WebElement modal = getElementPresentDOM(installmentModal);
		WebElement modalInstallment = modal.findElement(By.xpath("//h3[contains(text(), 'mua trả góp')]"));
		assertTrue(modalInstallment.isDisplayed());
		WebElement failedBuyInstallment = modal.findElement(By.xpath("(//small[contains(text(), 'không hợp lệ')])[2]"));
		assertTrue(failedBuyInstallment.isDisplayed());
	}
	
	@Test
	public void buyInstallment_Failed_With_Empty_Address() {
		mayruachen_detail.buyInstallment(name, phone, "");
		WebElement modal = getElementPresentDOM(installmentModal);
		WebElement modalInstallment = modal.findElement(By.xpath("//h3[contains(text(), 'mua trả góp')]"));
		assertTrue(modalInstallment.isDisplayed());
		WebElement failedBuyInstallment = modal.findElement(By.xpath("(//small[contains(text(), 'không hợp lệ')])[2]"));
		assertTrue(failedBuyInstallment.isDisplayed());
	}
	
	@AfterMethod
	public void endProcess() {
		closeDriver();
	}
}
