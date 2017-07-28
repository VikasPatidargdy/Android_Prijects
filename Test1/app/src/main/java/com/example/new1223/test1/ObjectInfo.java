package com.example.new1223.test1;

import java.io.Serializable;



public class ObjectInfo implements Serializable {
    int  dropPoints, tripCharge, lowerTripCharge, discountAmount, tripAmount, totalCharge, loadingCharge, unloadingCharge, dropPointCharge, surgeAmount, surgePercentage, estimatedLowerBill, estimatedUperBill, minimumTime, minimumBill, finalBalance, amountToBePaid;
    long tripID;
    float tripDistance, lowerTripDistance, minimumDistance;
    String vehicle;
    String driver;
    String  driverNumber;
    String driverVehicleNumber;
    String pickUp;
    String drop;
    String mgCode;
    String bokingType;
    String customerNotes;
    String date;
    String status;

    public ObjectInfo() {
    }


    public long getTripID() {
        return tripID;
    }

    public void setTripID(long tripID) {
        this.tripID = tripID;
    }

    public int getDropPoints() {
        return dropPoints;
    }

    public void setDropPoints(int dropPoints) {
        this.dropPoints = dropPoints;
    }

    public int getTripCharge() {
        return tripCharge;
    }

    public void setTripCharge(int tripCharge) {
        this.tripCharge = tripCharge;
    }

    public int getLowerTripCharge() {
        return lowerTripCharge;
    }

    public void setLowerTripCharge(int lowerTripCharge) {
        this.lowerTripCharge = lowerTripCharge;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getTripAmount() {
        return tripAmount;
    }

    public void setTripAmount(int tripAmount) {
        this.tripAmount = tripAmount;
    }

    public int getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(int totalCharge) {
        this.totalCharge = totalCharge;
    }

    public int getLoadingCharge() {
        return loadingCharge;
    }

    public void setLoadingCharge(int loadingCharge) {
        this.loadingCharge = loadingCharge;
    }

    public int getUnloadingCharge() {
        return unloadingCharge;
    }

    public void setUnloadingCharge(int unloadingCharge) {
        this.unloadingCharge = unloadingCharge;
    }

    public int getDropPointCharge() {
        return dropPointCharge;
    }

    public void setDropPointCharge(int dropPointCharge) {
        this.dropPointCharge = dropPointCharge;
    }

    public int getSurgeAmount() {
        return surgeAmount;
    }

    public void setSurgeAmount(int surgeAmount) {
        this.surgeAmount = surgeAmount;
    }

    public int getSurgePercentage() {
        return surgePercentage;
    }

    public void setSurgePercentage(int surgePercentage) {
        this.surgePercentage = surgePercentage;
    }

    public int getEstimatedLowerBill() {
        return estimatedLowerBill;
    }

    public void setEstimatedLowerBill(int estimatedLowerBill) {
        this.estimatedLowerBill = estimatedLowerBill;
    }

    public int getEstimatedUperBill() {
        return estimatedUperBill;
    }

    public void setEstimatedUperBill(int estimatedUperBill) {
        this.estimatedUperBill = estimatedUperBill;
    }

    public int getMinimumTime() {
        return minimumTime;
    }

    public void setMinimumTime(int minimumTime) {
        this.minimumTime = minimumTime;
    }

    public int getMinimumBill() {
        return minimumBill;
    }

    public void setMinimumBill(int minimumBill) {
        this.minimumBill = minimumBill;
    }

    public int getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(int finalBalance) {
        this.finalBalance = finalBalance;
    }

    public int getAmountToBePaid() {
        return amountToBePaid;
    }

    public void setAmountToBePaid(int amountToBePaid) {
        this.amountToBePaid = amountToBePaid;
    }

    public float getTripDistance() {
        return tripDistance;
    }

    public void setTripDistance(float tripDistance) {
        this.tripDistance = tripDistance;
    }

    public float getLowerTripDistance() {
        return lowerTripDistance;
    }

    public void setLowerTripDistance(float lowerTripDistance) {
        this.lowerTripDistance = lowerTripDistance;
    }

    public float getMinimumDistance() {
        return minimumDistance;
    }

    public void setMinimumDistance(float minimumDistance) {
        this.minimumDistance = minimumDistance;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(String driverNumber) {
        this.driverNumber = driverNumber;
    }

    public String getDriverVehicleNumber() {
        return driverVehicleNumber;
    }

    public void setDriverVehicleNumber(String driverVehicleNumber) {
        this.driverVehicleNumber = driverVehicleNumber;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getDrop() {
        return drop;
    }

    public void setDrop(String drop) {
        this.drop = drop;
    }

    public String getMgCode() {
        return mgCode;
    }

    public void setMgCode(String mgCode) {
        this.mgCode = mgCode;
    }

    public String getBokingType() {
        return bokingType;
    }

    public void setBokingType(String bokingType) {
        this.bokingType = bokingType;
    }

    public String getCustomerNotes() {
        return customerNotes;
    }

    public void setCustomerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
    /*
    String getObjectInfo(){
        String info ="Trip iD   "+tripID+"\nDrop points    "+ dropPoints+ "\ntrip Charge    "+ tripCharge+"\nlower trip charge     "+ lowerTripCharge+"\ndiscount amount   " + discountAmount+"\n trip amount  "+ tripAmount+"\ntotal charge    "+ totalCharge +" \nLoading charge  "+ loadingCharge+ "\nunloading charge    "+ unloadingCharge+"\ndrop point charge" +dropPointCharge+ "\nsurge amount    " +surgeAmount+ "\nsurge percentage      " + surgePercentage + "\n" +estimatedLowerBill + "\n" + estimatedUperBill + "\n" + minimumTime + "\n" + minimumBill + "\n" + finalBalance + "\n" + amountToBePaid + "\n" + tripDistance + "\n" +  lowerTripDistance+ "\n" + minimumDistance+ "\n" +vehicle + "\n" + driver+ "\n" + driverNumber+ "\n" + driverVehicleNumber+ "\n" + pickUp+ "\n" + drop+ "\n" + mgCode+ "\n" + bokingType+ "\n" + customerNotes+ "\n" + date+ "\n" + status;
        return info;
    }

    String getMinObjectInfo(){
        String info ="Trip ID    "+tripID+    "\nTotal Charges   "+ totalCharge +"\nFinal Balance    " + finalBalance + "\nAmount To Be Paid    " + amountToBePaid + "\nVehicle   " +vehicle + "\nBoking Type    " + bokingType+  "\nDate    " + date;
        return info;
    }*/
