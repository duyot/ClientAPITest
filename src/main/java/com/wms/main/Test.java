package com.wms.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by duyot on 12/19/2016.
 */
public class Test {
    public static Logger log = LoggerFactory.getLogger(RestClientTest.class);
    public static void main(String[] args) {
        log.info("starting...");
        RestClientTest.testAmount(10);
        for (int i = 0; i < 5; i++) {
        }
    }
}
