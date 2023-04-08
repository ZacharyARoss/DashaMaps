package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap1Test {
    DashaMap map;

    @Before
    public void before(){
        map = new DashaMap();
    }
    @Test
    public void testSet(){
        String key =  "key";
        String value = "value";
        long expected = 1;

        map.set(key, value);
        long actual = map.bucketSize("k");

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testDelete(){
        String key =  "key";
        String value = "value";
        long expected = 0;

        map.set(key, value);
        long actual = map.bucketSize("k");

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGet(){
    String key = "ki";
    String expected = "energy";
    map.set(key, expected);

    String actual = map.get(key);

    Assert.assertEquals(expected, actual);
    }
    @Test
    public void testIsEmpty(){
        String e = "e";
        String key = "dre";

        map.set(key, e);

        Assert.assertFalse(map.isEmpty());
    }

    @Test
    public void testIsEmpty2(){
        Assert.assertTrue(map.isEmpty());
    }
    @Test
    public void testSize(){
        long expected = 2;

        map.set("i dont know", "same thing");
        map.set("anything", "samer thing");

        long actual = map.size();

        Assert.assertEquals(expected, actual);
    }

}
