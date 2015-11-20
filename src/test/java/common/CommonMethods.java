package common;

import ui.pages.MainPage;

/**
 * Created by silvia valencia on 11/9/2015.
 */
public class CommonMethods {
    public static MainPage mainPage;
    /**
     * Log outs from the web app
     */
    public static void logOut() {
        mainPage = new MainPage();
        mainPage.logout();
    }
}
