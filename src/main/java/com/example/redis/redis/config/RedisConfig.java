package com.example.redis.redis.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

@AllArgsConstructor
@Configuration
public class RedisConfig {

    /*
    * Redis Cluster 구성 설정
    * */

    private final RedisClusterConfigurationProperties clusterProperties;

    /*
    * JedisPool 관련 설정
    * @Return
    * */
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        return  new JedisPoolConfig();
    }

    /*
    * Redis Cluster 구성 설정 - Cluster 구성
    * */
    @Bean
    public RedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        return new JedisConnectionFactory(new RedisClusterConfiguration(clusterProperties.getNodes()),jedisPoolConfig);
    }

}
