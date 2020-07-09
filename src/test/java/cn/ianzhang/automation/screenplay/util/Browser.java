package cn.ianzhang.automation.screenplay.util;

public enum Browser {
    CHROME("chrome"),
    FIREFOX("firefox"),
    GHOST_DRIVER("phantomjs"),
    INTERNET_EXPLORER("internet explorer"),
    OPERA("opera"),
    SAFARI("safari"),
    PERFECTO_MOBILE("perfectoMobile"),
    PERFECTO_MOBILE_OS("mobileOS"),
    PERFECTO_MOBILE_DEFAULT("mobileDefault"),
    PERFECTO_MOBILE_CHROME("mobileChrome"),
    PERFECTO_MOBILE_SAFARI("mobileSafari");

    private String value;

    private Browser(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
