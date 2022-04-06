package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GeneralUtils;

/**
 * Class with the elements and functionalities of the login
 */
public class SignInPage {

    public By inEmail = By.id("ember7");
    public By inPassword = By.id("ember9");
    public By btnSignin = By.id("ember11");

    private WebDriver driver;
    private GeneralUtils utils;

    /**
     * Class constructor
     * @param driver
     */
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        utils = new GeneralUtils(this.driver);
        utils.maximize();
    }


    /**
     * Check page
     * @return check
     */
    public Boolean loadPage(){
        return utils.isDisplayed(btnSignin);
    }


    /**
     * access as administrator
     * @param email
     * @param pws
     */
    public void enterCredentials(String email, String pws) {
        utils.input(inEmail, email);
        utils.input(inPassword, pws);
    }

    /**
     * Bottun login
     */
    public SettingPage login ()  {
        utils.click(btnSignin);
        return new SettingPage(driver);
    }



}
