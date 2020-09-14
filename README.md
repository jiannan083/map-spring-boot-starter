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
Step 3. "application.properties" use  
```
bfay.map.baidu-key=
bfay.map.amap-key=
```
## 2.1.0
基于springboot 2.3.2.RELEASE  

百度：  
百度地图开放平台 --> 开发文档 --> 服务接口 --> Web服务API  
1.地理编码 --> 基于V3.0  
2.全球逆地理编码 --> 基于V3.0  
3.普通IP定位  

高德：暂时不支持  