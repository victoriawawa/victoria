package cn.ianzhang.automation.stepdefinitions;

import cn.ianzhang.automation.screenplay.util.GeneralException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java8.En;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import java.util.Optional;

public class CucumberHooks extends BaseStepDefinition implements En {

    Logger logger = LoggerFactory.getLogger(CucumberHooks.class);

    EnvironmentVariables environmentVariables;

    @Value("${aldi.openapi.url}")
    private String openApiBaseUrl;

    @Value("${uta.api.url}")
    private String utaBaseUrl;

    @Value("${Internet.Explorer.DriverPath}")
    public static String explorerDriver;

    @Value("${Internet.Chrome.DriverPath}")
    public static String chromeDriver;

    @Value("${Internet.Gecko.DriverPath}")
    public static String geckoDriver;

    @Managed
    public WebDriver webDriver;

    private boolean useDesktopBrowser() {
        return !environmentVariables.getProperty("webdriver.driver", "").equals("appium");
    }

    /*private boolean useBrowserContainer() {
        return System.getProperty("use.browser.container", "true").equals("true") && useDesktopBrowser();
    }*/

    public CucumberHooks() {

    }

    @Before(order = 1000)
    public void startBrowser() {


        System.setProperty("webdriver.chrome.driver", chromeDriver);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

    }

    @Before(order = 1100)
    public void setStage() {
        OnStage.setTheStage(Cast.whereEveryoneCan(
                CallAnApi.at(openApiBaseUrl),
                BrowseTheWeb.with(webDriver)
        ));

    }

    @Before(order = 1200)
    public void decideTestType() {
        if (useDesktopBrowser()) {
            System.setProperty("hcc.test.type", "UI,DESKTOP,BROWSER");
        } else {
            System.setProperty("hcc.test.type", "UI,MOBILE,BROWSER");
        }
    }

    @After
    public void clearStage() {
        OnStage.drawTheCurtain();
    }

    @After
    public void stopBrowser(Scenario scenario) {
        webDriver.close();
        webDriver.quit();
    }
}
