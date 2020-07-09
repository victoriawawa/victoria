package cn.ianzhang.automation.screenplay.util;

public class GeneralException extends RuntimeException {
    public GeneralException(Exception ex) {
        super(ex);
    }

    public GeneralException(String message) {
        super(message);
    }
}
