package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({"system:properties",
        "classpath:${environment}.properties"})
public interface DriverConfig extends Config {

    @Key("web.remote")
    boolean isRemote();

    @Key("web.url")
    String getUrl();

    @Key("web.browser")
    String getBrowser();

    @Key("web.browser.version")
    String getBrowserVersion();

}
