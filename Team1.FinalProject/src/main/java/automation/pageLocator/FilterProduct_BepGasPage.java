package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterProduct_BepGasPage {
    private WebDriver driver;
    // xpath của đối tượng Bếp gas
    private By tabBepgas = By.xpath("//a[text()=' Bếp Gas ']");
    // xpath của các element theo Danh mục
    private By Bepgasam= By.xpath("//a[text()='Bếp Gas Âm']");
    private By Bepgasduong = By.xpath("//a[text()='Bếp Gas Dương']");
    private By Bepgasgiare = By.xpath("//a[text()='Bếp Gas Giá Rẻ']");
    private By Bepgascongnghiep = By.xpath("//a[text()='Bếp Gas Công Nghiệp']");
    private By Bepgasdientu = By.xpath("//a[text()='Bếp Gas Kết Hợp Điện Từ']");
    private By boBinhgas = By.xpath("//a[text()='Bộ Bình Gas']");
    private By Bepgasdon = By.xpath("//a[text()='Bếp Gas Đơn']");
    private By Bepgasdulich = By.xpath("//a[text()='Bếp Gas Du Lịch']");
    private By bobinhBepgas = By.xpath("//a[text()='Bộ Bình Bếp Gas']");
    private By Phukiengas = By.xpath("//a[text()='Phụ Kiên Gas']");
    private By BepgasHongngoai = By.xpath("//a[text()='Bếp Gas Hồng Ngoại']");

    public FilterProduct_BepGasPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openBepgastab() {
        driver.findElement(tabBepgas).click();
    }

    public void chooseBepgasam() {
        driver.findElement(Bepgasam).click();
    }

    public void chooseBepgasduong() {
        driver.findElement(Bepgasduong).click();
    }

    public void chooseBepgasgiare() {
        driver.findElement(Bepgasgiare).click();
    }

    public void chooseBepgascongnghiep() {
        driver.findElement(Bepgascongnghiep).click();
    }

    public void chooseBepgasdientu() {
        driver.findElement(Bepgasdientu).click();
    }

    public void chooseboBinhgas() {
        driver.findElement(boBinhgas).click();
    }

    public void chooseBepgasdon() {
        driver.findElement(Bepgasdon).click();
    }

    public void chooseBepgasdulich() {
        driver.findElement(Bepgasdulich).click();
    }

    public void chooseboBinhbepgas() {
        driver.findElement(bobinhBepgas).click();
    }

    public void choosePhukiengas() {
        driver.findElement(Phukiengas).click();
    }

    public void chooseBepgasHongngoai() {
        driver.findElement(BepgasHongngoai).click();
    }


}
