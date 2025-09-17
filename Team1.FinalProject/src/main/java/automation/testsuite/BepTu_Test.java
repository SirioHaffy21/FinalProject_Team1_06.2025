package automation.testsuite;
import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BepTu_Test extends CommonBase {
    @BeforeMethod
    public void openBrowser(){
        driver = initChromeDriver(CT_PageURL.HaiHa_BepTu_URL);
    }
    public void clickSeeMoreIfPresent() {
        while (isElementDisplayed(By.xpath("//a[contains(@class,'btn-linear-orange') and span[contains(text(),'Xem thêm')]]"))){
            clickByJS(By.xpath("//a[contains(@class,'btn-linear-orange') and span[contains(text(),'Xem thêm')]]"));
        }
    }
    public List<WebElement> loadProducts(){
        getElementPresentDOM2(By.xpath("//div[contains(@class, 'product-list')]"),3);
        clickSeeMoreIfPresent();
        List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class, 'product-list')]//a"));
        System.out.println("Số sản phẩm hiển thị: " + products.size());
        assertTrue(products.size()> 0, "Không có sản phẩm nào hiển thị sau khi lọc!");
        return products;
    }
    @Test
    public void locTheoGia3to5(){
        WebElement priceFilter = getElementPresentDOM2(By.xpath("//h3[text()='Mức giá']/" +
                "following-sibling::div[contains(@class,'category-menus')]"),3);
        clickByJS(By.xpath("//span[contains(text(), '3.000.000 > 5.000.000')]"));
        List<WebElement> products = loadProducts();
        for (WebElement product : products) {
            try {
                String priceText = product.findElement(By.xpath("//span[contains(@class,'sale-price')]")).getText();
                String digits = priceText.replaceAll("[^0-9]", "");
                int price = Integer.parseInt(digits);
                // Assert nằm trong khoảng 3 - 5 triệu
                assertTrue(price >= 3000000 && price <= 5000000,
                        "Sản phẩm không có giá trong khoảng 3-5 triệu: " + priceText);
            } catch (Exception e) {
                System.out.println("Không lấy được giá sản phẩm.");
            }
        }
    }
    @Test
    public void locTheoHangSX() throws InterruptedException {
        WebElement brandFilter = getElementPresentDOM2(By.xpath("//h3[text()='HÃNG SẢN XUẤT']/following-sibling::div[contains(@class,'category-menus')]"),3);
        click(By.xpath("//div[@class='category-menus']//a[contains(@href,'/danh-muc/bep-tu/kainer')]"));
        Thread.sleep(10000);

        List<WebElement> products = loadProducts();
        for (WebElement product : products) {
            String productText = product.getText().toLowerCase();
            assertTrue(productText.contains("kainer"),
                    "Sản phẩm không thuộc hãng kanier: " + productText);
        }
    }
    @Test
    public void locTheoXuatXu(){
        scrollToElement(By.xpath("//h3[text()='Xuất xứ']"));
        clickByJS(By.xpath("(//a[contains(@class,'text-gold-100 text-sm see-more mt')]//span[text()='Xem thêm'])[2]"));
        click(By.id("viet-nam-1004"));
        List<WebElement> products = loadProducts();
        for (int i = 0; i < products.size(); i++) {
            String openInNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN); // Windows/Linux
            products.get(i).sendKeys(openInNewTab);

            String mainWindow = driver.getWindowHandle();
            Set<String> listWindow = driver.getWindowHandles();
            for (String window : listWindow) {
                if (!mainWindow.equals(window)) {
                    driver.switchTo().window(window);
                    WebElement origin = getElementPresentDOM2(
                            By.xpath("(//span[contains(text(),'Xuất xứ')]/following-sibling::span[text()='Việt Nam'])[1]"),3);

                    assertTrue(origin.getText().toLowerCase().contains("việt nam"),
                            "Sản phẩm không có xuất xứ Việt Nam: " + driver.getCurrentUrl());
                    driver.close();
                }
            }
            driver.switchTo().window(mainWindow);
        }
    }

    //case failed vi noi dung hien thi khong dong nhat trong cacs trang detail nen assert k the chinh xac
    @Test
    public void filterBySoBep() throws InterruptedException {

        // Click filter theo số bếp
        scrollToElement(By.xpath("//h3[text()='Số bếp']"));
        clickByJS(By.xpath("(//a[contains(@class,'text-gold-100 text-sm see-more mt')]//span[text()='Xem thêm'])[3]"));
        click(By.id("5-bep-1013"));
        List<WebElement> products = loadProducts();
        for (int i = 0; i < products.size(); i++) {
            String openInNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN); // Windows/Linux
            products.get(i).sendKeys(openInNewTab);

            String mainWindow = driver.getWindowHandle();
            Set<String> listWindow = driver.getWindowHandles();
            for (String window : listWindow) {
                if (!mainWindow.equals(window)) {
                    driver.switchTo().window(window);
                    Thread.sleep(10000);
                    WebElement soBepDetail = getElementPresentDOM2(
                            By.xpath("(//span[contains(text(),'Số bếp nấu')]/following-sibling::span[contains(text(),'5')])"),3);

                    assertTrue(soBepDetail.getText().toLowerCase().contains("5"),
                            "Chi tiết sản phẩm không thấy: " + driver.getCurrentUrl());
                    driver.close();
                }
            }
            driver.switchTo().window(mainWindow);
        }
    }

    //Case failed vi title ten tren web khong chinh xac
    @Test
    public void locTheoPhanLoai(){
        scrollToElement(By.xpath("//h3[text()='Phân loại']"));
        click(By.id("bep-dien-tu-1011"));
        getElementPresentDOM2(By.xpath("//div[contains(@class, 'product-list')]"),3);
        List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class, 'product-list')]/a"));
        System.out.println("Số sản phẩm hiển thị khi lọc: " + products.size());
        assertTrue(products.size()> 0, "Không có sản phẩm nào hiển thị sau khi lọc!");
        for (WebElement product : products) {
            String productText = product.getText().toLowerCase();
            assertTrue(productText.contains("điện từ"),
                    "Sản phẩm không thuộc hãng: " + productText);
        }
    }

    //Case failed vi tren web sap xep gia tu thap den cao bi sai
    @Test
    public void locTheoTabGiaThap(){
        click(By.xpath("//a[text()='Giá thấp']"));
        clickSeeMoreIfPresent();
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[contains(@class,'sale-price')]"));
        List<Integer> actualPrices = new ArrayList<>();
        for (WebElement element : priceElements) {
            String priceText = element.getText().replaceAll("[^0-9]", "");
            if (!priceText.isEmpty()) {
                actualPrices.add(Integer.parseInt(priceText));
            }
        }
        List<Integer> sortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedPrices);

        assertEquals(actualPrices, sortedPrices);
    }

    //Case failed vi tren web sap xep gia tu cao den thap bi sai
    @Test
    public void locTheoTabGiaCao() {
        click(By.xpath("//a[text()='Giá cao']"));
        clickSeeMoreIfPresent();
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[contains(@class,'sale-price')]"));
        List<Integer> actualPrices = new ArrayList<>();
        for (WebElement element : priceElements) {
            String priceText = element.getText().replaceAll("[^0-9]", "");
            if (!priceText.isEmpty()) {
                actualPrices.add(Integer.parseInt(priceText));
            }
        }
        List<Integer> sortedPrices = new ArrayList<>(actualPrices);
        sortedPrices.sort(Collections.reverseOrder());

        assertEquals(actualPrices, sortedPrices);
    }

    @AfterMethod
    public void closeBrowser(){
        closeDriver();
    }

}
