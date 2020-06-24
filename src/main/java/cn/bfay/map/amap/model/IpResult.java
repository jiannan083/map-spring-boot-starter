package cn.bfay.map.amap.model;

/**
 * amap ip定位返回结果.
 */
public class IpResult extends AmapBaseResult {
    /**
     * 省份名称,若为直辖市则显示直辖市名称；如果在局域网 IP网段内，则返回“局域网”；非法IP以及国外IP则返回空.
     */
    private String province;

    /**
     * 城市名称,若为直辖市则显示直辖市名称；如果为局域网网段内IP或者非法IP或国外IP，则返回空.
     */
    private String city;

    /**
     * 城市的adcode编码.
     */
    private String adcode;

    /**
     * 所在城市矩形区域范围,所在城市范围的左下右上对标对.
     */
    private String rectangle;
}
