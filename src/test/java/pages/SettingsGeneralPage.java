package pages;


import dto.FormDto;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import utils.GeneralUtils;

/**
 * Class with the elements and functionalities of General Settings
 */
public class SettingsGeneralPage {


    public By btnSave =  By.xpath("//span[contains(text(), 'Save')]");

    // Buttons
    public By btnGeneral = By.xpath("//a[@href=\"#/settings/general/\"]");
    public By btnNavigation = By.xpath("//a[@href=\"#/settings/navigation/\"]");

    //Title & description
    public By btnExpand =  By.xpath("//button[@class=\"gh-btn\"]");
    public By inTitle = By.xpath("//p[contains(text(), 'The name of your site')]//preceding::input[1]");
    public By inDescription = By.xpath("//p[contains(text(), 'Used in your theme, meta data and search results')]//preceding::input[1]");

    //Site timezone
    public By inTimezone = By.id("timezone");

    //Social accounts
    public By inTwitterProfile = By.xpath("//p[contains(text(), 'Twitter profile')]//preceding::input[1]");


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
        return utils.isDisplayed(btnGeneral);
    }


    /**
     * Enter Data
     * @param dto
     */
    public void changeGeneral(FormDto dto) {
        utils.click(btnGeneral);

        // change Title and Description
        utils.clickOnNumberElement(btnExpand, 1);
        utils.input(inTitle, dto.getTitlePage());
        utils.input(inDescription, dto.getDescriptionPage());

        // change TimeZone
        utils.clickOnNumberElement(btnExpand, 2);
        utils.selectOption(inTimezone, dto.getTimeZone());

        // change Social MEdia
        utils.clickOnNumberElement(btnExpand, 7);
        utils.input(inTwitterProfile, dto.getTwitter());

    }


    /**
     * Save
     */
    public Boolean saveConfiguration(){
        try {
            utils.click(btnSave);

            return true;
        } catch (TimeoutException var) {
            System.out.println(var);
            return false;
        }
    }



}
