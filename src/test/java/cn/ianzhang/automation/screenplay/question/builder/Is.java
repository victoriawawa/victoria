package cn.ianzhang.automation.screenplay.question.builder;

import cn.ianzhang.automation.data.persona.Enterprise;
import cn.ianzhang.automation.screenplay.question.IsEnterpriseSelected;

public class Is {
    public static IsEnterpriseSelected situationSelected(Enterprise enterprise){
        return new IsEnterpriseSelected(enterprise);
    }
}
