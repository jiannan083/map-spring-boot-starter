package cn.bfay.map.amap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherInfoResult extends AmapBaseResult {
    /**
     * 实况天气数据信息.
     */
    private List<Live> lives;
    /**
     * 预报天气信息数据.
     */
    private List<Forecast> forecasts;

    /**
     * 实况天气数据信息.
     */
    public static class Live {
        /**
         * 省份名.
         */
        private String province;
        /**
         * 城市名.
         */
        private String city;
        /**
         * 区域编码.
         */
        private String adcode;
        /**
         * 天气现象，天气现象对应描述.
         */
        private String weather;
        /**
         * 实时气温，单位：摄氏度.
         */
        private String temperature;
        /**
         * 风向，风向编码对应描述.
         */
        @JsonProperty("winddirection")
        private String windDirection;
        /**
         * 风力，此处返回的是风力编码，风力编码对应风力级别，单位：级.
         */
        @JsonProperty("windpower")
        private String windPower;
        /**
         * 空气湿度.
         */
        private String humidity;
        /**
         * 数据发布的时间,2017-07-27 17:00:00.
         */
        @JsonProperty("reporttime")
        private String reportTime;
    }

    /**
     * 预报天气信息数据.
     */
    public static class Forecast {
        /**
         * 城市名称.
         */
        private String city;
        /**
         * 城市编码.
         */
        private String adcode;
        /**
         * 省份名称.
         */
        private String province;
        /**
         * 预报发布时间.
         */
        @JsonProperty("reporttime")
        private String reportTime;
        /**
         * 预报数据list结构，元素cast,按顺序为当天、第二天、第三天的预报数据.
         */
        private List<Cast> casts;
    }

    /**
     * 预报数据.
     */
    public static class Cast {
        /**
         * 日期.
         */
        private String date;
        /**
         * 星期几.
         */
        private String week;
        /**
         * 白天天气现象.
         */
        @JsonProperty("dayweather")
        private String dayWeather;
        /**
         * 晚上天气现象.
         */
        @JsonProperty("nightweather")
        private String nightWeather;
        /**
         * 白天温度.
         */
        @JsonProperty("daytemp")
        private String dayTemp;
        /**
         * 晚上温度.
         */
        @JsonProperty("nighttemp")
        private String nightTemp;
        /**
         * 白天风向.
         */
        @JsonProperty("daywind")
        private String dayWind;
        /**
         * 晚上风向.
         */
        @JsonProperty("nightwind")
        private String nightWind;
        /**
         * 白天风力.
         */
        @JsonProperty("daypower")
        private String dayPower;
        /**
         * 晚上风力.
         */
        @JsonProperty("nightpower")
        private String nightPower;
    }
}
