package cn.bfay.map.baidu;

import cn.bfay.map.baidu.result.GeoResult;
import cn.bfay.map.baidu.result.IpResult;
import cn.bfay.map.baidu.result.RegeoResult;
import cn.bfay.okhttp.OkHttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法实现.
 *
 * @author wangjiannan
 */
public class BaiduMapUtils {
    private static final Logger logger = LoggerFactory.getLogger(BaiduMapUtils.class);

    private String baiduKey;

    public BaiduMapUtils(String baiduKey) {
        this.baiduKey = baiduKey;
    }

    // 地理编码
    // http://api.map.baidu.com/geocoding/v3/?address=北京市海淀区上地十街10号&output=json&ak=您的ak&callback=showLocation //GET请求
    private static final String GEOCODING_URL = "http://api.map.baidu.com/geocoding/v3/";
    // 全球逆地理编码
    // http://api.map.baidu.com/reverse_geocoding/v3/?ak=您的ak&output=json&coordtype=wgs84ll&location=31.225696563611,121.49884033194  //GET请求
    private static final String REVERSE_GEOCODING_URL = "http://api.map.baidu.com/reverse_geocoding/v3/";
    private static final String IP_URL = "https://api.map.baidu.com/location/ip";
    private static final String OUTPUT = "json";

    /**
     * 根据结构化地理位置获取经纬度.
     *
     * @param address 地址.
     * @param city    城市(非必须).
     * @return {@link GeoResult}
     */
    public GeoResult geocoder(String address, String city) {
        Assert.hasLength(address, "地址信息不能为为空");
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("address", address);
        if (city != null) {
            paramMap.put("city", city);
        }
        return transResult(GEOCODING_URL, paramMap, GeoResult.class);
    }

    /**
     * 根据结构化地理位置获取经纬度.
     *
     * @param address 地址.
     * @return {@link GeoResult}
     */
    public GeoResult geocoder(String address) {
        return geocoder(address, null);
    }

    /**
     * 根据经纬度解析结构化地理位置.
     *
     * @param lng 经度.
     * @param lat 维度.
     * @return {@link RegeoResult}
     */
    public RegeoResult regeocoder(String lng, String lat) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("location", lat + "," + lng);
        return transResult(REVERSE_GEOCODING_URL, paramMap, RegeoResult.class);
    }

    /**
     * 普通ip定位,用户上网的IP地址，请求中如果不出现或为空，会针对发来请求的IP进行定位.
     *
     * @param ip ip
     * @return {@link IpResult}
     */
    public IpResult ip(String ip) {
        Map<String, String> paramMap = new HashMap<>();
        if (ip != null) {
            paramMap.put("ip", ip);
        }
        paramMap.put("coor", "BD09ll");
        return transResult(IP_URL, paramMap, IpResult.class);
    }

    /**
     * 普通ip定位,用户上网的IP地址，请求中如果不出现或为空，会针对发来请求的IP进行定位.
     *
     * @return {@link IpResult}
     */
    public IpResult ip() {
        return ip(null);
    }


    private <T> T transResult(String url, Map<String, String> paramMap, Class<T> tclass) {
        paramMap.put("ak", baiduKey);
        paramMap.put("output", OUTPUT);
        T t = OkHttpUtils.executeGet(url, paramMap, tclass);
        try {
            if (t == null || !(t.getClass().getMethod("getStatus").invoke(t).toString()).equals("0")) {
                throw new RuntimeException(t == null ? "返回结果为null" : t.toString());
            }
        } catch (Exception e) {
            logger.error("" + e);
            return null;
        }
        return t;
    }

}
