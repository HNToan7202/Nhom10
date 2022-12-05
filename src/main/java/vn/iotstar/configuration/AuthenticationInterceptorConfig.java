package vn.iotstar.configuration;
/*
 * package vn.iotstar.Config;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.web.servlet.config.annotation.InterceptorRegistry; import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 * 
 * import vn.iotstar.interceptor.AdminAuthenticationInterceptor; import
 * vn.iotstar.interceptor.SideAuthenticationInterceptor;
 * 
 * @Configuration public class AuthenticationInterceptorConfig implements
 * WebMvcConfigurer {
 * 
 * @Autowired private AdminAuthenticationInterceptor
 * adminAuthenticationInterceptor;
 * 
 * @Autowired private SideAuthenticationInterceptor
 * sideAuthenticationInterceptor;
 * 
 * @Override public void addInterceptors(InterceptorRegistry registry) {
 * registry.addInterceptor(adminAuthenticationInterceptor).addPathPatterns(
 * "/admin/**");
 * 
 * registry.addInterceptor(sideAuthenticationInterceptor).addPathPatterns(
 * "/side/**"); }
 * 
 * }
 */

/*
 * import java.time.Duration;
 * 
 * import org.apache.commons.pool2.impl.GenericObjectPoolConfig; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.data.redis.cache.RedisCacheConfiguration; import
 * org.springframework.data.redis.cache.RedisCacheManager; import
 * org.springframework.data.redis.connection.RedisStandaloneConfiguration;
 * import
 * org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
 * import
 * org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
 * import
 * org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
 * import org.springframework.data.redis.core.RedisTemplate; import
 * org.springframework.data.redis.repository.configuration.
 * EnableRedisRepositories; import
 * org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
 * import
 * org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
 * import org.springframework.data.redis.serializer.RedisSerializationContext;
 * import org.springframework.data.redis.serializer.RedisSerializer; import
 * org.springframework.data.redis.serializer.StringRedisSerializer;
 * 
 * @Configuration
 * 
 * @EnableRedisRepositories public class RedisConfig {
 * 
 * @Bean public JedisConnectionFactory connectionFactory() {
 * RedisStandaloneConfiguration configuration = new
 * RedisStandaloneConfiguration(); configuration.setHostName("localhost");
 * configuration.setPort(6379); JedisConnectionFactory jedisConnectionFactory =
 * new JedisConnectionFactory(configuration); return jedisConnectionFactory; }
 * 
 * @Bean public RedisTemplate<Object, Object> redisTemplate() {
 * RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
 * template.setConnectionFactory(connectionFactory());
 * template.setKeySerializer(new StringRedisSerializer());
 * template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
 * template.afterPropertiesSet(); return template; }
 * 
 * @Bean public RedisCacheManager redisCacheManager(LettuceConnectionFactory
 * lettuceConnectionFactory) { RedisCacheConfiguration redisCacheConfiguration =
 * RedisCacheConfiguration.defaultCacheConfig()
 * .disableCachingNullValues().entryTtl(Duration.ofHours(1)).
 * serializeValuesWith(
 * RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.
 * json())); redisCacheConfiguration.usePrefix();
 * 
 * return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(
 * lettuceConnectionFactory) .cacheDefaults(redisCacheConfiguration).build();
 * 
 * }
 * 
 * @Bean public JedisClientConfiguration getJedisClientConfiguration() {
 * JedisClientConfiguration.JedisPoolingClientConfigurationBuilder
 * JedisPoolingClientConfigurationBuilder =
 * (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder)
 * JedisClientConfiguration .builder(); final var GenericObjectPoolConfig = new
 * GenericObjectPoolConfig(); GenericObjectPoolConfig.setMaxTotal(16);
 * GenericObjectPoolConfig.setMaxIdle(8); GenericObjectPoolConfig.setMinIdle(4);
 * return
 * JedisPoolingClientConfigurationBuilder.poolConfig(GenericObjectPoolConfig).
 * build(); }
 * 
 * @Bean public JedisConnectionFactory connectionFactory() {
 * RedisStandaloneConfiguration configuration = new
 * RedisStandaloneConfiguration(); configuration.setHostName("localhost");
 * configuration.setPort(6379); return new
 * JedisConnectionFactory(configuration); }
 * 
 * @Bean public RedisTemplate<String, Object> template() { RedisTemplate<String,
 * Object> template = new RedisTemplate<>();
 * template.setConnectionFactory(connectionFactory());
 * template.setKeySerializer(new StringRedisSerializer());
 * template.setHashKeySerializer(new StringRedisSerializer());
 * template.setHashKeySerializer(new JdkSerializationRedisSerializer());
 * template.setValueSerializer(new JdkSerializationRedisSerializer());
 * template.setEnableTransactionSupport(true); template.afterPropertiesSet();
 * return template; } }
 */
