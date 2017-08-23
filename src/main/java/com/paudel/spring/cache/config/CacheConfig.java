package com.paudel.spring.cache.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.paudel.spring.cache.repository")
@EnableAutoConfiguration
@Configuration
@EnableCaching
public class CacheConfig {

	
	 @Bean
	    public CacheManager cacheManager() {
	        return new EhCacheCacheManager(cacheMangerFactory().getObject());
	    }


	@Bean
	public EhCacheManagerFactoryBean  cacheMangerFactory() {
		EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		ehCacheManagerFactoryBean.setShared(true);		
		return ehCacheManagerFactoryBean;
	}
	
	
	
}
