package HW3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPlayerPage {

    private WebDriver driver;
    public EditPlayerPage(WebDriver driver) {
        this.driver = driver;
    }


    public String getEmailValue() {
        WebElement getEmailValue = driver.findElement(By.id("ff14642ac1c__us_email"));
        String emailValue = getEmailValue.getAttribute("value");
        return emailValue;
    }

        public String getFnameValue(){
            WebElement getFnameValue = driver.findElement(By.id("ff14642ac1c__us_fname"));
            String fnameValue = getFnameValue.getAttribute("value");
            return fnameValue;
        }
        public String getLnameValue(){
            WebElement getLnameValue = driver.findElement(By.id("ff14642ac1c__us_lname"));
            String lnameValue = getLnameValue.getAttribute("value");
            return lnameValue;
        }
        public String getCityValue(){
            WebElement getCityValue = driver.findElement(By.id("ff14642ac1c__us_city"));
            String cityValue = getCityValue.getAttribute("value");
            return cityValue;
        }
        public String getAddressValue(){
            WebElement getAddressValue = driver.findElement(By.id("ff14642ac1c__us_address"));
            String addressValue = getAddressValue.getText();
            return addressValue;
        }

        public String getPhoneValue(){
            WebElement getPhoneValue = driver.findElement(By.id("ff14642ac1c__us_phone"));
            String phoneValue = getPhoneValue.getAttribute("value");
            return phoneValue;
        }

    public void setFields() {
        WebElement newEmail = driver.findElement(By.id("ff14642ac1c__us_email"));
        newEmail.clear();
        newEmail.sendKeys("sdbfidsg@mail.ru");

        WebElement newFirstName = driver.findElement(By.id("ff14642ac1c__us_fname"));
        newFirstName.clear();
        newFirstName.sendKeys("Alex");

        WebElement newLastName = driver.findElement(By.id("ff14642ac1c__us_lname"));
        newLastName.clear();
        newLastName.sendKeys("Messi");

        WebElement newCity = driver.findElement(By.id("ff14642ac1c__us_city"));
        newCity.clear();
        newCity.sendKeys("Kyiv");

        WebElement newAddress = driver.findElement(By.id("ff14642ac1c__us_address"));
        newAddress.clear();
        newAddress.sendKeys("Franklin street");

        WebElement newPhone = driver.findElement(By.id("ff14642ac1c__us_phone"));
        newPhone.clear();
        newPhone.sendKeys("12345");

        WebElement newSaveButton = driver.findElement(By.xpath(".//input[@value='Save']"));
        newSaveButton.click();
    }

}
