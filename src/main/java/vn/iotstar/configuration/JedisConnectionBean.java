package vn.iotstar.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import lombok.AllArgsConstructor;
import vn.iotstar.configuration.properties.RedisConfiguration;

@AllArgsConstructor
@EnableConfigurationProperties(RedisConfiguration.class)
public class JedisConnectionBean {

	private final RedisConfiguration redisConfiguration = new RedisConfiguration();
	private final JedisClientConfiguration jedisClientConfiguration = null;

	@Bean
	public JedisConnectionFactory connectionFactory() {
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
		configuration.setHostName(redisConfiguration.getHost());
		configuration.setPort(redisConfiguration.getPort());
		return new JedisConnectionFactory(configuration, jedisClientConfiguration);
	}

}