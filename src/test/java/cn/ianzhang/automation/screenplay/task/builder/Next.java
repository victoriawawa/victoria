package cn.ianzhang.automation.screenplay.task.builder;

import cn.ianzhang.automation.screenplay.task.ClickNextButton;
import net.serenitybdd.screenplay.Tasks;

public class Next {

    public static ClickNextButton clickNextButton(){
        return Tasks.instrumented(ClickNextButton.class);
    }
}
