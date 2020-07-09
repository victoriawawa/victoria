package cn.ianzhang.automation.screenplay.task;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;


public class ClickNextButton extends BaseTask implements Task {

    Target NEXT_PAGE_BUTTON = Target.the("下一页")
             .locatedBy("//*[@id=\"root\"]/div/form/div[5]/button");


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on()
        );
    }
}
