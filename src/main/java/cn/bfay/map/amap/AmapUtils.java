package cn.bfay.map.amap;

import cn.bfay.okhttp.OkHttpUtils;
import cn.bfay.map.amap.model.GeocodeResult;
import cn.bfay.map.amap.model.IpResult;
import cn.bfay.map.amap.model.RegeocodeResult;
import cn.bfay.map.amap.model.WeatherInfoResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法实现.
 *
 * @author wangjiannan
 */
public class AmapUtils {
    private static final Logger log = LoggerFactory.getLogger(AmapUtils.class);

    private String amapKey = "";

    public void setAmapKey(String amapKey) {
        this.amapKey = amapKey;
    }

    private static final String GEO_URL = "https://restapi.amap.com/v3/geocode/geo";
    private static final String REGEO_URL = "https://restapi.amap.com/v3/geocode/regeo";
    private static final String IP_URL = "https://restapi.amap.com/v3/ip";
    private static final String WEATHER_URL = "https://restapi.amap.com/v3/weather/weatherInfo";
    private static final String OUTPUT = "JSON";

    /**
     * 地理编码.
     *
     * @param address 结构化地址信息,规则遵循：国家、省份、城市、区县、城镇、乡村、街道、
     *                门牌号码、屋邨、大厦，如：北京市朝阳区阜通东大街6号.
     * @param city    指定查询的城市,可选输入内容包括：指定城市的中文（如北京）、指定城市的中文全拼（beijing）、
     *                citycode（010）、adcode（110000）。当指定城市查询内容为空时，会进行全国范围内的地址转换检索。
     *                可选/无，会进行全国范围内搜索.
     * @return {@link GeocodeResult}
     */
    public GeocodeResult geocode(String address, String city) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("url", GEO_URL);
        paramMap.put("address", address);
        if (city != null) {
            paramMap.put("city", city);
        }
        return process(paramMap, GeocodeResult.class);
    }

    /**
     * 地理编码.
     *
     * @param address 结构化地址信息,规则遵循：国家、省份、城市、区县、城镇、乡村、街道、
     *                门牌号码、屋邨、大厦，如：北京市朝阳区阜通东大街6号.
     * @return {@link GeocodeResult}
     */
    public GeocodeResult geocode(String address) {
        return geocode(address, null);
    }

    /**
     * 逆地理编码.
     *
     * @param lng 经度坐标.
     * @param lat 纬度坐标,传入内容规则：经度在前，纬度在后，经纬度间以“,”分割，经纬度小数点后不要超过 6 位.
     * @return {@link RegeocodeResult}
     */
    public RegeocodeResult regeocode(String lng, String lat) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("url", REGEO_URL);
        paramMap.put("location", lng + "," + lat);
        return process(paramMap, RegeocodeResult.class);
    }

    /**
     * ip定位.
     *
     * @param ip ip地址,需要搜索的IP地址（仅支持国内）若用户不填写IP，则取客户http之中的请求来进行定位.
     * @return {@link IpResult}
     */
    public IpResult ip(String ip) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("url", IP_URL);
        if (ip != null) {
            paramMap.put("ip", ip);
        }
        return process(paramMap, IpResult.class);
    }

    /**
     * ip定位.
     *
     * @return {@link IpResult}
     */
    public IpResult ip() {
        return ip(null);
    }


    /**
     * 天气查询,base:返回实况天气.
     *
     * @param city 城市名称,输入adcode.
     * @return {@link WeatherInfoResult}
     */
    public WeatherInfoResult weatherInfoBase(String city) {
        return weatherInfo(city, "base");
    }

    /**
     * 天气查询,all:返回预报天气.
     *
     * @param city 城市名称,输入adcode.
     * @return {@link WeatherInfoResult}
     */
    public WeatherInfoResult weatherInfoAll(String city) {
        return weatherInfo(city, "all");
    }

    private WeatherInfoResult weatherInfo(String city, String extensions) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("url", WEATHER_URL);
        paramMap.put("city", city);
        paramMap.put("extensions", extensions);
        return process(paramMap, WeatherInfoResult.class);
    }


    private <T> T process(Map<String, String> paramMap, Class<T> tClass) {
        paramMap.put("key", amapKey);
        paramMap.put("output", OUTPUT);
        String url = paramMap.get("url").toString();
        paramMap.remove("url");
        return OkHttpUtils.executeGet(url, paramMap, tClass);
    }

}

