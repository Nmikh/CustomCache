package com;

import java.time.LocalDateTime;
import java.util.*;

public class CustomCache {
    private Map<String, CacheObject> cache;
    private final int CACHE_SIZE = 3;

    public CustomCache() {
        this.cache = new HashMap<String, CacheObject>();
    }

    public boolean add(String key, Object object, long seconds) {
        if (this.cache.containsKey(key)) {
            return false;
        }

        String findKey = null;

        if (this.cache.size() > CACHE_SIZE) {
            for (Map.Entry<String, CacheObject> entry : this.cache.entrySet()) {
                if (findKey == null) {
                    findKey = entry.getKey();
                }

                if (entry.getValue().getTimeOut()
                        .compareTo(this.cache.get(findKey).getTimeOut()) < 0) {
                    findKey = entry.getKey();
                }
            }

            if (this.cache.get(findKey).getTimeOut()
                    .compareTo(LocalDateTime.now()) > 0) {
                return false;
            }

            this.cache.remove(findKey);
        }

        this.cache.put(key, new CacheObject(object, seconds));
        return true;
    }

    public void remove(String key) {
        this.cache.remove(key);
    }

    public Object get(String key) {
        if (!this.cache.containsKey(key)) {
            return null;
        }

        return this.cache.get(key).getObject();
    }

    public void clear() {
        this.cache.clear();
    }
}
