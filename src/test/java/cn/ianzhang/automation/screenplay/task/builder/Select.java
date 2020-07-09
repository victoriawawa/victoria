package cn.ianzhang.automation.screenplay.task.builder;

import cn.ianzhang.automation.screenplay.task.SelectEnterpriseSituation;
import net.serenitybdd.screenplay.Tasks;

public class Select {
    public static SelectEnterpriseSituation enterprise(){
        return Tasks.instrumented(SelectEnterpriseSituation.class);
    }
}
