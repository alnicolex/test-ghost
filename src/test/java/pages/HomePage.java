package pages;

import dto.FormDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GeneralUtils;

/**
 * Class with the elements and functionalities of the HOme Page
 */
public class HomePage {

    public By txtTitle = By.xpath("//h1[@class='site-title']");
    public By txtParagraph = By.xpath("//h1[@class='site-title']//following-sibling::p");
    public By txtTwitter = By.xpath("//a[@class='gh-social-twitter']");

    private WebDriver driver;
    private GeneralUtils utils;

    /**
     * Class constructor
     * @param driver
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        utils = new GeneralUtils(this.driver);
        utils.maximize();
    }


    /**
     * Check page
     * @return check
     */
    public String getTittlePage(){
        return utils.getTittle();
    }


    /**
     * get Data
     * @return
     */
    public FormDto returnData(){

        FormDto dto = new FormDto();
        dto.setTitlePage(utils.getText(txtTitle));
        dto.setDescriptionPage(utils.getText(txtParagraph));
        dto.setTwitter(utils.getTextAttribute(txtTwitter, "href"));
        return dto;
    }

}
