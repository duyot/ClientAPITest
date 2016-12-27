package com.wms.main;

import com.wms.dto.*;
import com.wms.utils.Constants;
import com.wms.utils.FunctionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by duyot on 10/14/2016.
 */
public class RestClientTest {
    public static final String TEST__PARAMS_URI = "http://localhost:8080//WMS_Webservices/services/userservices/findUser/{id}";
    public static final String TEST__POST_OBJECT_URI = "http://localhost:8080//WMS_Webservices/services/userservices/saveUser.json";
    public static final String TEST__DELETE_URI = "http://localhost:8080//WMS_Webservices/services/userservices/deleteUser/{id}";
    public static final String TEST__FILE_URI = "http://localhost:8080//WMS_Webservices/services/userservices/getFile/{fileName}";

    private static String REGISTER_URL =  "http://localhost:8080//WMS_Webservices/services/userservices/saveUser";
    private static String ADD_URL =  "http://localhost:8080//WMS_Webservices/services/mjrStockGoodsTotalservices/add";
    private static String UPDATE_URL =  "http://localhost:8080//WMS_Webservices/services/stockmanagermentservices/import";
    private static String FIND_CONDITION_URL =  "http://localhost:8080//WMS_Webservices/services/mjrStockGoodsTotalservices/findByCondition";
    private static String FIND_BY_ID =  "http://localhost:8080//WMS_Webservices/services/userservices/find/";
    //
    private static String GET_MENU_URL =  "http://localhost:8080//WMS_Webservices/services/roleActionServices/getUserAction/1001";
    private static String GET_ALL_URL =  "http://localhost:8080//WMS_Webservices/services/customerservices/getAll";

    public static Logger  log = LoggerFactory.getLogger(RestClientTest.class);

    public static void testAmount(double count){

        List<Condition> lstCon = new ArrayList<>();
        lstCon.add(new Condition("id", Constants.SQL_PRO_TYPE.LONG, Constants.SQL_OPERATOR.EQUAL,"1052"));
        List<MjrStockGoodsTotalDTO> lstResult = RestClientTest.findByCondition(lstCon);
        MjrStockGoodsTotalDTO item = lstResult.get(0);
        item.setAmount(count+"");
//        try {
//            //Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        RestClientTest.update(item);
    }


    public static void main(String[] args) {
//        MjrStockGoodsTotalDTO customer = new MjrStockGoodsTotalDTO();
//        customer.setCustId("1000");
//        customer.setCustName("Tập đoàn viễn thông quân đội viettel");
//        customer.setCustId("1000");
//        customer.setStockId("1001");
//        customer.setStockCode("HL001");
//        customer.setGoodsId("2001");
//        customer.setGoodsCode("CARD_200");
//        customer.setGoodsName("Card điện thoại 200k");
//        customer.setGoodsState("1");
//        customer.setAmount("25");


        log.info("starting...");
        for (int i = 0; i < 5; i++) {
            RestClientTest.testAmount(10);
        }
        //
        //System.out.println(RestClientTest.add(customer));
    }

    public static List<CustomerDTO> getAll(){
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<CustomerDTO[]> responseEntity = restTemplate.getForEntity(GET_ALL_URL, CustomerDTO[].class);
            return Arrays.asList(responseEntity.getBody());
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public static User findById(Long id){
        RestTemplate restTemplate = new RestTemplate();
        String findByIdURL = FIND_BY_ID + id;
        try {
            User responseEntity = restTemplate.getForObject(findByIdURL,User.class);
            return responseEntity;
        } catch (RestClientException e) {
            return null;
        }
    }

    public static List<MjrStockGoodsTotalDTO> findByCondition(List<Condition> lstCondition){
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<MjrStockGoodsTotalDTO[]> responseEntity = restTemplate.postForEntity(FIND_CONDITION_URL, lstCondition,MjrStockGoodsTotalDTO[].class);
            return Arrays.asList(responseEntity.getBody());
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public static List<ActionMenuDTO> getActionMenu(){
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<ActionMenuDTO[]> responseEntity = restTemplate.exchange(GET_MENU_URL, HttpMethod.GET,new HttpEntity<Object>(FunctionUtils.createHeaders("duyot", "password")),ActionMenuDTO[].class);
            if(responseEntity.getBody() != null){
                return Arrays.asList(responseEntity.getBody());
            }else{
                System.out.println("Cannot get info");
                return new ArrayList<>();
            }
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }




    public static boolean add(MjrStockGoodsTotalDTO customer){
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseObject addResult = restTemplate.postForObject(ADD_URL,customer,ResponseObject.class);
            System.out.println(addResult.toString());
            return true;
        } catch (RestClientException e) {
            return false;
        }
    }

    public static boolean update(MjrStockGoodsTotalDTO customer){
        RestTemplate restTemplate = new RestTemplate();
        try {
            log.info("Calling...");
            ResponseObject addResult = restTemplate.postForObject(UPDATE_URL,customer,ResponseObject.class);
            log.info(addResult.toString());
            return true;
        } catch (RestClientException e) {
            return false;
        }
    }

}
