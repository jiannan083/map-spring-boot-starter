package cn.bfay.map.amap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * amap 地理编码返回结果.
 */
public class GeocodeResult extends AmapBaseResult {
    /**
     * 地理编码信息列表,结果对象列表
     */
    private List<Geocode> geocodes;

    public static class Geocode {
        /**
         * 结构化地址信息,省份＋城市＋区县＋城镇＋乡村＋街道＋门牌号码.
         */
        @JsonProperty("formatted_address")
        private String formattedAddress;
        /**
         * 地址所在的省份名,例如：北京市。此处需要注意的是，中国的四大直辖市也算作省级单位.
         */
        private String province;
        /**
         * 地址所在的城市名,例如：北京市.
         */
        private String city;
        /**
         * 城市编码,例如：010.
         */
        @JsonProperty("citycode")
        private String cityCode;
        /**
         * 地址所在的区,例如：朝阳区.
         */
        private Object district;
        /**
         * 地址所在的乡镇,例如：庞各庄镇.
         */
        private Object township;
        /**
         * 街道,例如：阜通东大街.
         */
        private Object street;
        /**
         * 门牌,例如：6号.
         */
        private Object number;
        /**
         * 区域编码,例如：110101.
         */
        private String adcode;
        /**
         * 坐标点,经度，纬度.
         */
        private String location;
        /**
         * 匹配级别.
         */
        private String level;
    }
}
