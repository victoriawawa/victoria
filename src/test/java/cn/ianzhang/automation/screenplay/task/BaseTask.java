package cn.ianzhang.automation.screenplay.task;


import cn.ianzhang.automation.TestConfig;
import cn.ianzhang.automation.screenplay.util.UtaException;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.function.Function;

@ContextConfiguration(classes = TestConfig.class)

public abstract class BaseTask {


    Function<Response, Response> utaHandlerForJson = r -> {
        if (r.statusCode() != 200) {
            throw new UtaException(r);
        }
        Serenity.recordReportData().withTitle("UTA").andContents(r.prettyPrint());
        return r.prettyPeek();
    };

    Function<Response, Response> utaHandlerForBin = r -> {
        if (r.statusCode() != 200) {
            throw new UtaException(r);
        }
        return r;
    };
}
