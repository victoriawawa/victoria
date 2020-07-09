package cn.ianzhang.automation;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        //features = "classpath:features/capabilities/homesis.scenario/registration/MerchantOpening.feature",
        features = "classpath:features",
        glue = { "cn.ianzhang.automation.stepdefinitions" },
        strict = true
)
public class CucumberTestSuite {

}
