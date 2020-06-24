package test;

import cn.bfay.map.baidu.BaiduMapUtils;
import cn.bfay.map.baidu.result.GeoResult;
import cn.bfay.map.baidu.result.IpResult;
import cn.bfay.map.baidu.result.RegeoResult;
import org.junit.Test;

/**
 * MapTest.
 *
 * @author wangjiannan
 */
public class MapTest {

    @Test
    public void testBaiduMap() {
        BaiduMapUtils baiduMapUtils = new BaiduMapUtils("0HhB2HGISuj8bj2755IFuzL7GGcPpdGc");
        testGeocoder(baiduMapUtils);
        testRegeocoder(baiduMapUtils);
        testIp(baiduMapUtils);

    }

    private void testGeocoder(BaiduMapUtils baiduMapUtils) {
        GeoResult baiduGeoResult1 = baiduMapUtils.geocoder("河南省焦作");
        System.out.println("----" + baiduGeoResult1);
        //System.out.println("----" + baiduGeoResult1.getResult().getLocation().toString());

        GeoResult baiduGeoResult2 = baiduMapUtils.geocoder("北京市海淀区中关村", "北京市");
        System.out.println("----" + baiduGeoResult2);
        //System.out.println("----" + baiduGeoResult2.getResult().getLocation().toString());
    }

    private void testRegeocoder(BaiduMapUtils baiduMapUtils) {
        RegeoResult baiduRegeoResult = baiduMapUtils.regeocoder("116.4136103013", "39.9110666857");
        System.out.println("----" + baiduRegeoResult);
        //System.out.println("----" + baiduRegeoResult.getResult().getAddressComponent().toString());
    }

    private void testIp(BaiduMapUtils baiduMapUtils) {
        IpResult baiduIpResult1 = baiduMapUtils.ip();
        System.out.println("----" + baiduIpResult1);
        IpResult baiduIpResult2 = baiduMapUtils.ip("180.76.180.175");
        System.out.println("----" + baiduIpResult2);
    }


    // ----- amap ----
    //@Test
    //public void testGeocode() {
    //    GeocodeResult geocodeResult1 = amapService.geocode("北京市海淀区中关村");
    //    System.out.println("---------------" + geocodeResult1);
    //    GeocodeResult geocodeResult2 = amapService.geocode("河南省焦作", "焦作");
    //    System.out.println("---------------" + geocodeResult2);
    //}
    //
    //@Test
    //public void testRegeocode() {
    //    RegeocodeResult regeocodeResult = amapService.regeocode("116.4136103013", "39.9110666857");
    //    System.out.println("---------------" + regeocodeResult);
    //}

}
