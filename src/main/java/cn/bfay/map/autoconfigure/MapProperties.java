package cn.bfay.map.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * MapProperties.
 *
 * @author wangjiannan
 */
@ConfigurationProperties(prefix = "bfay.map")
public class MapProperties {

    private String baiduKey = "";

    private String amapKey = "";

    public String getBaiduKey() {
        return baiduKey;
    }

    public void setBaiduKey(String baiduKey) {
        this.baiduKey = baiduKey;
    }

    public String getAmapKey() {
        return amapKey;
    }

    public void setAmapKey(String amapKey) {
        this.amapKey = amapKey;
    }
}
