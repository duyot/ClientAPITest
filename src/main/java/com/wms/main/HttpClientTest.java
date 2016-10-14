package com.wms.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by duyot on 10/14/2016.
 */
public class HttpClientTest {
    public static final String API_URL = "http://localhost:8080/SMSBNApiBackend/request";
    public static Logger log = LoggerFactory.getLogger(HttpClientTest.class);

    public static void main(String[] args) {
        String postData = "";
        HttpClientTest.callAPI(postData);
    }

    public static void callAPI(String postData){
        log.info("Start request Interface: "+ API_URL);
        try {
            Long time = System.currentTimeMillis();

            URL url = new URL(API_URL);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setConnectTimeout(Integer.parseInt("300000"));
            conn.setReadTimeout(Integer.parseInt("300000"));

            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(postData);
            wr.flush();

            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String line;
            String allData = "";
            while ((line = rd.readLine()) != null) {
                allData += line;
            }

            wr.close();
            rd.close();
            log.info("Received result: "+ allData + " in "+ (System.currentTimeMillis() - time) + "(ms)");

        } catch (SocketTimeoutException se) {
            log.error("Error", se);
        } catch (Exception e) {
            log.error("Error", e);
        }
    }


}
