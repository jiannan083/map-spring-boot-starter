package cn.bfay.map.baidu.result;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 逆地理编码返回实体.
 *
 * @author wangjiannan
 */
public class RegeoResult extends BaseResult {
    private Regeocoder result;

    public Regeocoder getResult() {
        return result;
    }

    public void setResult(Regeocoder result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RegeoResult{" +
                "result=" + result +
                '}';
    }

    public static class Regeocoder {
        /**
         * 经纬度坐标.
         */
        private Location location;
        /**
         * 结构化地址信息.
         */
        @JsonProperty("formatted_address")
        private String formattedAddress;
        /**
         * 所在商圈信息.
         */
        private String business;
        /**
         * addressComponent（注意，国外行政区划，字段仅代表层级）.
         */
        private AddressComponent addressComponent;
        /**
         * 周边poi数组.
         */
        private List<Poi> pois;
        /**
         * poiRegions.
         */
        private List<PoiRegion> poiRegions;
        /**
         * 当前位置结合POI的语义化结果描述.
         */
        @JsonProperty("sematic_description")
        private String sematicDescription;
        /**
         * 百度定义的城市id（正常更新与维护，但建议使用adcode）.
         */
        private Integer cityCode;

        private List<Object> roads;

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public String getFormattedAddress() {
            return formattedAddress;
        }

        public void setFormattedAddress(String formattedAddress) {
            this.formattedAddress = formattedAddress;
        }

        public String getBusiness() {
            return business;
        }

        public void setBusiness(String business) {
            this.business = business;
        }

        public AddressComponent getAddressComponent() {
            return addressComponent;
        }

        public void setAddressComponent(AddressComponent addressComponent) {
            this.addressComponent = addressComponent;
        }

        public List<Poi> getPois() {
            return pois;
        }

        public void setPois(List<Poi> pois) {
            this.pois = pois;
        }

        public List<PoiRegion> getPoiRegions() {
            return poiRegions;
        }

        public void setPoiRegions(List<PoiRegion> poiRegions) {
            this.poiRegions = poiRegions;
        }

        public String getSematicDescription() {
            return sematicDescription;
        }

        public void setSematicDescription(String sematicDescription) {
            this.sematicDescription = sematicDescription;
        }

        public Integer getCityCode() {
            return cityCode;
        }

        public void setCityCode(Integer cityCode) {
            this.cityCode = cityCode;
        }

        public List<Object> getRoads() {
            return roads;
        }

        public void setRoads(List<Object> roads) {
            this.roads = roads;
        }

        @Override
        public String toString() {
            return "Regeocoder{" +
                    "location=" + location +
                    ", formattedAddress='" + formattedAddress + '\'' +
                    ", business='" + business + '\'' +
                    ", addressComponent=" + addressComponent +
                    ", pois=" + pois +
                    ", poiRegions=" + poiRegions +
                    ", sematicDescription='" + sematicDescription + '\'' +
                    ", cityCode=" + cityCode +
                    ", roads=" + roads +
                    '}';
        }
    }

    public static class AddressComponent {
        /**
         * 国家.
         */
        private String country;
        /**
         * 省名.
         */
        private String province;
        /**
         * 城市名.
         */
        private String city;

        @JsonProperty("city_level")
        private String cityLevel;
        /**
         * 区县名.
         */
        private String district;
        /**
         * 乡镇名.
         */
        private String town;
        /**
         * 街道名.
         */
        private String street;
        /**
         * 街道门牌号
         */
        @JsonProperty("street_number")
        private String streetNumber;
        /**
         * 行政区划代码.
         */
        private Integer adcode;
        /**
         * 国家code.
         */
        @JsonProperty("country_code")
        private Integer countryCode;

        @JsonProperty("country_code_iso")
        private String countryCodeIso;

        @JsonProperty("country_code_iso2")
        private String countryCodeIso2;
        /**
         * 和当前坐标点的方向，当有门牌号的时候返回数据.
         */
        private String direction;
        /**
         * 和当前坐标点的距离，当有门牌号的时候返回数据.
         */
        private String distance;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityLevel() {
            return cityLevel;
        }

        public void setCityLevel(String cityLevel) {
            this.cityLevel = cityLevel;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getTown() {
            return town;
        }

        public void setTown(String town) {
            this.town = town;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getStreetNumber() {
            return streetNumber;
        }

        public void setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
        }

        public Integer getAdcode() {
            return adcode;
        }

        public void setAdcode(Integer adcode) {
            this.adcode = adcode;
        }

        public Integer getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(Integer countryCode) {
            this.countryCode = countryCode;
        }

        public String getCountryCodeIso() {
            return countryCodeIso;
        }

        public void setCountryCodeIso(String countryCodeIso) {
            this.countryCodeIso = countryCodeIso;
        }

        public String getCountryCodeIso2() {
            return countryCodeIso2;
        }

        public void setCountryCodeIso2(String countryCodeIso2) {
            this.countryCodeIso2 = countryCodeIso2;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "AddressComponent{" +
                    "country='" + country + '\'' +
                    ", province='" + province + '\'' +
                    ", city='" + city + '\'' +
                    ", cityLevel='" + cityLevel + '\'' +
                    ", district='" + district + '\'' +
                    ", town='" + town + '\'' +
                    ", street='" + street + '\'' +
                    ", streetNumber='" + streetNumber + '\'' +
                    ", adcode=" + adcode +
                    ", countryCode=" + countryCode +
                    ", countryCodeIso='" + countryCodeIso + '\'' +
                    ", countryCodeIso2='" + countryCodeIso2 + '\'' +
                    ", direction='" + direction + '\'' +
                    ", distance='" + distance + '\'' +
                    '}';
        }
    }

    public static class Poi {
        /**
         * 地址信息.
         */
        private String addr;

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        @Override
        public String toString() {
            return "Poi{" +
                    "addr='" + addr + '\'' +
                    '}';
        }
    }

    public static class PoiRegion {
        /**
         * 归属区域面名称.
         */
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "PoiRegion{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
