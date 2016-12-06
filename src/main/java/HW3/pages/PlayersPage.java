package HW3.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlayersPage {

    public static final String URL_players = "http://80.92.229.236:81/players";
    public static final String URL_insert = "http://80.92.229.236:81/players/insert";
    private static WebDriver driver;
    public PlayersPage(WebDriver driver) {
        this.driver = driver;
    }
    public final String randomValue = RandomStringUtils.randomAlphanumeric(8);
    public String email = randomValue + "@mail.ru";
    public String nameUser = randomValue;
    public void open() {
        driver.get(URL_players);
    }
    public void openInsert() {
        driver.get(URL_insert);
    }

    public void clickOnInsert() {
        driver.findElement(By.xpath(".//a[@href='http://80.92.229.236:81/players/insert']"));
    }

    public void setUserName() {
        WebElement nameuserInput = driver.findElement(By.id("ff14642ac1c__us_login"));
        nameuserInput.clear();
        nameuserInput.sendKeys(nameUser);
    }

    public void setEmail() {
        WebElement emailInput = driver.findElement(By.id("ff14642ac1c__us_email"));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void setPassw() {
        WebElement passwInput = driver.findElement(By.id("ff14642ac1c__us_password"));
        passwInput.clear();
        String passw = "43965435";
        passwInput.sendKeys(passw);
    }

    public void setConfirmPassword() {
        WebElement confirmPasswordInput = driver.findElement(By.id("ff14642ac1c__confirm_password"));
        confirmPasswordInput.clear();
        String confirmPassword = "43965435";
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void setFirstName() {
        WebElement firstNameInput = driver.findElement(By.id("ff14642ac1c__us_fname"));
        firstNameInput.clear();
        String firstName = "first name";
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName() {
        WebElement lastNameInput = driver.findElement(By.id("ff14642ac1c__us_lname"));
        lastNameInput.clear();
        String lastName = "last name";
        lastNameInput.sendKeys(lastName);
    }

    public void setCity() {
        WebElement cityInput = driver.findElement(By.id("ff14642ac1c__us_city"));
        cityInput.clear();
        String city = "London";
        cityInput.sendKeys(city);
    }

    public void setAddress() {
        WebElement addressInput = driver.findElement(By.id("ff14642ac1c__us_address"));
        addressInput.clear();
        String address = "Lenina street";
        addressInput.sendKeys(address);
    }

    public void setPhone() {
        WebElement phoneInput = driver.findElement(By.id("ff14642ac1c__us_phone"));
        phoneInput.clear();
        String phone = "123456789";
        phoneInput.sendKeys(phone);
    }

    public void clickOnSave() {
        WebElement saveButton = driver.findElement(By.xpath(".//input[@value='Save']"));
        saveButton.click();
    }

    public void setPlayerNameInSearchField() {
        WebElement searchFieldInput = driver.findElement(By.id("723a925886__login"));
        searchFieldInput.clear();
        searchFieldInput.sendKeys("starbass");
    }

    public void clickOnSearch() {
        WebElement searchButton = driver.findElement(By.xpath(".//input[@name='search' and @type='button']"));
        searchButton.click();
    }

    public void clickOnEditBtnNear() {
        WebElement editButton = driver.findElement(By.xpath("//tr[last()]/td[1]/a"));  //img[@alt='Edit']"));
        editButton.click();
    }
    public void clickOnResetBtn(){
     WebElement resetButton = driver.findElement(By.xpath(".//*[@name='reset']"));
        resetButton.click();
    }

    public void setToSearchByPlayerName() {
        WebElement searchPlayerField = driver.findElement(By.id("723a925886__login"));
        searchPlayerField.clear();
        searchPlayerField.sendKeys("starbass");
    }

    public void setToSearchByEmail() {
        WebElement searchEmailField = driver.findElement(By.xpath(".//*[@id='723a925886__email']"));
        searchEmailField.sendKeys("sdbfidsg@mail.ru");
    }

    public void setToSearchByCity() {
        WebElement searchCityField = driver.findElement(By.xpath(".//*[@id='723a925886__city']"));
        searchCityField.sendKeys("Kyiv");
    }

    public void setToSearchByRegDateFrom() {
        WebElement searchRegDataFromField = driver.findElement(By.xpath(".//*[@id='723a925886__reg_date_from']"));
        searchRegDataFromField.sendKeys("12-06-2016");
    }

    public void setToSearchByFName() {
        WebElement searchFnameField = driver.findElement(By.xpath(".//*[@id='723a925886__firstname']"));
        searchFnameField.sendKeys("First Name");
    }

    public void setToSearchByLName() {
        WebElement searchLnameField = driver.findElement(By.xpath(".//*[@id='723a925886__lastname']"));
        searchLnameField.sendKeys("Last Name");
    }
    public void setToSearchByRegDateTill() {
        WebElement searchRegDataTillField = driver.findElement(By.xpath(".//*[@id='723a925886__reg_date_to']"));
        searchRegDataTillField.sendKeys("12-06-2016");
    }

    public void clickOnDelete() {
        WebElement deleteButton = driver.findElement(By.xpath("//*[@alt='Delete']"));
        deleteButton.click();
    }

}