package com.example.myapp.ModalClass;

public class Userdata
{
    String id,full_name,email,mobile,plot,address_lane_1,address_lane_2,area,pincode;
    public  Userdata(String id,String full_name,String email,String mobile,String plot,String address_lane_1,String address_lane_2,String area,String pincode)

    {
        this.id=id;
        this.full_name=full_name;
        this.email=email;
        this.mobile=mobile;
        this.plot=plot;
        this.address_lane_1=address_lane_1;
        this.address_lane_2=address_lane_2;
        this.area=area;
        this.pincode=pincode;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getAddress_lane_1() {
        return address_lane_1;
    }

    public void setAddress_lane_1(String address_lane_1) {
        this.address_lane_1 = address_lane_1;
    }

    public String getAddress_lane_2() {
        return address_lane_2;
    }

    public void setAddress_lane_2(String address_lane_2) {
        this.address_lane_2 = address_lane_2;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
