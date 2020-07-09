package cn.ianzhang.automation.screenplay.util;

import io.restassured.response.Response;

public class UtaException extends RuntimeException {
    public UtaException(Exception ex) {
        super(ex);
    }

    public UtaException(Response res) {
        super("UTA failed with response " + res.prettyPrint());
    }
}
