package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.PageLocator_Test;

public class Testsuite_test extends CommonBase  {
	@BeforeMethod
	@Parameters("browser")
	public void openBrowser(@Optional("chrome") String browser) {
		driver = setupDriver(browser);
		driver.get(CT_PageURL.Hoa_MayHutMui_URL);
	}
	@Test
	public void viewList() {
		scrollToElement(By.xpath("//h4[text()='MÁY HÚT MÙI KÍNH CONG KAINER KA – 700A']"));
		assertTrue(isElementDisplayed(By.xpath("//a[text()='Phổ biến']")));
	}
	@Test
	public void clickGiamGiaNhieu() throws InterruptedException {
//		scrollToElement(By.xpath("//h3[text()='Mức giá']"));
		PageLocator_Test factory = new PageLocator_Test(driver);
		factory.clickTabGiamGiaNhieu();
		for (int i =0; i < factory.layDanhSachSanPham().size(); i++) {
			int giaGoc = factory.LayGiaSanPham(factory.layGiaGoc().get(i));
			int giaMoi = factory.LayGiaSanPham(factory.layGiaMoi().get(i));
			System.out.println("Giá gốc: " + giaGoc + " | Giá giảm: " + giaMoi);
			if (giaMoi >= giaGoc) {
				System.out.println("Bor qua cac sp ko giam gia: "+i);
				continue;
			}
			assertTrue(giaMoi < giaGoc, "Gia giam ko dung.Gia goc: "+giaGoc+"| Gia giam: "+giaMoi);
			if (i <factory.laySaleTag().size()) {
				int percentShow = Integer.parseInt(factory.laySaleTag().get(i).getText().replaceAll("[^0-9]", ""));
				int percentCalc = (int) Math.round((giaGoc - giaMoi)*100/giaGoc);
				Assert.assertEquals(percentShow,percentCalc,"% giam ko dung");
			}
		}
		
	}
	@Test
	public void clickTabGiaThap() throws InterruptedException {
		PageLocator_Test factory = new PageLocator_Test(driver);
		factory.clickTabGiaThap();
		for(int i= 0; i< factory.layGiaMoi().size();i++) {
			int giaMoi = factory.LayGiaSanPham(factory.layGiaMoi().get(i));
			Assert.assertTrue(giaMoi <3000000, "Gia khong nho hon 3tr");	
		}
		
	}
	@Test
	public void clickTabGiaCao() throws InterruptedException {
		PageLocator_Test factory = new PageLocator_Test(driver);
		factory.clickTabGiaCao();
		for( int i= 0; i > factory.layGiaMoi().size();i++) {
			int giaMoi = factory.LayGiaSanPham(factory.layGiaMoi().get(i));
			System.out.println("Sản phẩm " + i + " có giá: " + giaMoi);
		Assert.assertTrue(giaMoi >15000000, "Gia khong lon hon 15tr.San pham "+i+"co gia: "+giaMoi);
		}
	}
	@Test
	public void clickFilterDanhMuc() throws InterruptedException {
		PageLocator_Test factory = new PageLocator_Test(driver);
		factory.ChonFilter(factory.getFilterDanhMuc(), "Máy Hút Mùi Ống Khói", "Danh mục");
		Assert.assertTrue(isElementDisplayed(By.xpath("//h4[text()='MÁY HÚT MÙI KÍNH CONG KAINER KA-270C']")));
		}
	@Test
	public void clickFilterHangSX() throws InterruptedException {
		PageLocator_Test factory = new PageLocator_Test(driver);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 //chon HSX BOSCH
		 WebElement boschFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'HÃNG SẢN XUẤT')]/following-sibling::div//img[contains(@src,'logo bosch')]/parent::a")));
		 boschFilter.click();
		// Verify tất cả sản phẩm đều chứa Bosch
		 List<WebElement> layDanhSachSanPham = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h4.title-card")));
		for(int i =0; i <factory.getDanhSachSanPham().size(); i++) {
			String tenSp = factory.getDanhSachSanPham().get(i).getText().trim();
			System.out.println("SP: "+i+":"+tenSp);
			Assert.assertTrue(tenSp.toLowerCase().contains("bosch"),"SP ko thuoc HSX Bosch:" +tenSp);
		}
		
	}
	@Test
	public void clickFilterMucGia() throws InterruptedException {
		clickTabGiaThap();
		clickTabGiaCao();
	}
	@Test
	public void clickFilterXuatXu() throws InterruptedException {
		scrollToElement(By.xpath("//h3[text()='Xuất xứ']"));
		clickByJS(By.xpath("(//span[text()='Xem thêm'])[2]"));
		PageLocator_Test factory = new PageLocator_Test(driver);
		factory.ChonFilter(factory.getFilterXuatXu(), "Indonesia", "Xuất xứ");
		WebElement indonesiaFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Indonesia')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", indonesiaFilter);
		List<WebElement> getDanhSachSanPham = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h4.title-card")));
		WebElement firstProduct = getDanhSachSanPham.get(0);
		String tenSp = firstProduct.getText().trim();
		System.out.println("Chon sp dau tien: "+tenSp);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstProduct);
		Thread.sleep(5000);
		WebElement xuatXuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(.,'Xuất xứ')]/span[@class='font-bold uppercase text-maroon-600']")));
		    String xuatXuText = xuatXuElement.getText().toLowerCase();
		    System.out.println("Xuất xứ hiển thị: " + xuatXuText);
		    Assert.assertTrue(xuatXuText.contains("indonesia"), 
		        "SP không có xuất xứ Indonesia, mà là: " + xuatXuText);;
	}
	@Test
	public void clickFilterCongSuat() throws InterruptedException {
		scrollToElement(By.xpath("//h3[text()='Công Suất']"));
		PageLocator_Test factory = new PageLocator_Test(driver);
		factory.ChonFilter(factory.getFilterCongSuat(), "< 500 m3/h", "Công Suất");
		WebElement firstCongSuat = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'< 500 m3/h')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstCongSuat);
		List<WebElement> getDanhSachSanPham = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h4.title-card")));
		WebElement firstProduct = getDanhSachSanPham.get(0);
		String tenSp = firstProduct.getText().trim();
		System.out.println("Chon sp dau tien: "+tenSp);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstProduct);
		Thread.sleep(5000);
		scrollToElement(By.xpath("//span[text()='Thông số kỹ thuật']"));
		clickByJS(By.xpath("(//span[text()='Xem thêm nội dung'])[2]"));
		WebElement congSuatElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[span[normalize-space(text())='công xuất']]/span[2]")));
		String congSuatText = congSuatElement.getText().trim();
		System.out.println("Cong suat hiển thị: " + congSuatText);
		Pattern pattern = Pattern.compile("(\\d+)(?=\\s*m3)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(congSuatText);
		int congSuatValue = 0;
		Assert.assertTrue(congSuatValue <500, "Sp cos song suat >= 500 m3/h, thuc te:"+congSuatValue+"m3/h");
	}
	@Test
	public void clickFilterKichThuoc() throws InterruptedException {
		scrollToElement(By.xpath("//h3[text()='Kích Thước']"));
//		PageLocator_Test factory = new PageLocator_Test(driver);
//		factory.ChonFilter(factory.getFilterKichThuoc(), "700 mm", "Kích Thước");
		WebElement secondKichThuoc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[span[normalize-space()='700 mm']]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", secondKichThuoc);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", secondKichThuoc);
		System.out.println("Click 700mm:"+secondKichThuoc.getText());
		scrollToElement(By.xpath("//a[text()='Phổ biến']"));
		List<WebElement> getDanhSachSanPham = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h4.title-card")));
		WebElement firstProduct = getDanhSachSanPham.get(0);
		String tenSp = firstProduct.getText().trim();
		System.out.println("Chon sp dau tien: "+tenSp);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstProduct);
		Thread.sleep(5000);
		scrollToElement(By.xpath("//span[text()='Thông số kỹ thuật']"));
		WebElement kichThuocDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[span[normalize-space(text())='Kích thước']]/span[2]")));
		String kichThuocText = kichThuocDetail.getText().toLowerCase();
		System.out.println("Kích thước hiển thị: " + kichThuocText);
		Assert.assertTrue(kichThuocText.contains("700"), "SP không có kích thước 700mm");	
	}
	@Test
	public void handleDetailProduct() throws InterruptedException {
		viewList();
		List<WebElement> getDanhSachSanPham = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h4.title-card")));
		String tenSp = getDanhSachSanPham.get(0).getText().trim();
		System.out.println("Chon sp dau tien: "+tenSp);
		WebElement firstProduct= wait.until(ExpectedConditions.elementToBeClickable(getDanhSachSanPham.get(0)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstProduct);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-detail"))); 
		WebElement btnMuaNgay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'Mua ngay')])[1]")));
		btnMuaNgay.click();
		PageLocator_Test factory = new PageLocator_Test(driver);
		factory.nhapTen("Hoa");
		factory.nhapSDT("123");
		factory.nhapDiaChi("1a yet kieu");
		factory.selectCOD();
		factory.datHang();
		assertTrue(isElementDisplayed(By.xpath("//small[normalize-space()='Số điện thoại không hợp lệ']")));
	}
		
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	
	
	
	
	
	

}
