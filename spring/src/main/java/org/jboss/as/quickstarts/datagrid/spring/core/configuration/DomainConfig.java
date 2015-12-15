package org.jboss.as.quickstarts.datagrid.spring.core.configuration;

import org.infinispan.spring.provider.SpringRemoteCacheManagerFactoryBean;
import org.jboss.as.quickstarts.datagrid.spring.core.client.CachedClientGetter;
import org.jboss.as.quickstarts.datagrid.spring.core.client.ClientCache;
import org.jboss.as.quickstarts.datagrid.spring.core.client.ClientGetter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * Spring configuration for domain objects.
 *
 * @author Sebastian Laskawiec
 */
@Configuration
@EnableCaching
public class DomainConfig {

    @Value("classpath:hotrod.properties")
    private Resource hotrodProperties;

    @Bean
    public SpringRemoteCacheManagerFactoryBean springCache() {

        System.out.println("#### :" + hotrodProperties);

        SpringRemoteCacheManagerFactoryBean springRemoteCacheManagerFactoryBean = new SpringRemoteCacheManagerFactoryBean();
        springRemoteCacheManagerFactoryBean.setConfigurationPropertiesFileLocation(hotrodProperties);
        return springRemoteCacheManagerFactoryBean;
    }

    @Bean
    public ClientGetter clientGetter() {
        return new ClientGetter();
    }

    @Bean
    public CachedClientGetter cachedClientGetter(ClientGetter clientGetter) {
        return new CachedClientGetter(clientGetter);
    }

    @Bean
    public ClientCache cacheHandler(CacheManager cacheManager) {
        return new ClientCache(cacheManager);
    }
}
