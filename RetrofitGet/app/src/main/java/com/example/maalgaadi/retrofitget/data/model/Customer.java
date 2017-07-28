package com.example.maalgaadi.retrofitget.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by new1223 on 23/6/17.
 */

public class Customer {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("cust_number")
    @Expose
    private String custNumber;
    @SerializedName("cust_name")
    @Expose
    private String custName;
    @SerializedName("cust_email")
    @Expose
    private String custEmail;
    @SerializedName("cust_address")
    @Expose
    private String custAddress;
    @SerializedName("cust_organization")
    @Expose
    private String custOrganization;
    @SerializedName("cluster_number")
    @Expose
    private Integer clusterNumber;
    @SerializedName("cust_alternate_number")
    @Expose
    private String custAlternateNumber;
    @SerializedName("cust_business_product")
    @Expose
    private String custBusinessProduct;
    @SerializedName("cust_password")
    @Expose
    private String custPassword;
    @SerializedName("remember")
    @Expose
    private String remember;
    @SerializedName("remember_token")
    @Expose
    private String rememberToken;
    @SerializedName("email_token")
    @Expose
    private String emailToken;
    @SerializedName("device_token")
    @Expose
    private String deviceToken;
    @SerializedName("device_id")
    @Expose
    private Object deviceId;
    @SerializedName("customer_otp")
    @Expose
    private String customerOtp;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("employee_id")
    @Expose
    private Integer employeeId;
    @SerializedName("city_id")
    @Expose
    private Integer cityId;
    @SerializedName("cust_discount_percent")
    @Expose
    private Integer custDiscountPercent;
    @SerializedName("cust_pricing_module_id")
    @Expose
    private Integer custPricingModuleId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("goods_id")
    @Expose
    private Integer goodsId;
    @SerializedName("referral_code")
    @Expose
    private String referralCode;
    @SerializedName("trip_code")
    @Expose
    private String tripCode;
    @SerializedName("profile_img")
    @Expose
    private String profileImg;
    @SerializedName("customer_type")
    @Expose
    private Integer customerType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(String custNumber) {
        this.custNumber = custNumber;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustOrganization() {
        return custOrganization;
    }

    public void setCustOrganization(String custOrganization) {
        this.custOrganization = custOrganization;
    }

    public Integer getClusterNumber() {
        return clusterNumber;
    }

    public void setClusterNumber(Integer clusterNumber) {
        this.clusterNumber = clusterNumber;
    }

    public String getCustAlternateNumber() {
        return custAlternateNumber;
    }

    public void setCustAlternateNumber(String custAlternateNumber) {
        this.custAlternateNumber = custAlternateNumber;
    }

    public String getCustBusinessProduct() {
        return custBusinessProduct;
    }

    public void setCustBusinessProduct(String custBusinessProduct) {
        this.custBusinessProduct = custBusinessProduct;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    public String getEmailToken() {
        return emailToken;
    }

    public void setEmailToken(String emailToken) {
        this.emailToken = emailToken;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public Object getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Object deviceId) {
        this.deviceId = deviceId;
    }

    public String getCustomerOtp() {
        return customerOtp;
    }

    public void setCustomerOtp(String customerOtp) {
        this.customerOtp = customerOtp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCustDiscountPercent() {
        return custDiscountPercent;
    }

    public void setCustDiscountPercent(Integer custDiscountPercent) {
        this.custDiscountPercent = custDiscountPercent;
    }

    public Integer getCustPricingModuleId() {
        return custPricingModuleId;
    }

    public void setCustPricingModuleId(Integer custPricingModuleId) {
        this.custPricingModuleId = custPricingModuleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getTripCode() {
        return tripCode;
    }

    public void setTripCode(String tripCode) {
        this.tripCode = tripCode;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

}
