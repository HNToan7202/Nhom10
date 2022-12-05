package vn.iotstar.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfiguration {

	private final String host = "";
	private final Integer port = null;
	private final Jedis jedis = null;

	@Data
	public class Jedis {
		private final Pool pool = null;
		
		public Pool getPool() {
			return pool;
		}


		@Data
		public class Pool {
			private final Integer maxActive = null;
			private final Integer maxIdle = null;
			private final Integer minIdle = null;
			public Integer getMaxActive() {
				return maxActive;
			}
			public Integer getMaxIdle() {
				return maxIdle;
			}
			public Integer getMinIdle() {
				return minIdle;
			}
			
			
		}
	}

	public String getHost() {
		return host;
	}

	public Integer getPort() {
		return port;
	}

	public Jedis getJedis() {
		return jedis;
	}
	
	
}