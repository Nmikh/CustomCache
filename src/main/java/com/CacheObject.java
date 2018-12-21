package com;

import java.time.LocalDateTime;

public class CacheObject {
    private Object object;
    private LocalDateTime timeOut;

    public CacheObject(Object object, long seconds) {
        this.object = object;
        this.timeOut = LocalDateTime.now().plusSeconds(seconds);
    }

    public Object getObject() {
        return object;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

}
