package com.ggf.testdemo.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggf.testdemo.service.TeacherService;
import com.ggf.testdemo.service.TeacherServiceImpl;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

/**
 * @description: 缓存配置类
 * @author: guoqiangfeng
 * @create: 2019-09-12 16:33
 */
@Configuration
@Slf4j
public class CatchConfig {

//  @Bean
//  public TeacherService teacherService() {
//    // configure and return a class having &#064;Cacheable methods
//    return new TeacherServiceImpl();
//  }

  //  @Bean
//  public CacheManager cacheManager() {
//    // configure and return an implementation of Spring's CacheManager SPI
//    SimpleCacheManager cacheManager = new SimpleCacheManager();
//    cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("default")));
//    return cacheManager;
//  }
  @Bean
  public KeyGenerator simpleKeyGenerator() {
    return (o, method, objects) -> {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(o.getClass().getSimpleName());
      stringBuilder.append(".");
      stringBuilder.append(method.getName());
      stringBuilder.append("[");
      for (Object obj : objects) {
        stringBuilder.append(obj.toString());
      }
      stringBuilder.append("]");
      log.info(stringBuilder.toString());
      return stringBuilder.toString();
    };
  }


  @Bean
  public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
    return new RedisCacheManager(
        RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory),
        this.getRedisCacheConfigurationWithTtl(60),
        this.getRedisCacheConfigurationMap()
    );
  }

  private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
    Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
    redisCacheConfigurationMap.put("teacher", this.getRedisCacheConfigurationWithTtl(300000));
//    redisCacheConfigurationMap
//        .put("UserInfoListAnother", this.getRedisCacheConfigurationWithTtl(18000));
    return redisCacheConfigurationMap;
  }


  private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds) {
    Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(
        Object.class);
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    jackson2JsonRedisSerializer.setObjectMapper(om);

    RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
    redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(
        RedisSerializationContext
            .SerializationPair
            .fromSerializer(jackson2JsonRedisSerializer)
    ).entryTtl(Duration.ofSeconds(seconds));

    return redisCacheConfiguration;
  }

}
