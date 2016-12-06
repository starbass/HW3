package HW3.tests;

import HW3.pages.EditPlayerPage;
import HW3.pages.LoginPage;
import HW3.pages.PlayersPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CRUDUserTests {
    private WebDriver driver;
    public PlayersPage playersPage;

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        LoginPage loginPage = new LoginPage(driver);//initialize/create object/open firefox
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.open();
        loginPage.login("admin", "123");
    }

    @BeforeMethod
    public void beforeMethod() {
        playersPage = new PlayersPage(driver);
        playersPage.open(); //open poker URL
    }

    /**
     * Steps:
     * 1. Click on Insert btn
     * 2. Fill username, email, password and confirm password, first name, last name, city, address and phone fields
     * 3. ckick Save btn
     */

    @Test
    public void createUserTest() {
        playersPage.clickOnInsert();
        playersPage.openInsert();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_insert, "You are NOT on insert page.");
        PlayersPage playersPage = new PlayersPage(driver);
        Assert.assertEquals(driver.getTitle(), "Players - Insert", "Wrong title after click Insert btn");
        playersPage.setUserName();
        playersPage.setEmail();
        playersPage.setPassw();
        playersPage.setConfirmPassword();
        playersPage.setFirstName();
        playersPage.setLastName();
        playersPage.setCity();
        playersPage.setAddress();
        playersPage.setPhone();
        playersPage.clickOnSave();
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful user creating");
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
    }

    /**Steps:
     * 1. Fill username in a search field
     * 2. Click Search btn
     * 3. Click on Edit btn near username
     * 4. check the contents of fields// пришлось сюда запихнуть проверки , потому что почему-то только здесь работают
     */
    @Test
        public void searchAndEditPlayerTest(){
            playersPage.setPlayerNameInSearchField();
            playersPage.clickOnSearch();
            Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
            Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful user searching");
            playersPage.clickOnEditBtnNear();
            Assert.assertEquals(driver.getTitle(), "Players - Edit", "Wrong title after unsuccessful edit btn click");
            EditPlayerPage editPlayerPage = new EditPlayerPage(driver);

            String actualEmailResult = editPlayerPage.getEmailValue();
            String expectedEmailResult = "starbass@mail.ru";
            Assert.assertNotEquals(actualEmailResult, expectedEmailResult, "email does not match");

            String actualFnameResult = editPlayerPage.getFnameValue();
            String expectedFnameResult = "first name";
            Assert.assertNotEquals(actualFnameResult, expectedFnameResult, "first name matches");

            String actualLnameResult = editPlayerPage.getLnameValue();
            String expectedLnameResult = "last name";
            Assert.assertNotEquals(actualLnameResult, expectedLnameResult, "last name matches");

            String actualCityResult = editPlayerPage.getCityValue();
            String expectedCityResult = "London";
            Assert.assertNotEquals(actualCityResult, expectedCityResult, "city does not match");

            String actualAddressResult = editPlayerPage.getAddressValue();
            String expectedAddressResult = "Lenina street";
            Assert.assertNotEquals(actualAddressResult, expectedAddressResult, "address matches");

            String actualPhoneResult = editPlayerPage.getPhoneValue();
            String expectedPhoneResult = "123456789";
            Assert.assertNotEquals(actualPhoneResult, expectedPhoneResult, "phone does not match");
        }

    /**
     * Steps:
     * 1. Input username in Search field
     * 2. Click Search btn
     * 3. Click on Edit btn near the username
     * 4. Edit the fields
     */
    @Test()
    public void fieldsEdit(){
            playersPage.setPlayerNameInSearchField();
            playersPage.clickOnSearch();
            playersPage.clickOnEditBtnNear();
            EditPlayerPage editPlayerPage = new EditPlayerPage(driver);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            editPlayerPage.setFields();
        }

    /**
     * Steps:
     * 1. Open Players page
     * 2. Delite a first player in a Players list
     */
    @Test
    public void deletePlayer() {
        //удаляет первого игрока на странице
        playersPage.clickOnDelete();
        WebDriverWait wait = new WebDriverWait(driver, 20, 100);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    @AfterTest
    public void afterTest() {

        driver.quit();
    }

}
