package cn.bfay.map.baidu.result;

/**
 * Location.
 *
 * @author wangjiannan
 */
public class Location {
    /**
     * 纬度坐标.
     */
    private String lat;
    /**
     * 经度坐标.
     */
    private String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Location{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
