package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.BuyProduct_BepGasPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import java.time.Duration;

public class BuyProduct_BepGas_Test extends CommonBase {
    @BeforeMethod
    public void openBrowser()
    {
        driver = initChromeDriver(CT_PageURL.BEPANTOAN_URL);
    }

 // Cases kiểm tra tính năng Khảo sát tư vấn- lắp đặt tại nhà
    @Test
    public void dktuvankhaosatsuccess()
    {
        String linkProd = "/bep-gas-am-canzy-cz-862";
        BuyProduct_BepGasPage chooseProd = new BuyProduct_BepGasPage(driver);
        chooseProd.clickBepGas();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '" + linkProd + "')]")));
        productlink.click();
        chooseProd.dangkykhaosat("Nguyễn Lan Hương", "03256475178", "Hà Nội");
        WebElement successMessg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Đăng ký thành công'])[2]")));
        Assert.assertTrue(successMessg.isDisplayed());
    }

    @Test
    public void dktuvankhaosatfailwithnoname()
    {
        String linkProd = "/bep-gas-am-canzy-cz-862";
        BuyProduct_BepGasPage chooseProd = new BuyProduct_BepGasPage(driver);
        chooseProd.clickBepGas();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '" + linkProd + "')]")));
        productlink.click();
        chooseProd.dangkykhaosat("", "03256475178", "Hà Nội");
        WebElement successMessg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[normalize-space()='Họ và tên không hợp lệ']")));
        Assert.assertTrue(successMessg.isDisplayed());
    }

    @Test
    public void dktuvankhaosatfailwithnophonenumber()
    {
        String linkProd = "/bep-gas-am-canzy-cz-862";
        BuyProduct_BepGasPage chooseProd = new BuyProduct_BepGasPage(driver);
        chooseProd.clickBepGas();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '" + linkProd + "')]")));
        productlink.click();
        chooseProd.dangkykhaosat("Nguyễn Lan Hương", "", "Hà Nội");
        WebElement successMessg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[normalize-space()='Số điện thoại không hợp lệ']")));
        Assert.assertTrue(successMessg.isDisplayed());
    }

    @Test
    public void dktuvankhaosatsuccessfailwithnoaddress()
    {
        String linkProd = "/bep-gas-am-canzy-cz-862";
        BuyProduct_BepGasPage chooseProd = new BuyProduct_BepGasPage(driver);
        chooseProd.clickBepGas();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '" + linkProd + "')]")));
        productlink.click();
        chooseProd.dangkykhaosat("Nguyễn Lan Hương", "03256475178", "");
        WebElement errorMessg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[normalize-space()='Địa chỉ không hợp lệ']")));
        Assert.assertTrue(errorMessg.isDisplayed());
    }

 // Cases kiểm tra tính năng Mua ngay
    @Test
    public void buyProductsuccess()
    {
        String linkProd = "/bep-gas-am-eurosun-eu-ga283";
        BuyProduct_BepGasPage chooseProd = new BuyProduct_BepGasPage(driver);
        chooseProd.clickBepGas();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '" + linkProd + "')]")));
        productlink.click();
        chooseProd.Muahang("Nguyễn Lan Hương", "0325647517", "Hà Nội");
        WebElement successMessg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Đặt Hàng Thành Công']")));
        Assert.assertTrue(successMessg.isDisplayed());
    }
    @Test
    public void buyProductfailwithnoname()
    {
        String linkProd = "/bep-gas-am-eurosun-eu-ga283";
        BuyProduct_BepGasPage chooseProd = new BuyProduct_BepGasPage(driver);
        chooseProd.clickBepGas();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '" + linkProd + "')]")));
        productlink.click();
        chooseProd.Muahang("", "0325647517", "Hà Nội");
        WebElement errorsMessg = driver.findElement(By.xpath("//small[normalize-space()='Họ và tên không hợp lệ']"));
        Assert.assertTrue(errorsMessg.isDisplayed());
    }

    @Test
    public void buyProductfailwithnophonenumber()
    {
        String linkProd = "/bep-gas-am-eurosun-eu-ga283";
        BuyProduct_BepGasPage chooseProd = new BuyProduct_BepGasPage(driver);
        chooseProd.clickBepGas();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '" + linkProd + "')]")));
        productlink.click();
        chooseProd.Muahang("Hoàng Lan Anh", "", "Hà Nội");
        WebElement errorsMessg = driver.findElement(By.xpath("//small[normalize-space()='Số điện thoại không hợp lệ']"));
        Assert.assertTrue(errorsMessg.isDisplayed());
    }

    @Test
    public void buyProductfailwithnoaddress()
    {
        String linkProd = "/bep-gas-am-eurosun-eu-ga283";
        BuyProduct_BepGasPage chooseProd = new BuyProduct_BepGasPage(driver);
        chooseProd.clickBepGas();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '" + linkProd + "')]")));
        productlink.click();
        chooseProd.Muahang("Hoàng Lan Anh", "0325647517", "");
        WebElement errorsMessg = driver.findElement(By.xpath("//small[normalize-space()='Địa chỉ không hợp lệ']"));
        Assert.assertTrue(errorsMessg.isDisplayed());
    }

// Cases kiểm tra tính năng Đăng ký mua hàng trả góp
    @Test
    public void muatragopsuccess()
    {
        String linkProd = "/bep-gas-cong-nghiep-gia-re";
        BuyProduct_BepGasPage chooseProd = new BuyProduct_BepGasPage(driver);
        chooseProd.clickBepGas();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '" + linkProd + "')]")));
        productlink.click();
        chooseProd.muahangtragop("Nguyễn Lan Hương", "03256475178", "Hà Nội");
        WebElement successMessg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Đăng ký thành công'])[2]")));
        Assert.assertTrue(successMessg.isDisplayed());
    }

    @Test
    public void muatragopfailwithnoname()
    {
        String linkProd = "/bep-gas-cong-nghiep-gia-re";
        BuyProduct_BepGasPage chooseProd = new BuyProduct_BepGasPage(driver);
        chooseProd.clickBepGas();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '" + linkProd + "')]")));
        productlink.click();
        chooseProd.muahangtragop("", "03256475178", "Hà Nội");
        WebElement successMessg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//small[normalize-space()='Họ và tên không hợp lệ'])[2]")));
        Assert.assertTrue(successMessg.isDisplayed());
    }

    @Test
    public void muatragopfailwithnophonenumber()
    {
        String linkProd = "/bep-gas-cong-nghiep-gia-re";
        BuyProduct_BepGasPage chooseProd = new BuyProduct_BepGasPage(driver);
        chooseProd.clickBepGas();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '" + linkProd + "')]")));
        productlink.click();
        chooseProd.muahangtragop("Nguyễn Thúy Hà", "", "Hà Nội");
        WebElement successMessg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//small[normalize-space()='Số điện thoại không hợp lệ'])[2]")));
        Assert.assertTrue(successMessg.isDisplayed());
    }

    @Test
    public void muatragopfailwithnoaddress()
    {
        String linkProd = "/bep-gas-cong-nghiep-gia-re";
        BuyProduct_BepGasPage chooseProd = new BuyProduct_BepGasPage(driver);
        chooseProd.clickBepGas();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '" + linkProd + "')]")));
        productlink.click();
        chooseProd.muahangtragop("Nguyễn Thúy Hà", "03256475178", "");
        WebElement successMessg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//small[normalize-space()='Địa chỉ không hợp lệ'])[2]")));
        Assert.assertTrue(successMessg.isDisplayed());
    }

    // Case kiểm tra tính năng Nhận khuyến mãi
    @Test
    public void dknhankhuyenmaisuccess()
    {
        String linkProd = "/bep-gas-cong-nghiep-gia-re";
        BuyProduct_BepGasPage chooseProd = new BuyProduct_BepGasPage(driver);
        chooseProd.clickBepGas();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '" + linkProd + "')]")));
        productlink.click();
        chooseProd.muahangtragop("03256897456");
        WebElement successMessg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Đăng ký thành công'])[1]")));
        Assert.assertTrue(successMessg.isDisplayed());
    }
    @Test
    public void dknhankhuyenmaifailwithnophonenumber()
    {
        String linkProd = "/bep-gas-cong-nghiep-gia-re";
        BuyProduct_BepGasPage chooseProd = new BuyProduct_BepGasPage(driver);
        chooseProd.clickBepGas();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '" + linkProd + "')]")));
        productlink.click();
        chooseProd.muahangtragop("");
        WebElement errorMessg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//small[text()=' Số điện thoại không hợp lệ '])[1]")));
        Assert.assertTrue(errorMessg.isDisplayed());
    }
}
