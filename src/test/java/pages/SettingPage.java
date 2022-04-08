package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import utils.GeneralUtils;

/**
 * Class with the elements Setting Page
 */
public class SettingPage {

    public By btnAdmin = By.xpath("//h6[contains(text(), 'Explore Ghost admin')]");
    public By btnConfiguration = By.xpath("//a[@href=\"#/settings/\"]");
    public By btnPages = By.xpath("//a[@href=\"#/pages/\"]");
    public By btnAvatar = By.xpath("//div[@class='pe-all']");
    public By btnSignOut = By.xpath("//a[@href=\"#/signout/\"]");

    private WebDriver driver;
    private GeneralUtils utils;


    /**
     * Class constructor
     * @param driver
     */
    public SettingPage(WebDriver driver) {
        this.driver = driver;
        utils = new GeneralUtils(this.driver);
        utils.maximize();
    }


    /**
     * Check page
     * @return check
     */
    public Boolean loadPage(){

        try {
            utils.isDisplayed(btnAdmin);
            return true;
        } catch (NoClassDefFoundError e) { }

        try {
            utils.isDisplayed(btnConfiguration);
            return true;
        }
            catch (TimeoutException e) {
            System.out.println(e);
            return false;
        }
    }


    /**
     * Design a page
     * @return
     */
    public void pageAdmin(){
        //http://localhost:2369/ghost/#/setup/done
        utils.click(btnAdmin);
    }


    /**
     * Exit
     */
    public Boolean signOut(){
        try {
            utils.click(btnAvatar);
            utils.click(btnSignOut);
            return true;
        } catch (TimeoutException var) {
            System.out.println(var);
            return false;
        }
    }


    /**
     * Click configuration button
     */
    public SettingsGeneralPage configurationOption ()  {
        utils.click(btnConfiguration);
        return new SettingsGeneralPage(driver);
    }
}
