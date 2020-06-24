package cn.bfay.map.amap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * amap 逆地理编码返回结果.
 */
public class RegeocodeResult extends AmapBaseResult {
    private Regeocode regeocode;

    public static class Regeocode {
        /**
         * 结构化地址信息,结构化地址信息包括：省份＋城市＋区县＋城镇＋乡村＋街道＋门牌号码,
         * 如果坐标点处于海域范围内，则结构化地址信息为：省份＋城市＋区县＋海域信息.
         */
        @JsonProperty("formatted_address")
        private String formattedAddress;
        /**
         * 地址元素列表.
         */
        private AddressComponent addressComponent;
        /**
         * 道路信息列表,请求参数 extensions 为 all 时返回.
         */
        private List<Road> roads;
        /**
         * 道路交叉口列表,请求参数 extensions 为 all 时返回.
         */
        private List<Roadinter> roadinters;
        /**
         * poi信息列表,请求参数 extensions 为 all 时返回.
         */
        private List<Poi> pois;
        /**
         * aoi信息列表,请求参数 extensions 为 all 时返回.
         */
        private List<Aoi> aois;

        /**
         * 地址元素.
         */
        public static class AddressComponent {
            /**
             * 国家.
             */
            private String country;
            /**
             * 坐标点所在省名称,例如：北京市.
             */
            private String province;
            /**
             * 坐标点所在城市名称,当所在城市为北京、上海、天津、重庆四个直辖市时，
             * 该字段返回为空;当所在城市属于县级市的时候，此字段为空.
             */
            private String city;
            /**
             * 城市编码,例如：010.
             */
            @JsonProperty("citycode")
            private String cityCode;
            /**
             * 坐标点所在区,例如：海淀区.
             */
            private String district;
            /**
             * 行政区编码例如：110108.
             */
            private String adcode;
            /**
             * 坐标点所在乡镇/街道（此街道为社区街道，不是道路信息,例如：燕园街道.
             */
            private String township;
            /**
             * 乡镇街道编码,例如：110101001000.
             */
            @JsonProperty("towncode")
            private String townCode;
            /**
             * 社区信息.
             */
            private Neighborhood neighborhood;
            /**
             * 楼信息.
             */
            private Building building;
            /**
             * 门牌信息.
             */
            private StreetNumber streetNumber;
            /**
             * 所属海域信息.
             */
            private String seaArea;
            /**
             * 经纬度所属商圈列表.
             */
            private List<BusinessArea> businessAreas;
        }

        /**
         * 道路信息.
         */
        public static class Road {
            /**
             * 道路id.
             */
            private String id;
            /**
             * 道路名称.
             */
            private String name;
            /**
             * 道路到请求坐标的距离,单位：米.
             */
            private String distance;
            /**
             * 方位,输入点和此路的相对方位.
             */
            private String direction;
            /**
             * 坐标点.
             */
            private String location;
        }

        /**
         * 道路交叉口.
         */
        public static class Roadinter {
            /**
             * 交叉路口到请求坐标的距离,单位：米.
             */
            private String distance;
            /**
             * 方位,输入点相对路口的方位.
             */
            private String direction;
            /**
             * 路口经纬度.
             */
            private String location;
            /**
             * 第一条道路id.
             */
            @JsonProperty("first_id")
            private String firstId;
            /**
             * 第一条道路名称.
             */
            @JsonProperty("first_name")
            private String firstName;
            /**
             * 第二条道路id.
             */
            @JsonProperty("second_id")
            private String secondId;
            /**
             * 第二条道路名称.
             */
            @JsonProperty("second_name")
            private String secondName;
        }

        /**
         * poi信息列表.
         */
        public static class Poi {
            /**
             * poi的id.
             */
            private String id;
            /**
             * poi点名称.
             */
            private String name;
            /**
             * poi类型.
             */
            private String type;
            /**
             * 电话.
             */
            private String tel;
            /**
             * 该POI到请求坐标的距离,单位：米.
             */
            private String distance;
            /**
             * 方向,为输入点相对建筑物的方位.
             */
            private String direction;
            /**
             * poi地址信息.
             */
            private String address;
            /**
             * 坐标点.
             */
            private String location;
            /**
             * poi所在商圈名称.
             */
            @JsonProperty("businessarea")
            private String businessArea;
        }

        /**
         * aoi信息.
         */
        public static class Aoi {
            /**
             * 所属 aoi的id.
             */
            private String id;
            /**
             * 所属 aoi 名称.
             */
            private String name;
            /**
             * 所属 aoi 所在区域编码.
             */
            private String adcode;
            /**
             * 所属 aoi 中心点坐标.
             */
            private String location;
            /**
             * 所属aoi点面积,单位：平方米.
             */
            private String area;
        }

        /**
         * 社区信息.
         */
        public static class Neighborhood {
            /**
             * 社区名称,例如：北京大学.
             */
            private String name;
            /**
             * POI类型,例如：科教文化服务;学校;高等院校.
             */
            private String type;
        }

        /**
         * 楼信息.
         */
        public static class Building {
            /**
             * 建筑名称,例如：北京大学.
             */
            private String name;
            /**
             * 类型,例如：科教文化服务;学校;高等院校
             */
            private String type;
        }

        /**
         * 门牌信息.
         */
        public static class StreetNumber {
            /**
             * 街道名称,例如：中关村北二条.
             */
            private String street;
            /**
             * 门牌号,例如：3号.
             */
            private String number;
            /**
             * 方向,坐标点所处街道方位.
             */
            private String location;
            /**
             * 门牌地址到请求坐标的距离,单位：米.
             */
            private String direction;
            /**
             * 所属海域信息,例如：渤海.
             */
            private String distance;
        }

        /**
         * 经纬度所属商圈.
         */
        public static class BusinessArea {
            /**
             * 商圈信息。
             */
            private String businessArea;
            /**
             * 商圈中心点经纬度。
             */
            private String location;
            /**
             * 商圈名称,例如：颐和园。
             */
            private String name;
            /**
             * 商圈所在区域的adcode,例如：朝阳区/海淀区。
             */
            private String id;
        }
    }


}
