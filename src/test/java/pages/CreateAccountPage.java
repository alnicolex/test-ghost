package pages;

import dto.FormDto;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import utils.GeneralUtils;

/**
 * Class with the elements Create Account Page
 */
public class CreateAccountPage {

    public By inSite =  By.xpath("//input[@id= 'blog-title']");
    public By inName = By.xpath("//input[@id= 'name']");
    public By inEmail = By.xpath("//input[@id= 'email']");
    public By inPws=  By.xpath("//input[@id= 'password']");
    public By btnSave = By.id("ember9");

    private WebDriver driver;
    private GeneralUtils utils;

    /**
     * Class constructor
     * @param driver
     */
    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        utils = new GeneralUtils(this.driver);
        utils.maximize();
    }

    /**
     * Check page
     * @return check
     */
    public Boolean loadPage(){
        return utils.isDisplayed(btnSave);
    }


    /**
     * Enter Data
     * @param dto
     */
    public void registerData (FormDto dto) {

        utils.input(inSite, dto.getSiteTitle());
        utils.input(inName, dto.getFullName());
        utils.input(inEmail, dto.getEmail());
        utils.input(inPws, dto.getPws());
    }


    /**
     * Submit register
     */
    public SettingPage saveRegister ()  {

        utils.click(btnSave);
        return new SettingPage(driver);

    }
}
