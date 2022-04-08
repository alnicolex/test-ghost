package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * Selenium web driver overview class
 */
public class GeneralUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Class constructor
     * @param driver
     */
    public GeneralUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    /**
     * Check element
     * @param locator
     * @return
     */
    public Boolean isDisplayed(By locator){
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            return this.driver.findElement(locator).isDisplayed();
        } catch (TimeoutException var) {
            return false;
        }
    }

    /**
     * Enter value
     * @param locator
     * @param inputText
     */
    public void input(By locator, String inputText) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        waitforloadElement(locator);
        waitForSeconds();
        driver.findElement(locator).clear();

        WebElement toClear = driver.findElement(locator);
        toClear.sendKeys(Keys.CONTROL + "a");
        toClear.sendKeys(Keys.DELETE);

        driver.findElement(locator).sendKeys(inputText);
    }


    /**
     * get Text field
     * @param locator
     * @return
     */
    public String getText(By locator) {
        waitforloadElement(locator);
        waitForSeconds();
        return this.driver.findElement(locator).getText();
    }


    /**
     * get text attribute
     * @param locator
     * @param tag
     * @return
     */
    public String getTextAttribute(By locator, String tag) {
        waitforloadElement(locator);
        return this.driver.findElement(locator).getAttribute(tag);
    }

    /**
     * get tittle
     * @return
     */
    public String getTittle() {
        return this.driver.getTitle();
    }

    /**
     * Click elemento web
     * @param locator
     */
    public void click(By locator) {
        waitforloadElement(locator);
        this.driver.findElement(locator).click();
        waitForSeconds();
    }


    /**
     * Click elemento web
     * @param element
     */
    public void click(WebElement element) {
        try {
            WebDriverWait waitClick = new WebDriverWait(this.driver, 10);
            waitClick.until(ExpectedConditions.visibilityOf(element));
            waitClick.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (StaleElementReferenceException var4) {
            WebDriverWait waitClick = new WebDriverWait(this.driver, 10);
            waitClick.until(ExpectedConditions.visibilityOf(element));
            waitClick.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
        waitForSeconds();
    }


    /**
     * Maximize display
     */
    public void maximize() {
        this.driver.manage().window().maximize();
    }


    /**
     * Wait for 2 seconds
     */
    public void waitForSeconds() {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, 2L, 1L);
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
        }
    }


    /**
     * Select list option
     * @param locator
     * @param optionSelect
     */
    public void selectOption(By locator, String optionSelect) {
        waitforloadElement(locator);
        this.click(locator);
        String xpathExpression = "//option[text()='" + optionSelect + "']";
        WebElement list = driver.findElement(locator);
        waitforloadElement(By.xpath(xpathExpression));
        WebElement option = list.findElement(By.xpath(xpathExpression));
        this.click(option);
        waitForSeconds();
    }


    /**
     * Wait for load element
     * @param locator
     */
    public void waitforloadElement(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    /**
     * Click on number of elements
     * @param item
     */
    public void clickOnNumberElement(By locator, int item){
        List<WebElement> elements = findElements(locator);
        int n = 1;
        for (WebElement e : elements)
        {
            if(n == item){
                e.click();
                break;
            }
            n = n + 1;
        }
    }


    /**
     * Return list of elements
     * @param locator
     * @return
     */
    public List<WebElement> findElements(By locator) {
        return this.driver.findElements(locator);
    }

}
