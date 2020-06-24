package cn.bfay.map.autoconfigure;

import cn.bfay.map.baidu.BaiduMapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动化配置.
 *
 * @author wangjiannan
 */
@Configuration //开启配置
@EnableConfigurationProperties(MapProperties.class) //开启使用映射实体对象
@ConditionalOnClass(BaiduMapUtils.class) //存在class时初始化该配置类
@ConditionalOnProperty // 存在对应配置信息时初始化该配置类
        (
                prefix = "bfay.map", //存在配置前缀hello
                value = "enabled", //开启
                matchIfMissing = true //缺失检查
        )
public class MapAutoConfiguration {
    private static final Logger log = LoggerFactory.getLogger(MapAutoConfiguration.class);
    @Autowired
    private MapProperties mapProperties;

    /**
     * 百度地图.
     *
     * @return baiduMapUtils
     */
    @Bean
    @ConditionalOnMissingBean(BaiduMapUtils.class)//缺失bean时，初始化并添加到SpringIoc
    public BaiduMapUtils baiduMapUtils() {
        log.info(">>>The BaiduMapUtils Not Found，Execute Create New Bean.");
        BaiduMapUtils baiduMapUtils = new BaiduMapUtils(mapProperties.getBaiduKey());
        return baiduMapUtils;
    }


    ///**
    // * 高德地图.
    // *
    // * @return amapService
    // */
    //@Bean
    //@ConditionalOnMissingBean(AmapUtils.class)
    //public AmapUtils amapUtils() {
    //    log.info(">>>The AmapUtils Not Found，Execute Create New Bean.");
    //    AmapUtils amapUtils = new AmapUtils();
    //    amapUtils.setAmapKey(mapProperties.getAmapKey());
    //    return amapUtils;
    //}
}
