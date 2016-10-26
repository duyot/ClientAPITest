package com.wms.main;

import com.wms.dto.AdminUserDTO;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by duyot on 10/14/2016.
 */
public class RestClientTest {
    public static final String TEST__PARAMS_URI = "http://localhost:8080//WMS_Webservices/services/userservices/findUser/{id}";
    public static final String TEST__POST_OBJECT_URI = "http://localhost:8080//WMS_Webservices/services/userservices/saveUser.json";
    public static final String TEST__DELETE_URI = "http://localhost:8080//WMS_Webservices/services/userservices/deleteUser/{id}";
    public static final String TEST__FILE_URI = "http://localhost:8080//WMS_Webservices/services/userservices/getFile/{fileName}";

    private static String REGISTER_URL =  "http://localhost:8080//WMS_Webservices/services/userservices/saveUser";
    private static String Login_URL =  "http://localhost:8080//WMS_Webservices/services/userservices/login";

    public static void main(String[] args) {
        AdminUserDTO loginUser = new AdminUserDTO("1001","hoonzuco","ceea23519f6f86ad67e9f798bf8002cb","2","25/11/2016","","1.jpg","role");
        System.out.println(RestClientTest.register(loginUser));
    }

    public static boolean register(AdminUserDTO loginUser){
        RestTemplate restTemplate = new RestTemplate();
        try {
            AdminUserDTO adminUserDTO = restTemplate.postForObject(Login_URL,loginUser,AdminUserDTO.class);
            System.out.println(adminUserDTO.toString());
            return true;
        } catch (RestClientException e) {
            return false;
        }
    }

}
