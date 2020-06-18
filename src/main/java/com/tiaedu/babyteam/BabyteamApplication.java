package com.tiaedu.babyteam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("com.tiaedu.babyteam") //mybatis在SpringBoot启动的时候自动扫描mybatis实现的接口
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600) //RedisSession启用
public class BabyteamApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabyteamApplication.class, args);
	}
}
