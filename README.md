# map-spring-boot-starter
## 使用方法：  
Step 1. Add the JitPack repository to your build file  
```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories> 
```
Step 2. Add the dependency  
```
	<dependency>
	    <groupId>com.github.jiannan083</groupId>
	    <artifactId>map-spring-boot-starter</artifactId>
	    <version>Tag</version>
	</dependency>
```
## 2.0.2
基于springboot 2.1.6.RELEASE  

百度  
百度地图开放平台 --> 开发文档 --> 服务接口 --> Web服务API  
1.key属性配置：bfay.map.baidu.key=  
2.地理编码 --> 基于V3.0  
3.全球逆地理编码 --> 基于V3.0  
4.普通IP定位  

高德：暂时不支持  
1.key属性配置：bfay.map.amap.key=