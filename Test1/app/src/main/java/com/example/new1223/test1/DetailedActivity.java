package com.example.new1223.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailedActivity extends AppCompatActivity {
    TextView textViewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        textViewDetail = (TextView) findViewById(R.id.text_view_description);
        Intent intent = getIntent();
        ObjectInfo objectInfo = (ObjectInfo) intent.getSerializableExtra("Description");
        textViewDetail.setText("Trip ID\t" + objectInfo.getTripID() + "" +
                "\nVehicle\t" + objectInfo.getVehicle() + "" +
                "\nDriver\t" + objectInfo.getDriver() + "" +
                "\nDriver no.\t" + objectInfo.getDriverNumber() + "" +
                "\nDriver Vehicle No.\t" + objectInfo.getDriverVehicleNumber() + "" +
                "\nPickUp\t" + objectInfo.getPickUp() + "" +
                "\nDrop\t" + objectInfo.getDrop() + "" +
                "\nDrop Points\t" + objectInfo.getDropPoints() + "" +
                "\nMG Code\t" + objectInfo.getMgCode() + "" +
                "\nBooking Type\t" + objectInfo.getBokingType() + "" +
                "\nTrip Charge\t" + objectInfo.getTripCharge() + "" +
                "\nLower Trip Charge\t" + objectInfo.getLowerTripCharge() + "" +
                "\nDiscount Amount\t" + objectInfo.getDiscountAmount() + "" +
                "\nTrip Amount\t" + objectInfo.getTripAmount() + "" +
                "\nTotal Charge \t" + objectInfo.getTotalCharge() + "" +
                "\nTrip Distance\t" + objectInfo.getTripDistance() + "" +
                "\nLower trip distance\t" + objectInfo.getLowerTripDistance() + "" +
                "\nLoading Charge\t" + objectInfo.getLoadingCharge() + "" +
                "\nUnloading Charge \t" + objectInfo.getUnloadingCharge() + "" +
                "\nDrop point Charge \t" + objectInfo.getDropPointCharge() + "" +
                "\nSurge Amount \t" + objectInfo.getSurgeAmount() + "" +
                "\nSurge Percentage \t" + objectInfo.getSurgePercentage() + "" +
                "\nEstimated Lower Bill \t" + objectInfo.getEstimatedLowerBill() + "" +
                "\nEstimated Uper Bill \t" + objectInfo.getEstimatedUperBill() + "" +
                "\nMinimum Time \t" + objectInfo.getMinimumTime() + "" +
                "\nMinimum Distance  \t" + objectInfo.getMinimumDistance() + "" +
                "\nminimum Bill \t" + objectInfo.getMinimumBill() + "" +
                "\nCustomer Notes \t" + objectInfo.getCustomerNotes() + "" +
                "\nFinal Balance \t" + objectInfo.getFinalBalance() + "" +
                "\nAmount to be Paid \t" + objectInfo.getAmountToBePaid() + "" +
                "\nDate and Time\t" + objectInfo.getDate() + "" +
                "\nStatus \t" + objectInfo.getStatus() + "");
    }


}
