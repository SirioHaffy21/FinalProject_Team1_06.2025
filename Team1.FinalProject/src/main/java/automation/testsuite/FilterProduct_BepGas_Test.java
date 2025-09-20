package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.FilterProduct_BepGasPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;


public class FilterProduct_BepGas_Test extends CommonBase {
    @BeforeMethod
    public void openBrowser() {
        driver = initChromeDriver(CT_PageURL.BEPANTOAN_URL);
    }
// Test filter Bếp gas theo Danh mục
    @Test
    public void filterBepgasam() throws InterruptedException {
        FilterProduct_BepGasPage filterBepgas = new FilterProduct_BepGasPage(driver);
        filterBepgas.openBepgastab();
        Thread.sleep(3000);
        filterBepgas.chooseBepgasam();
        Thread.sleep(3000);
        WebElement bepgasamTitle = driver.findElement(By.xpath(
                "//h1[normalize-space()='Bếp Gas Âm Nhập Khẩu Model 2023 chính hãng, giá rẻ']"));
        Assert.assertTrue(bepgasamTitle.isDisplayed());
    }

    @Test
    public void filterBepgasduong() throws InterruptedException {
        FilterProduct_BepGasPage filterBepgas = new FilterProduct_BepGasPage(driver);
        filterBepgas.openBepgastab();
        Thread.sleep(3000);
        filterBepgas.chooseBepgasduong();
        Thread.sleep(3000);
        WebElement bepgastitle = driver.findElement(By.xpath("//h1[normalize-space()='Bếp Gas Dương']"));
        Assert.assertTrue(bepgastitle.isDisplayed());
    }

    @Test
    public void filterBepgasgiare() throws InterruptedException {
        FilterProduct_BepGasPage filterBepgas = new FilterProduct_BepGasPage(driver);
        filterBepgas.openBepgastab();
        Thread.sleep(3000);
        filterBepgas.chooseBepgasgiare();
        Thread.sleep(3000);
        WebElement bepgastitle = driver.findElement(By.xpath("//h1[normalize-space()='BẾP GAS GIÁ RẺ']"));
        Assert.assertTrue(bepgastitle.isDisplayed());
    }

    @Test
    public void filterBepgascongnghiep() throws InterruptedException {
        FilterProduct_BepGasPage filterBepgas = new FilterProduct_BepGasPage(driver);
        filterBepgas.openBepgastab();
        Thread.sleep(3000);
        filterBepgas.chooseBepgascongnghiep();
        Thread.sleep(3000);
        WebElement bepgastitle = driver.findElement(By.xpath("//h1[normalize-space()='Các Loại BẾP GAS CÔNG NGHIỆP - Nhà hàng - Khách sạn']"));
        Assert.assertTrue(bepgastitle.isDisplayed());
    }

    @Test
    public void filterBepgasdientu() throws InterruptedException {
        FilterProduct_BepGasPage filterBepgas = new FilterProduct_BepGasPage(driver);
        filterBepgas.openBepgastab();
        Thread.sleep(3000);
        filterBepgas.chooseBepgasdientu();
        Thread.sleep(3000);
        WebElement bepgastitle = driver.findElement(By.xpath("//h1[normalize-space()='Bếp Gas Kết Hợp Điện Từ']"));
        Assert.assertTrue(bepgastitle.isDisplayed());
    }

    @Test
    public void filterBobinhgas() throws InterruptedException {
        FilterProduct_BepGasPage filterBepgas = new FilterProduct_BepGasPage(driver);
        filterBepgas.openBepgastab();
        Thread.sleep(3000);
        filterBepgas.chooseboBinhgas();
        Thread.sleep(3000);
        WebElement bepgastitle = driver.findElement(By.xpath("//h1[normalize-space()='Bộ bình gas']"));
        Assert.assertTrue(bepgastitle.isDisplayed());
    }

    @Test
    public void filterBepgasdon() throws InterruptedException {
        FilterProduct_BepGasPage filterBepgas = new FilterProduct_BepGasPage(driver);
        filterBepgas.openBepgastab();
        Thread.sleep(3000);
        filterBepgas.chooseBepgasdon();
        Thread.sleep(3000);
        WebElement bepgastitle = driver.findElement(By.xpath("//h1[normalize-space()='BẾP GAS ĐƠN']"));
        Assert.assertTrue(bepgastitle.isDisplayed());
    }

    @Test
    public void filterBepgasdulich() throws InterruptedException {
        FilterProduct_BepGasPage filterBepgas = new FilterProduct_BepGasPage(driver);
        filterBepgas.openBepgastab();
        Thread.sleep(3000);
        filterBepgas.chooseBepgasdulich();
        Thread.sleep(3000);
        WebElement bepgastitle = driver.findElement(By.xpath("//h1[normalize-space()='Bếp gas du lịch']"));
        Assert.assertTrue(bepgastitle.isDisplayed());
    }

    @Test
    public void filterBobinhbepgas() throws InterruptedException {
        FilterProduct_BepGasPage filterBepgas = new FilterProduct_BepGasPage(driver);
        filterBepgas.openBepgastab();
        Thread.sleep(3000);
        filterBepgas.chooseboBinhbepgas();
        Thread.sleep(3000);
        WebElement bepgastitle = driver.findElement(By.xpath("//h1[normalize-space()='bộ bình bếp gas']"));
        Assert.assertTrue(bepgastitle.isDisplayed());
    }

    @Test
    public void filterPhukiengas() throws InterruptedException {
        FilterProduct_BepGasPage filterBepgas = new FilterProduct_BepGasPage(driver);
        filterBepgas.openBepgastab();
        Thread.sleep(3000);
        filterBepgas.choosePhukiengas();
        Thread.sleep(3000);
        WebElement bepgastitle = driver.findElement(By.xpath("//h1[normalize-space()='Phụ kiện gas']"));
        Assert.assertTrue(bepgastitle.isDisplayed());
    }

    @Test
    public void filterBepgashongngoai() throws InterruptedException {
        FilterProduct_BepGasPage filterBepgas = new FilterProduct_BepGasPage(driver);
        filterBepgas.openBepgastab();
        Thread.sleep(3000);
        filterBepgas.chooseBepgasHongngoai();
        Thread.sleep(3000);
        WebElement bepgastitle = driver.findElement(By.xpath("//h1[normalize-space()='Bếp gas hồng ngoại nhập khẩu chính hãng, giá rẻ nhất Hà Nội']"));
        Assert.assertTrue(bepgastitle.isDisplayed());
    }
// Filter Bếp gas theo Brand
    @Test
    public void filterBrandBosch()
    {
        FilterProduct_BepGasPage filterBrand = new FilterProduct_BepGasPage(driver);
        filterBrand.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hangsanxuatTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='HÃNG SẢN XUẤT']")));
        hangsanxuatTitle.isDisplayed();
        clickByJS(By.xpath("(//img[contains(@src,'bosch')])[1]"));
        WebElement filterresult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flex flex-wrap product-list']//a")));
        filterresult.isDisplayed();
        List<WebElement> listproduct = driver.findElements(By.xpath("//div[@class='flex flex-wrap product-list']//a"));
        Assert.assertTrue(listproduct.size()>0);
        System.out.println("Tổng số sản phẩm hãng Bosch là:" + listproduct.size());
    }

    @Test
    public void filterBrandEurosun()
    {
        FilterProduct_BepGasPage filterBrand = new FilterProduct_BepGasPage(driver);
        filterBrand.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement hangsanxuatTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='HÃNG SẢN XUẤT']")));
        hangsanxuatTitle.isDisplayed();
        clickByJS(By.xpath("(//img[contains(@src,'eurosun')])[1]"));
        scrollToElement(By.xpath("//h3[text()='Kích Thước']"));
        List<WebElement> initialList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='flex flex-wrap product-list']//a")));
        int initialCount = initialList.size();
        WebElement xemthemEurosunbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Xem thêm'])[5]")));
        xemthemEurosunbtn.click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='flex flex-wrap product-list']//a"), initialCount));
        List<WebElement> listproduct = driver.findElements(By.xpath("//div[@class='flex flex-wrap product-list']//a"));
        Assert.assertTrue(listproduct.size()>0);
        System.out.println("Tổng số sản phẩm hãng Eurosun là:" + listproduct.size());
    }

    @Test
    public void filterBrandCanzy()
    {
        FilterProduct_BepGasPage filterBrand = new FilterProduct_BepGasPage(driver);
        filterBrand.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hangsanxuatTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='HÃNG SẢN XUẤT']")));
        hangsanxuatTitle.isDisplayed();
        clickByJS(By.xpath("(//img[contains(@src,'canzy')])[1]"));
        WebElement filterresult = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='flex flex-wrap product-list']//a")));
        filterresult.isDisplayed();
        List<WebElement> listproduct = driver.findElements(By.xpath("//div[@class='flex flex-wrap product-list']//a"));
        Assert.assertTrue(listproduct.size()>0);
        System.out.println("Tổng số sản phẩm hãng Canzy là:" + listproduct.size());
    }

    @Test
    public void filterBrandDynamics()
    {
        FilterProduct_BepGasPage filterBrand = new FilterProduct_BepGasPage(driver);
        filterBrand.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hangsanxuatTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='HÃNG SẢN XUẤT']")));
        hangsanxuatTitle.isDisplayed();
        clickByJS(By.xpath("(//img[contains(@src,'Dynamic')])[1]"));
        WebElement filterresult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flex flex-wrap product-list']//a")));
        filterresult.isDisplayed();
        List<WebElement> listproduct = driver.findElements(By.xpath("//div[@class='flex flex-wrap product-list']//a"));
        Assert.assertTrue(listproduct.size()>0);
        System.out.println("Tổng số sản phẩm hãng Dynamics là:" + listproduct.size());
    }

    @Test
    public void filterBrandPaloma()
    {
        FilterProduct_BepGasPage filterBrand = new FilterProduct_BepGasPage(driver);
        filterBrand.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement hangsanxuatTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='HÃNG SẢN XUẤT']")));
        hangsanxuatTitle.isDisplayed();
        clickByJS(By.xpath("(//img[contains(@src,'Untitled(2)')])[1]"));
        scrollToElement(By.xpath("//h3[text()='Kích Thước']"));
        List<WebElement> initialList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='flex flex-wrap product-list']//a")));
        int initialCount = initialList.size();
        WebElement xemthemPalomabtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Xem thêm'])[5]")));
        xemthemPalomabtn.click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='flex flex-wrap product-list']//a"), initialCount));
        List<WebElement> listproduct = driver.findElements(By.xpath("//div[@class='flex flex-wrap product-list']//a"));
        Assert.assertTrue(listproduct.size()>0);
        System.out.println("Tổng số sản phẩm hãng Paloma là:" + listproduct.size());
    }

    @Test
    public void filterBrandHafele()
    {
        FilterProduct_BepGasPage filterBrand = new FilterProduct_BepGasPage(driver);
        filterBrand.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement xemthembtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Xem thêm'])[1]")));
        xemthembtn.click();
        WebElement hangsanxuatTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='HÃNG SẢN XUẤT']")));
        hangsanxuatTitle.isDisplayed();
        clickByJS(By.xpath("(//img[contains(@src,'Hafele')])[1]"));
        WebElement filterresult = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='flex flex-wrap product-list']//a")));
        filterresult.isDisplayed();
        List<WebElement> listproduct = driver.findElements(By.xpath("//div[@class='flex flex-wrap product-list']//a"));
        Assert.assertTrue(listproduct.size()>0);
        System.out.println("Tổng số sản phẩm hãng Hafele là:" + listproduct.size());
    }
    // Filter Bếp gas theo Mức giá
    @Test
    public void filterPriceUnder3M_AllProducts() throws InterruptedException
    {
        FilterProduct_BepGasPage filterPage = new FilterProduct_BepGasPage(driver);
        filterPage.openBepgastab();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement filterUnder3M = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'< 3.000.000')]")));
        filterUnder3M.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'product-list')]//a")));
        while (true) {
            try {
                WebElement loadMoreBtn = driver.findElement(By.xpath("(//span[text()='Xem thêm'])[5]"));
                if (loadMoreBtn.isDisplayed()) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loadMoreBtn);
                    Thread.sleep(2000);
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }

        List<WebElement> priceElements = driver.findElements(
                By.xpath("//div[contains(@class,'product-list')]//span[contains(@class,'price')]"));
        Assert.assertTrue(priceElements.size() > 0, "Không có sản phẩm nào được filter < 3 triệu!");
        for (WebElement priceEl : priceElements) {
            String rawText = priceEl.getText();
            String numericOnly= rawText.replaceAll("[^0-9]","");
            if (!numericOnly.isEmpty()) {
                int price = Integer.parseInt(numericOnly);
                System.out.println("Sản phẩm có giá: " + price);

                Assert.assertTrue(price <= 3000000,
                        "Có sản phẩm giá lớn hơn 3 triệu: " + rawText);
            }
        }
    }

    @Test
    public void filterPricefrom3Mto5M_AllProducts() throws InterruptedException
    {
        FilterProduct_BepGasPage filterPage = new FilterProduct_BepGasPage(driver);
        filterPage.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement filterFrom3Mto5M = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,' 3.000.000 > 5.000.000')]")));
        filterFrom3Mto5M.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'product-list')]//a")));
        while (true) {
            try {
                WebElement loadMoreBtn = driver.findElement(By.xpath("//button[contains(text(),'Xem thêm')]"));
                if (loadMoreBtn.isDisplayed()) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loadMoreBtn);
                    Thread.sleep(2000);
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }

        List<WebElement> priceElements = driver.findElements(By.xpath("//div[contains(@class,'product-list')]//span[contains(@class,'price')]"));
        Assert.assertTrue(priceElements.size() > 0, "Không có sản phẩm nào được filter nằm trong khoảng 3-5 triệu");
        for (WebElement priceEl : priceElements) {
            String rawText = priceEl.getText();
            String numericOnly = rawText.replaceAll("[^0-9]", "");
            if (!numericOnly.isEmpty()) {
                int price = Integer.parseInt(numericOnly);
                System.out.println("Sản phẩm có giá: " + price);
                Assert.assertTrue(price >= 3000000 && price <= 5000000,
                        "Có sản phẩm không nằm trong khoảng 3-5 triệu: " + rawText);
            }
        }
    }

    @Test
    public void filterPricefrom5Mto10M_AllProducts() throws InterruptedException
    {
        FilterProduct_BepGasPage filterPage = new FilterProduct_BepGasPage(driver);
        filterPage.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement filterFrom3Mto5M = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,' 5.000.000 > 10.000.000')]")));
        filterFrom3Mto5M.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'product-list')]//a")));
        while (true) {
            try {
                WebElement loadMoreBtn = driver.findElement(By.xpath("//button[contains(text(),'Xem thêm')]"));
                if (loadMoreBtn.isDisplayed()) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loadMoreBtn);
                    Thread.sleep(2000);
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }

        List<WebElement> priceElements = driver.findElements(By.xpath("//div[contains(@class,'product-list')]//span[contains(@class,'price')]"));
        Assert.assertTrue(priceElements.size() > 0, "Không có sản phẩm nào được filter nằm trong khoảng 5-10 triệu");
        for (WebElement priceEl : priceElements) {
            String rawText = priceEl.getText();
            String numericOnly = rawText.replaceAll("[^0-9]", "");
            if (!numericOnly.isEmpty()) {
                int price = Integer.parseInt(numericOnly);
                System.out.println("Sản phẩm có giá: " + price);
                Assert.assertTrue(price >= 5000000 && price <= 10000000,
                        "Có sản phẩm không nằm trong khoảng 5-10 triệu: " + rawText);
            }
        }
    }

    @Test
    public void filterPricefrom10Mto15M_AllProducts() throws InterruptedException
    {
        FilterProduct_BepGasPage filterPage = new FilterProduct_BepGasPage(driver);
        filterPage.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement filterFrom10Mto15M = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,' 10.000.000 > 15.000.000')]")));
        filterFrom10Mto15M.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'product-list')]//a")));
        while (true) {
            try {
                WebElement loadMoreBtn = driver.findElement(By.xpath("//button[contains(text(),'Xem thêm')]"));
                if (loadMoreBtn.isDisplayed()) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loadMoreBtn);
                    Thread.sleep(2000);
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }

        List<WebElement> priceElements = driver.findElements(By.xpath("//div[contains(@class,'product-list')]//span[contains(@class,'price')]"));
        Assert.assertTrue(priceElements.size() > 0, "Không có sản phẩm nào được filter nằm trong khoảng 10-15 triệu");
        for (WebElement priceEl : priceElements) {
            String rawText = priceEl.getText();
            String numericOnly = rawText.replaceAll("[^0-9]", "");
            if (!numericOnly.isEmpty()) {
                int price = Integer.parseInt(numericOnly);
                System.out.println("Sản phẩm có giá: " + price);
                Assert.assertTrue(price >= 10000000 && price <= 15000000,
                        "Có sản phẩm không nằm trong khoảng 10-15 triệu: " + rawText);
            }
        }
    }

    @Test
    public void filterPriceOver15M_AllProducts() throws InterruptedException {
        FilterProduct_BepGasPage filterPage = new FilterProduct_BepGasPage(driver);
        filterPage.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement filterOver15M = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'  > 15.000.000')]")));
        filterOver15M.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'product-list')]//a")));
        while (true) {
            try {
                WebElement loadMoreBtn = driver.findElement(By.xpath("//button[contains(text(),'Xem thêm')]"));
                if (loadMoreBtn.isDisplayed()) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loadMoreBtn);
                    Thread.sleep(2000);
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }

        List<WebElement> priceElements = driver.findElements(By.xpath("//div[contains(@class,'product-list')]//span[contains(@class,'price')]"));
        Assert.assertTrue(priceElements.size() > 0, "Không có sản phẩm nào được filter dưới 15 triệu");
        for (WebElement priceEl : priceElements) {
            String rawText = priceEl.getText();
            String numericOnly = rawText.replaceAll("[^0-9]", "");
            if (!numericOnly.isEmpty()) {
                int price = Integer.parseInt(numericOnly);
                System.out.println("Sản phẩm có giá: " + price);
                Assert.assertTrue(price >= 15000000,
                        "Có sản phẩm nhỏ hơn 15 triệu: " + rawText);
            }
        }
    }


// Filter Bếp gas theo Xuất xứ

    @Test
    public void filterEnglandOrigion()
    {
        FilterProduct_BepGasPage filterorigin = new FilterProduct_BepGasPage(driver);
        filterorigin.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement englandcheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("england-1027")));
        if (!englandcheckbox.isSelected())
        {
            clickByJS(By.xpath("//input[@name='england-1027']"));
            System.out.println("Checkbox England has been selected");
        }
        WebElement resultfilter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Bếp gas âm Electrolux EGG9422S']")));
        Assert.assertTrue(resultfilter.isDisplayed());
    }

    @Test
    public void filterTurkeyOrigion()
    {
        FilterProduct_BepGasPage filterorigin = new FilterProduct_BepGasPage(driver);
        filterorigin.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement xemthembtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Xem thêm'])[2]")));
        xemthembtn.click();
        WebElement turkeycheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("turkey-1082")));
        if (!turkeycheckbox.isSelected())
        {
            clickByJS(By.xpath("//input[@name='turkey-1082']"));
            System.out.println("Checkbox Turkey has been selected");
        }
        WebElement resultfilter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Bếp gas âm Paloma PD-T75CSB']")));
        Assert.assertTrue(resultfilter.isDisplayed());
    }

    @Test
    public void filterGermanyOrigion()
    {
        FilterProduct_BepGasPage filterorigin = new FilterProduct_BepGasPage(driver);
        filterorigin.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement xemthembtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Xem thêm'])[2]")));
        xemthembtn.click();
        WebElement germanycheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("germany-1025")));
        if (!germanycheckbox.isSelected())
        {
            clickByJS(By.xpath("//input[@name='germany-1025']"));
            System.out.println("Checkbox Germany has been selected");
        }
        WebElement resultfilter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Bếp gas âm Eurosun EU-GA378']")));
        Assert.assertTrue(resultfilter.isDisplayed());
    }

    @Test
    public void filterMalaysiaOrigion()
    {
        FilterProduct_BepGasPage filterorigin = new FilterProduct_BepGasPage(driver);
        filterorigin.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement xemthembtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Xem thêm'])[2]")));
        xemthembtn.click();
        WebElement malaysiacheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("malaysia-1023")));
        if (!malaysiacheckbox.isSelected())
        {
            clickByJS(By.xpath("//input[@name='malaysia-1023']"));
            System.out.println("Checkbox Malaysia has been selected");
        }
        WebElement resultfilter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Bếp gas dương hồng ngoại Redsun RS928H']")));
        Assert.assertTrue(resultfilter.isDisplayed());
    }

    @Test
    public void filterThailandOrigion()
    {
        FilterProduct_BepGasPage filterorigin = new FilterProduct_BepGasPage(driver);
        filterorigin.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement xemthembtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Xem thêm'])[2]")));
        xemthembtn.click();
        WebElement thailandcheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("thailand-1020")));
        if (!thailandcheckbox.isSelected())
        {
            clickByJS(By.xpath("//input[@name='thailand-1020']"));
            System.out.println("Checkbox Thailand has been selected");
        }
        WebElement resultfilter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Bếp gas công nghiệp Rinnai RV-35 KS']")));
        Assert.assertTrue(resultfilter.isDisplayed());
    }

    @Test
    public void filterJapanOrigion()
    {
        FilterProduct_BepGasPage filterorigin = new FilterProduct_BepGasPage(driver);
        filterorigin.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement xemthembtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Xem thêm'])[2]")));
        xemthembtn.click();
        WebElement japancheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("japan-1018")));
        if (!japancheckbox.isSelected())
        {
            clickByJS(By.xpath("//input[@name='japan-1018']"));
            System.out.println("Checkbox Japan has been selected");
        }
        WebElement resultfilter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Nồi cơm gas Rinnai R-10 10kg']")));
        Assert.assertTrue(resultfilter.isDisplayed());
    }

    @Test
    public void filterSpainOrigion()
    {
        FilterProduct_BepGasPage filterorigin = new FilterProduct_BepGasPage(driver);
        filterorigin.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement xemthembtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Xem thêm'])[2]")));
        xemthembtn.click();
        WebElement spaincheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spain-1016")));
        if (!spaincheckbox.isSelected())
        {
            clickByJS(By.xpath("//input[@name='spain-1016']"));
            System.out.println("Checkbox Spain has been selected");
        }
        WebElement resultfilter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Bếp Gas Âm BOSCH HMH.PCC6A5B90E']")));
        Assert.assertTrue(resultfilter.isDisplayed());
    }

    // Filter Bếp gas theo Số bếp
    @Test
    public void filtermotbep()
    {
        FilterProduct_BepGasPage filtersobep = new FilterProduct_BepGasPage(driver);
        filtersobep.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        scrollToElement(By.xpath("//h3[text()='Số bếp']"));
        WebElement motbepcheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("1-bep-1006")));
        if (!motbepcheckbox.isSelected())
        {
            clickByJS(By.xpath("//input[@name='1-bep-1006']"));
            System.out.println("Checkbox 1 bếp has been selected");
        }
        WebElement resultfilter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Bộ bếp gas đơn giá rẻ']")));
        Assert.assertTrue(resultfilter.isDisplayed());
    }

    @Test
    public void filterhaibep()
    {
        FilterProduct_BepGasPage filtersobep = new FilterProduct_BepGasPage(driver);
        filtersobep.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        scrollToElement(By.xpath("//h3[text()='Số bếp']"));
        WebElement haibepcheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("2-bep-1007")));
        if (!haibepcheckbox.isSelected())
        {
            clickByJS(By.xpath("//input[@name='2-bep-1007']"));
            System.out.println("Checkbox 2 bếp has been selected");
        }
        WebElement resultfilter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Bếp gas âm Canzy CZ-862']")));
        Assert.assertTrue(resultfilter.isDisplayed());
    }

    @Test
    public void filterbabep()
    {
        FilterProduct_BepGasPage filtersobep = new FilterProduct_BepGasPage(driver);
        filtersobep.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        scrollToElement(By.xpath("//h3[text()='Số bếp']"));
        WebElement babepcheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("3-bep-1008")));
        if (!babepcheckbox.isSelected())
        {
            clickByJS(By.xpath("//input[@name='3-bep-1008']"));
            System.out.println("Checkbox 3 bếp has been selected");
        }
        WebElement resultfilter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Bếp công nghiệp Á ba họng']")));
        Assert.assertTrue(resultfilter.isDisplayed());
    }

    @Test
    public void filterbonbep()
    {
        FilterProduct_BepGasPage filtersobep = new FilterProduct_BepGasPage(driver);
        filtersobep.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        scrollToElement(By.xpath("//h3[text()='Số bếp']"));
        WebElement bonbepcheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("4-bep-1012")));
        if (!bonbepcheckbox.isSelected())
        {
            clickByJS(By.xpath("//input[@name='4-bep-1012']"));
            System.out.println("Checkbox 4 bếp has been selected");
        }
        WebElement resultfilter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Bếp Gas Âm BOSCH HMH PCC6A890']")));
        Assert.assertTrue(resultfilter.isDisplayed());
    }

    @Test
    public void filternambep()
    {
        FilterProduct_BepGasPage filtersobep = new FilterProduct_BepGasPage(driver);
        filtersobep.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        scrollToElement(By.xpath("//h3[text()='Số bếp']"));
        WebElement nambepcheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("5-bep-1013")));
        if (!nambepcheckbox.isSelected())
        {
            clickByJS(By.xpath("//input[@name='5-bep-1013']"));
            System.out.println("Checkbox 5 bếp has been selected");
        }
        WebElement resultfilter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Bếp gas âm Malloca GHS 915C']")));
        Assert.assertTrue(resultfilter.isDisplayed());
    }

    @Test
    public void filtersaubep()
    {
        FilterProduct_BepGasPage filtersobep = new FilterProduct_BepGasPage(driver);
        filtersobep.openBepgastab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        scrollToElement(By.xpath("//h3[text()='Số bếp']"));
        WebElement saubepcheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("6-bep-1014")));
        if (!saubepcheckbox.isSelected())
        {
            clickByJS(By.xpath("//input[@name='6-bep-1014']"));
            System.out.println("Checkbox 6 bếp has been selected");
        }
        WebElement resultfilter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='BẾP GAS BÁN CÔNG NGHIỆP KHÈ 6 LÒ']")));
        Assert.assertTrue(resultfilter.isDisplayed());
    }


}









