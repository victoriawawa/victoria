package cn.ianzhang.automation.screenplay.task;

import cn.ianzhang.automation.data.persona.Enterprise;
import cn.ianzhang.automation.screenplay.question.builder.Is;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;

@RequiredArgsConstructor
public class SelectEnterpriseSituation extends BaseTask implements Task {


    private Enterprise enterprise = Enterprise.builder().build();

    public SelectEnterpriseSituation as(Enterprise enterprise){
        this.enterprise = enterprise;
        return this;
    }

    public SelectEnterpriseSituation any(){
        return this;
    }
    Target selectSituation = Target.the(enterprise.toString()).locatedBy(
            String.format("//*[@id=\"root\"]/div/form/div[3]/div/div[2]/div/div[2]/div/div/span/div/div[2]/div/div/label/span[2]/span"));

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(Is.situationSelected(enterprise))
                .otherwise(Click.on(selectSituation))
        );
    }
}
