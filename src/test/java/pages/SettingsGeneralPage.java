package pages;


import dto.FormDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GeneralUtils;

/**
 * Class with the elements and functionalities of General Settings
 */
public class SettingsGeneralPage {

    public By btnSave =  By.id("ember330");

    //Title & description
    public By btnTitle =  By.xpath("//button[contains(@data-ember-action-334,'334')]");
    public By inTitle = By.id("ember431");
    public By inDescription = By.id("ember433");

    //Site timezone
    public By btnTime =  By.xpath("//button[contains(@data-ember-action-334,'334')]");
    public By inTimezone = By.id("timezone");

    //Social accounts
    public By btnSocialAccount =  By.xpath("//button[contains(@data-ember-action-349,'349')]");
    public By inTwitterProfile = By.id("ember461");


    private WebDriver driver;
    private GeneralUtils utils;

    /**
     * Class constructor
     * @param driver
     */
    public SettingsGeneralPage(WebDriver driver) {
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
    public void register (FormDto dto) {
        utils.click(btnTitle);
        utils.input(inTitle, dto.getTitlePage());
        utils.input(inDescription, dto.getDescriptionPage());

        utils.click(btnTime);
        utils.selectOption(inTimezone, dto.getTimeZone());

        utils.click(btnSocialAccount);
        utils.input(inTwitterProfile, dto.getTitlePage());

    }


}
