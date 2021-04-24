package org.example;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;


public class StepImplementation extends BaseTest {


    @Step("<site> sayfası açılır")
    public void openPage(String site){
        driver.get(site);
        String siteTittle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        Assert.assertEquals(siteTittle, driver.getTitle());
    }

    @Step("Giriş yap butonuna tıklanılır.")
    public void clickLogin(){
        WebElement loginDiv = driver.findElement(By.id("myAccount"));
        actions.moveToElement(loginDiv).release().perform();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("login"))).click();
        fluentWait(By.id("txtUserName"));
    }

    @Step("Kullanıcı alanına <userName> bilgisi yazılır.")
    public void inputUserName(String userName){
       driver.findElement(By.id("txtUserName")).sendKeys(userName);
    }

    @Step("Şifre alanına <password> bilgisi yazılır.")
    public void inputPassword(String password){
        driver.findElement(By.id("txtPassword")).sendKeys(password);
    }

    @Step("Giriş buttonuna tıklanır.")
    public void clickLoginButton(){
        WebElement shopButton = fluentWait(By.id("btnLogin"));
        driver.findElement(By.id("btnLogin")).click();
    }

    @Step("Login kontrolü yapılır Eğer login başarılı olmuşsa sepet tutar kontrolü yapılır.")
    public void loginCheck() {
        String  ShopCart = "//*[@class='sf-OldMyAccount-2OvEz sf-OldMyAccount-3TYPj']";
        //WebElement shopButton = driver.findElement(By.xpath(ShopCart));
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(ShopCart))).click();
    }

    @Step("Rasgele bir kategorinin üzerine gelinir ve açılan alt kategorlerden rasgele bir alt kategori seçilir.")
    public void selectCategory() throws InterruptedException{
        var categori = driver.findElements(By.className("sf-HeaderButton-2afof"));
        actions = new Actions(driver);
        actions.moveToElement(categori.get(0)).click().perform();
        var kategoriSec = driver.findElements(By.className("sf-CategoryBox-1hCPY"));
        actions = new Actions(driver);
        Random rand = new Random();
        actions.moveToElement(kategoriSec.get(rand.nextInt(kategoriSec.size()))).click().perform();

    }




}
