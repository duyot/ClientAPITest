package com.wms.utils;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;

import java.nio.charset.Charset;

/**
 * Created by duyot on 11/4/2016.
 */
public class FunctionUtils {

    public static HttpHeaders createHeaders(final String username,final String password ){
        return new HttpHeaders(){
            {
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")) );
                String authHeader = "Basic " + new String( encodedAuth );
                set( "Authorization", authHeader );
            }
        };
    }
}
