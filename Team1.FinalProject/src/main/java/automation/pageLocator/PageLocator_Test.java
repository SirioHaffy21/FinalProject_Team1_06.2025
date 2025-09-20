package automation.pageLocator;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLocator_Test {
	private WebDriver driver;
	//Tab sap xep
	@FindBy(xpath="//a[text()='Giảm giá nhiều']") private WebElement tabGiamGiaNhieu;
	@FindBy(xpath="//a[text()='Giá thấp']") private WebElement tabGiaThap;
	@FindBy(xpath="//a[text()='Giá cao']") private WebElement tabGiaCao;
	//Danh sach san pham
	@FindBy(xpath="//div[@class='flex flex-wrap product-list']") private List<WebElement> danhSachSanPham;
	@FindBy(css = ".old-price") private List<WebElement> giaGoc;
	@FindBy(css = ".sale-price") private List<WebElement> GiaMoi;
	@FindBy(xpath="//div[@class='absolute top-0 right-0 z-10']") private List<WebElement> tags;
	//Filter
	@FindBy(xpath="//h3[contains(text(),'Danh mục')]/following-sibling::div//a") private List<WebElement> filterDanhMuc;
	@FindBy(xpath="//h3[contains(text(),'HÃNG SẢN XUẤT')]/following-sibling::div//a") private List <WebElement> filterHangSX;
	@FindBy(xpath="//h3[contains(text(),'Mức giá')]/following-sibling::div//span") private List<WebElement> filterMucGia;
	@FindBy(xpath="//h3[contains(text(),'Xuất xứ')]/following-sibling::div//label") private List<WebElement> filterXuatXu;
	@FindBy(xpath="//h3[contains(text(),'Công Suất')]/following-sibling::div//input[@type='checkbox']") private List<WebElement> filterCongSuat; 
	@FindBy(xpath="//h3[contains(text(),'Kích Thước')]/following-sibling::div//input[@type='checkbox']") private List<WebElement> filterKichThuoc;
	//Dathang
	@FindBy(xpath="//input[@placeholder='Nhập họ và tên']") WebElement txtHoVaTen;
	@FindBy(xpath="//input[@placeholder='Nhập số điện thoại']") WebElement txtSDT;
	@FindBy(xpath="//input[@placeholder='Nhập số nhà, tên đường, phường/ xã, quận/huyện, tỉnh/ thành phố']") WebElement txtDiaChi;
	@FindBy(id="checkout-type-0") WebElement rdoCOD;
	@FindBy(xpath="//span[text()='Thanh toán']") WebElement btnThanhToan;
	
	
	
	public PageLocator_Test(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickTabGiamGiaNhieu() throws InterruptedException {
		tabGiamGiaNhieu.click();
		Thread.sleep(2000);
	}
	public void clickTabGiaThap() throws InterruptedException {
		tabGiaThap.click();
		Thread.sleep(2000);
	}
	public void clickTabGiaCao() throws InterruptedException {
		tabGiaCao.click();
		Thread.sleep(5000);
	}
	public List<WebElement> layDanhSachSanPham(){
		WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(danhSachSanPham));
		return danhSachSanPham;
	}
	//Ham cho filter
	public void ChonFilter(List<WebElement> options , String filterName, String giaTri) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(options));
		for (WebElement opt : options) {
			if(opt.getText().toLowerCase().contains(giaTri.toLowerCase())) {
				opt.click();
				Thread.sleep(3000);
				layDanhSachSanPham();
				System.out.println("Cho filter:"+filterName +":"+giaTri);
			}
		}
	}

	public List<WebElement> getFilterDanhMuc() {
		return filterDanhMuc;
	}
	public List<WebElement> getFilterHangSX() {
		return filterHangSX;
	}
	
	public List<WebElement> getFilterMucGia() {
		return filterMucGia;
	}
	public List<WebElement> getFilterXuatXu() {
		return filterXuatXu;
	}
	public List<WebElement> getFilterCongSuat() {
		return filterCongSuat;
	}
	public List<WebElement> getFilterKichThuoc() {
		return filterKichThuoc;
	}
	public List<WebElement> getDanhSachSanPham() {
		return danhSachSanPham;
	}
	//Ham lay san pham da giam
	public int LayGiaSanPham( WebElement sanPham) {
		try {
			String giaText =sanPham.findElement(By.xpath("//div[@class='flex prices xs:mx-[9px] mt-[4px] items-center justify-between']")).getText();
			giaText = giaText.replace("₫", "").replace(".", "").trim();
			return Integer.parseInt(giaText);
		} catch (Exception e) {
			return 0;
		}
	}
	public List<WebElement> layGiaGoc(){
		return giaGoc;
	}
	public List<WebElement> layGiaMoi(){
		return GiaMoi;
	}
	public List<WebElement> laySaleTag(){
		return tags;
	}
	public void nhapTen(String name) {
		txtHoVaTen.clear();
		txtHoVaTen.sendKeys(name);
	}
	public void nhapSDT(String sdt) {
		txtSDT.clear();
		txtSDT.sendKeys(sdt);
	}
	public void nhapDiaChi(String address) {
		txtDiaChi.clear();
		txtDiaChi.sendKeys(address);
	}
	public void selectCOD() {
		try {
		rdoCOD.click();
		} catch (TimeoutException e) {
            System.out.println("Không tìm thấy COD, bỏ qua.");
        }
	}
	public void datHang() {
		btnThanhToan.click();
	}
	
		
}
