package cn.ianzhang.automation.screenplay.question;


import cn.ianzhang.automation.data.persona.Enterprise;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


@RequiredArgsConstructor
public class IsEnterpriseSelected implements Question<Boolean> {

    private final Enterprise enterprise;

    public static final Target CURRENT_ENTERPRISE_SITUATION = Target.the("请选择贵单位情况")
            .located(By.className("other-choice-option-name"));

    @Override
    public Boolean answeredBy(Actor actor) {
        return CURRENT_ENTERPRISE_SITUATION.resolveFor(actor).getText().equals(enterprise.getSituation());
    }
}
