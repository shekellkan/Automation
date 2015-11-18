package common;

import framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/17/15
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Utils {
    public static WebDriver driver = DriverManager.getInstance().getWebDriver();
    public static boolean isElementPresent(By byElement) {
        try {
            driver.findElement(byElement);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static Boolean waitElementIsRemoved(By element){
        Boolean elementFind;
        do{
            elementFind = isElementPresent(element);
        }while (elementFind == Boolean.TRUE);
        return elementFind;
    }

}
