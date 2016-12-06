package HW3.tests;

import HW3.pages.PlayersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import HW3.pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class SearchTests {

    WebDriver driver; // Declare var
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
    /**
     * Preconditions:
     * Open application Login Page URL
     */
    @BeforeMethod
    public void beforeMethod() {
        playersPage = new PlayersPage(driver);
        playersPage.open(); //open poker URL

    }
    /**
     * Steps:
     * 1. To fill a value in Player field. Click Search bnt and Reset btn
     * 2. To fill a value in Email field. Click Search bnt and Reset btn
     * 3. To fill a value in City field. Click Search bnt and Reset btn
     * 4. To fill a value in Reg Data From field. Click Search bnt and Reset btn
     * 5. To fill a value in First name field. Click Search bnt and Reset btn
     * 6. To fill a value in Last name field. Click Search bnt and Reset btn
     * 7. To fill a value in Reg Data Till field. Click Search bnt and Reset btn
     */
    @Test
    public void searchPlayerByFilterFields(){
        //лишним ассертом кашу не испортишь :)
        playersPage.setToSearchByPlayerName();
        playersPage.clickOnSearch();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful login");
        playersPage.clickOnResetBtn();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful login");

        playersPage.setToSearchByEmail();
        playersPage.clickOnSearch();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful login");
        playersPage.clickOnResetBtn();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful login");

        playersPage.setToSearchByCity();
        playersPage.clickOnSearch();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful login");
        playersPage.clickOnResetBtn();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful login");

        playersPage.setToSearchByRegDateFrom();
        playersPage.clickOnSearch();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful login");
        playersPage.clickOnResetBtn();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful login");

        playersPage.setToSearchByFName();
        playersPage.clickOnSearch();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful login");
        playersPage.clickOnResetBtn();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful login");

        playersPage.setToSearchByLName();
        playersPage.clickOnSearch();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful login");
        playersPage.clickOnResetBtn();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful login");

        playersPage.setToSearchByRegDateTill();
        playersPage.clickOnSearch();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful login");
        playersPage.clickOnResetBtn();
        Assert.assertEquals(driver.getCurrentUrl(), PlayersPage.URL_players, "You are NOT on players page.");
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful login");

    }

    @AfterTest
    public void afterTest() {

        driver.quit();
    }

}