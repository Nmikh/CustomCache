package com;

import org.junit.Assert;
import org.junit.Test;

public class CustomCacheTest {

    @Test
    public void addAndGetBeforeMaxSize() {
        CustomCache customCache = new CustomCache();

        String key = "key1";
        String value = "value1";
        long time = 2;

        customCache.add(key, value, time);

        String key2 = "key2";
        String value2 = "value2";
        long time2 = 3;

        customCache.add(key2, value2, time2);

        String obj1 = (String) customCache.get(key);
        Assert.assertEquals(obj1, value);

        String obj2 = (String) customCache.get(key2);
        Assert.assertEquals(obj2, value2);
    }

    @Test
    public void addAndGetAfterMaxSize() throws InterruptedException {
        CustomCache customCache = new CustomCache();

        String key1 = "key1";
        String value1 = "value1";
        long time1 = 60;

        customCache.add(key1, value1, time1);

        String key2 = "key2";
        String value2 = "value2";
        long time2 = 10;

        customCache.add(key2, value2, time2);

        String key3 = "key3";
        String value3 = "value3";
        long time3 = 1;

        customCache.add(key3, value3, time3);

        String key4 = "key4";
        String value4 = "value4";
        long time4 = 20;

        customCache.add(key4, value4, time4);

        String key5 = "key5";
        String value5 = "value5";
        long time5 = 25;

        Thread.sleep(1100);

        customCache.add(key5, value5, time5);

        String obj = (String) customCache.get(key3);
        Assert.assertNull(obj);

    }

    @Test
    public void clearTest(){
        CustomCache customCache = new CustomCache();

        String key1 = "key1";
        String value1 = "value1";
        long time1 = 60;

        customCache.add(key1, value1, time1);

        String key2 = "key2";
        String value2 = "value2";
        long time2 = 10;

        customCache.add(key2, value2, time2);

        customCache.clear();

        String obj = (String) customCache.get(key1);
        String obj2 = (String) customCache.get(key2);

        Assert.assertNull(obj);
        Assert.assertNull(obj2);
    }
}

