package test;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dto.FormDto;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.*;
import utils.VideoRecorderUtilitis;

import java.util.List;
import java.util.Map;

/**
 * Class pet appointment scheduling
 */
public class ManagementAppTest {

    private WebDriver driver;
    private CreateAccountPage pageAdministrator;
    private SignInPage pageSignIn;
    private SettingPage pageSetting;
    private SettingsGeneralPage pageSettingGeneral;
    private HomePage homePage;
    private FormDto formDto;


    @Before
    /**
     *  Instance Webdriver
     */
    public void starTest(){

        // Chrome
        try {
            WebDriverManager.chromedriver().setup();
            createObject();
            return;
        } catch (NoClassDefFoundError e) { }

        // Safari
        try {
            WebDriverManager.safaridriver().setup();
            createObject();
            return;
        } catch (NoClassDefFoundError e) { }

        // Mozilla
        try {
            WebDriverManager.firefoxdriver().setup();
            createObject();
            return;
        } catch (NoClassDefFoundError e) { }

        // Edge
        try {
            WebDriverManager.edgedriver().setup();
            createObject();
            return;
        } catch (NoClassDefFoundError e) { }

    }


    /**
     * Instance pages
     */
    public void createObject(){
        driver = new ChromeDriver();
        formDto = new FormDto();
        pageAdministrator = new CreateAccountPage(driver);
    }


    @Given("User administrator accesses the portal")
    public void administratorIsInHomePage() throws Exception {
        VideoRecorderUtilitis.startRecord("Esc1-CreateAdministratorUser");
        driver.get("http://localhost:2370/ghost/#/setup");
    }


    @When("Registration page is displayed")
    public void registerPageAvailable() throws Exception {
        try{
            Assert.assertTrue(pageAdministrator.loadPage(), "Error home page not available");
        } catch (AssertionError e)
        {
            pageSignIn = new SignInPage(driver);
            administratorPageAvailable();
            System.out.println("registered user ");
            endTest();
        }

    }


    @When("User enters the following information the register")
    public void enterInformation(DataTable dataTable) {
        List<Map<String, String>> form = dataTable.asMaps(String.class, String.class);

        formDto.setSiteTitle(form.get(0).get("siteTitle"));
        formDto.setFullName(form.get(0).get("fullName"));
        formDto.setEmail(form.get(0).get("email"));
        formDto.setPws(form.get(0).get("password"));
        pageAdministrator.registerData(formDto);
    }


    @When("User click the create account button")
    public void clickCreateAccount() {
        pageSetting = pageAdministrator.saveRegister();
    }


    @Then("Login to the administrator page and log out")
    public void administratorPage(){
        Assert.assertTrue(pageSetting.loadPage(), "Error administrator page not available");
        pageSetting.pageAdmin();
        pageSetting.signOut();
    }


    @Given("Administrator user accesses the portal")
    public void administratorPageSingIn() throws Exception {
        VideoRecorderUtilitis.startRecord("Esc2-ConfigureWebPlatform");
        driver.get("http://localhost:2370/ghost/#/signin");
        pageSignIn = new SignInPage(driver);
    }

    @When("Administrator page appears")
    public void administratorPageAvailable(){
        Assert.assertTrue(pageSignIn.loadPage(), "Error Sign In page not available");
    }


    @When("^User enters the following information (.*) and (.*)")
    public void theUserClickOnSearchOption(String email, String password) {
        pageSignIn.enterCredentials(email, password);
    }

    @When("User clicks on the start button")
    public void clickLogIn() {
        pageSetting = pageSignIn.login();
    }


    @When("The configuration page is displayed")
    public void administratorPageDisplayed(){
        Assert.assertTrue(pageSetting.loadPage(), "Error Setting page not available");
    }


    @When("User selects the configuration option")
    public void selectConfigurationOptions(){
        pageSettingGeneral = pageSetting.configurationOption();
        Assert.assertTrue(pageSettingGeneral.loadPage(), "Error Setting General page not available");
    }


    @When("User makes the following changes to the general settings")
    public void changeConfiguration(DataTable dataTable) {
        List<Map<String, String>> form = dataTable.asMaps(String.class, String.class);

        formDto.setTitlePage(form.get(0).get("title"));
        formDto.setDescriptionPage(form.get(0).get("description"));
        formDto.setTimeZone(form.get(0).get("timezone"));
        formDto.setTwitter(form.get(0).get("twitterProfile"));
        pageSettingGeneral.changeGeneral(formDto);
    }


    @Then("User presses the save button and exits the application")
    public void saveConfiguration() {
        pageSettingGeneral.saveConfiguration();
        pageSetting.signOut();
    }


    @Given("User accesses the portal")
    public void userIsInHomePage() throws Exception {
        VideoRecorderUtilitis.startRecord("Esc3-UserValidateData");
        driver.get("http://localhost:2370/");
        homePage = new HomePage(driver);
    }


    @Then("The user validates the following information")
    public void userCheckData(DataTable dataTable) {
        List<Map<String, String>> form = dataTable.asMaps(String.class, String.class);
        formDto = homePage.returnData();

        System.out.println(homePage.getTittlePage());
        Assert.assertEquals(formDto.getTitlePage(), form.get(0).get("title"), "Error title");
        Assert.assertEquals(formDto.getDescriptionPage(), form.get(0).get("description"), "Error paragraph");
        Assert.assertEquals(formDto.getTwitter(), form.get(0).get("twitterProfile"), "Error twitter");
    }


    @After
    public void endTest() throws Exception {
        VideoRecorderUtilitis.stopRecord();
        driver.close();
    }



}
