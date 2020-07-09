package cn.ianzhang.automation.stepdefinitions;


import cn.ianzhang.automation.screenplay.task.ClickNextButton;
import cn.ianzhang.automation.screenplay.task.builder.Next;
import cn.ianzhang.automation.screenplay.task.builder.Select;
import io.cucumber.java8.En;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;

import java.time.temporal.ChronoUnit;



public class StepDefinitions extends BaseStepDefinition implements En {

    private void resetImplicitWait(Actor actor) {
        PageObject po = BrowseTheWeb.as(actor);
        po.setImplicitTimeout((int)po.getImplicitWaitTimeout().getSeconds(), ChronoUnit.SECONDS);
    }

    public StepDefinitions() {

        Given("I have open the enterprise resume work application data submission form", (Actor actor) -> {
            actor.attemptsTo(
                    Open.url("https://templates.jinshuju.net/detail/Dv9JPD")
            );
        });

        And("I have chosen to Continuous production/start-up enterprises and institutions in the options group$", (Actor actor) -> {

            actor.attemptsTo(
                    Select.enterprise().any()
            );
        });

        When("I click the next page button", (Actor actor) -> {
           actor.attemptsTo(
                   Next.clickNextButton()
           );

        });



        Then("The page will redirect to the specified address", (Actor actor) -> {


        });



    }
}
