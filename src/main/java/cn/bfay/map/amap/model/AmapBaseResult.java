package cn.bfay.map.amap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AmapBaseResult.
 *
 * @author wangjiannan
 */
public class AmapBaseResult {
    /**
     * 值为0或1,0表示失败；1表示成功.
     */
    private Integer status;

    /**
     * 返回状态说明，status为0时，info返回错误原因，否则返回“OK”.
     */
    private String info;

    /**
     * 错误原因码.
     */
    @JsonProperty("infocode")
    private String infoCode;
}
