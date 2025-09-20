package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyProduct_BepGasPage {
    private WebDriver driver;

    private By tabBepgas = By.xpath("//a[text()=' Bếp Gas ']");

    // Locator các element cho tính năng Khảo sát - tư vấn lắp đặt tại nhà
    private By namekstxt = By.xpath("(//input[@placeholder='Nhập họ và tên'])[1]");
    private By phonenumberkstxt = By.xpath("(//input[@placeholder='Nhập số điện thoại'])[1]");
    private By addresskstxt = By.xpath("//input[@placeholder='Nhập địa chỉ']");
    private By nhantuvanbtn = By.xpath("//span[text()='Nhận tư vấn']");

    // Locator các element cho tính năng Mua ngay
    private By nametxt = By.xpath("//input[@placeholder= 'Nhập họ và tên']");
    private By phonenumbertxt = By.xpath("//input[@placeholder= 'Nhập số điện thoại']");
    private By addresstxt = By.xpath("//input[@placeholder= 'Nhập số nhà, tên đường, phường/ xã, quận/huyện, tỉnh/ thành phố']");
    private By thanhtoanbtn= By.xpath("//span[text()='Thanh toán']");

    // Locator các element cho tính năng Mua trả góp
    private By nametgtxt = By.xpath("(//input[@placeholder='Nhập họ và tên'])[2]");
    private By phonenumbertgtxt = By.xpath("(//input[@placeholder='Nhập số điện thoại'])[2]");
    private By addresstgtxt = By.xpath("(//input[@placeholder='Nhập địa chỉ'])[2]");
    private By nhantuvantgbtn = By.xpath("(//span[text()='Nhận tư vấn'])[2]");

    // Locator các element cho tính năng Đăng ký nhận khuyến mãi
    private By sdtnhankhuyenmai = By.xpath("(//input[@placeholder='Nhập số điện thoại nhận thông tin khuyến mãi'])[1]");
    private By dangkyngaybtn = By.xpath("(//div[normalize-space()='Đăng ký ngay'])[2]");



    public BuyProduct_BepGasPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBepGas()
    {
        driver.findElement(tabBepgas).click();
    }

    public void Muahang(String name, String phonenumber, String address)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement muangaybtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Mua ngay'])[1]")));
        muangaybtn.click();
        WebElement dathangtitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Đặt hàng']")));
        dathangtitle.isDisplayed();
        driver.findElement(nametxt).sendKeys(name);
        driver.findElement(phonenumbertxt).sendKeys(phonenumber);
        driver.findElement(addresstxt).sendKeys(address);
        driver.findElement(thanhtoanbtn).click();
    }

    public void dangkykhaosat(String nameks, String phonenumberks, String addressks)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement khaosatbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' khảo sát - tư vấn lắp đặt tại nhà']")));
        khaosatbtn.click();
        WebElement dangkykhaosattitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Đăng kí tư vấn lắp đặt tại nhà']")));
        dangkykhaosattitle.isDisplayed();
        driver.findElement(namekstxt).sendKeys(nameks);
        driver.findElement(phonenumberkstxt).sendKeys(phonenumberks);
        driver.findElement(addresskstxt).sendKeys(addressks);
        driver.findElement(nhantuvanbtn).click();
    }

    public void muahangtragop(String nametg, String phonenumbertg, String addresstg)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement muatragopbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Mua trả góp']")));
        muatragopbtn.click();
        WebElement dangkytragoptitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Đăng kí mua trả góp']")));
        dangkytragoptitle.isDisplayed();
        driver.findElement(nametgtxt).sendKeys(nametg);
        driver.findElement(phonenumbertgtxt).sendKeys(phonenumbertg);
        driver.findElement(addresstgtxt).sendKeys(addresstg);
        driver.findElement(nhantuvantgbtn).click();
    }

    public void muahangtragop(String sdt)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chuongtrinhtitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='ưu đãi chỉ có tại bepantoan.vn']")));
        chuongtrinhtitle.isDisplayed();
        driver.findElement(sdtnhankhuyenmai).sendKeys(sdt);
        driver.findElement(dangkyngaybtn).click();
    }

    }







