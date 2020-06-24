package cn.bfay.map.baidu.result;

/**
 * 地理编码返回实体.
 *
 * @author wangjiannan
 */
public class GeoResult extends BaseResult {
    private Geocoder result;

    public Geocoder getResult() {
        return result;
    }

    public void setResult(Geocoder result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "GeoResult{" +
                "result=" + result +
                '}';
    }

    public static class Geocoder {
        /**
         * 经纬度坐标.
         */
        private Location location;
        /**
         * 位置的附加信息，是否精确查找。1为精确查找，即准确打点；0为不精确，即模糊打点（模糊打点无法保证准确度，不建议使用）.
         */
        private Integer precise;
        /**
         * 可信度，描述打点准确度，大于80表示误差小于100m。该字段仅作参考，返回结果准确度主要参考precise参数.
         */
        private Integer confidence;
        /**
         * 能精确理解的地址类型，包含：UNKNOWN、国家、省、城市、区县、乡镇、村庄、道路、地产小区、商务大厦、政府机构、交叉路口、
         * 商圈、生活服务、休闲娱乐、餐饮、宾馆、购物、金融、教育、医疗 、工业园区 、旅游景点 、汽车服务、火车站、长途汽车站、
         * 桥 、停车场/停车区、港口/码头、收费区/收费站、飞机场 、机场 、收费处/收费站 、加油站、绿地、门址.
         */
        private String level;

        private String comprehension;

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public Integer getPrecise() {
            return precise;
        }

        public void setPrecise(Integer precise) {
            this.precise = precise;
        }

        public Integer getConfidence() {
            return confidence;
        }

        public void setConfidence(Integer confidence) {
            this.confidence = confidence;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getComprehension() {
            return comprehension;
        }

        public void setComprehension(String comprehension) {
            this.comprehension = comprehension;
        }

        @Override
        public String toString() {
            return "Geocoder{" +
                    "location=" + location +
                    ", precise=" + precise +
                    ", confidence=" + confidence +
                    ", level='" + level + '\'' +
                    ", comprehension='" + comprehension + '\'' +
                    '}';
        }
    }
}