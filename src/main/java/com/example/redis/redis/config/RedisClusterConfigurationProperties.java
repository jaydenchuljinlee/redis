package com.example.redis.redis.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;


@Getter @Setter
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class RedisClusterConfigurationProperties {

    /*
    * spring.redis.cluster.nodes[0]=127.0.0.1:6379
    * spring.redis.cluster.nodes[0]=127.0.0.1:6380
    * spring.redis.cluster.nodes[0]=127.0.0.1:6381
    * */

    private List<String> nodes;

}
