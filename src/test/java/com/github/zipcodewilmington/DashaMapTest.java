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

    }
    @Test
    public void testIsEmpty(){

    }
    @Test
    public void testSize(){

    }

}
