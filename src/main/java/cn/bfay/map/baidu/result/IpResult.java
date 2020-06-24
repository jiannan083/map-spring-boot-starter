package cn.bfay.map.baidu.result;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * IpResult.
 *
 * @author wangjiannan
 */
public class IpResult extends BaseResult {
    /**
     * 详细地址信息.
     */
    private String address;

    private Content content;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "IpResult{" +
                "address='" + address + '\'' +
                ", content=" + content +
                '}';
    }

    public static class Content {
        /**
         * 简要地址信息.
         */
        private String address;
        /**
         * addressDetail.
         */
        @JsonProperty("address_detail")
        private AddressDetail addressDetail;
        /**
         * point.
         */
        private Point point;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public AddressDetail getAddressDetail() {
            return addressDetail;
        }

        public void setAddressDetail(AddressDetail addressDetail) {
            this.addressDetail = addressDetail;
        }

        public Point getPoint() {
            return point;
        }

        public void setPoint(Point point) {
            this.point = point;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "address='" + address + '\'' +
                    ", addressDetail=" + addressDetail +
                    ", point=" + point +
                    '}';
        }
    }

    public static class AddressDetail {
        /**
         * 城市.
         */
        private String city;
        /**
         * 百度城市代码.
         */
        @JsonProperty("city_code")
        private String cityCode;
        /**
         * 区县.
         */
        private String district;
        /**
         * 省份.
         */
        private String province;
        /**
         * 街道.
         */
        private String street;
        /**
         * 门牌号.
         */
        @JsonProperty("street_number")
        private String streetNumber;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
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

        @Override
        public String toString() {
            return "AddressDetail{" +
                    "city='" + city + '\'' +
                    ", cityCode='" + cityCode + '\'' +
                    ", district='" + district + '\'' +
                    ", province='" + province + '\'' +
                    ", street='" + street + '\'' +
                    ", streetNumber='" + streetNumber + '\'' +
                    '}';
        }
    }

    public static class Point {
        /**
         * 当前城市中心点经度.
         */
        @JsonProperty("x")
        private String pointX;
        /**
         * 当前城市中心点纬度.
         */
        @JsonProperty("y")
        private String pointY;

        public String getPointX() {
            return pointX;
        }

        public void setPointX(String pointX) {
            this.pointX = pointX;
        }

        public String getPointY() {
            return pointY;
        }

        public void setPointY(String pointY) {
            this.pointY = pointY;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "pointX='" + pointX + '\'' +
                    ", pointY='" + pointY + '\'' +
                    '}';
        }
    }

}
