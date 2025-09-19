package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BepTu_Page {
    private WebDriver driver;
    @FindBy(xpath = "//span[contains(text(), '< 3.000.000')]") WebElement selectprice;
    @FindBy(xpath = "(//a[contains(@class, 'cursor-pointer relative bg-white product-card')])[1]") WebElement productItem;
    @FindBy(xpath = "(//a[contains(@class, 'btn-linear-red') and span[text()='Mua ngay']])[1]") WebElement btnMuaNgay;
    @FindBy(xpath = "//button[contains(@class, 'btn-linear-red') and span[text()='Thanh toán']]") WebElement btnOrder;
    @FindBy(xpath = "//input[@placeholder= 'Nhập họ và tên']") WebElement txtName;
    @FindBy(xpath = "//input[@placeholder= 'Nhập số nhà, tên đường, phường/ xã, quận/huyện, tỉnh/ thành phố']") WebElement txtAddress;
    @FindBy(xpath = "(//div[contains(@class, 'btn-linear-green') and span[text()='Mua trả góp']])[1]") WebElement btnMuaTraGop;
    @FindBy(xpath = "(//div[contains(@class, 'btn-linear-orange') and span[text()='Nhận tư vấn']])[2]") WebElement btnNhanTuVan;

    public BepTu_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void order(String name, String address){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(selectprice)).click();

        try {
            wait.until(ExpectedConditions.elementToBeClickable(productItem)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productItem);
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnMuaNgay)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnMuaNgay);
        }

        wait.until(ExpectedConditions.visibilityOf(txtName)).sendKeys(name);
        txtAddress.sendKeys(address);

        wait.until(ExpectedConditions.elementToBeClickable(btnOrder)).click();
    }

    public void traGop(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(productItem)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productItem);
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnMuaTraGop)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnMuaTraGop);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Đăng kí mua trả góp']")));;
        wait.until(ExpectedConditions.elementToBeClickable(btnNhanTuVan)).click();
    }
}
