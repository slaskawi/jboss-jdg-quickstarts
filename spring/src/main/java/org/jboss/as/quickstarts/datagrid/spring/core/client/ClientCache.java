package org.jboss.as.quickstarts.datagrid.spring.core.client;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;

/**
 * Handles direct cache access.
 *
 * @author Sebastian Laskawiec
 */
public class ClientCache {

    private Cache cache;

    public ClientCache(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("default");
    }

    public void clearCache() {
        cache.clear();
    }

    public Collection<Client> getCachedClients() {
        throw new UnsupportedOperationException("Not implemented");
    }

}
