package com.wms.dto;


/**
 * Created by duyot on 8/30/2016.
 */
public class AdminUserDTO{
    public String userId;
    public String username;
    public String password;
    public String status;
    public String createDate;
    public String email;
    public String imgUrl;
    public String roleName;

    public AdminUserDTO() {
    }

    public AdminUserDTO(String userId, String username, String password, String status, String createDate, String email,String imgUrl, String roleName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.status = status;
        this.createDate = createDate;
        this.email = email;
        this.imgUrl = imgUrl;
        this.roleName = roleName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    @Override
    public String toString() {
        return "AdminUserDTO{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", createDate='" + createDate + '\'' +
                ", email='" + email + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
