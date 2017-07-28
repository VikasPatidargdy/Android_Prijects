package com.example.new1223.test1;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;


public class DBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Maalgaadi";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "customer_table";
    Context context;


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                "trip_id  INTEGER PRIMARY KEY," +
                "vehicle  TEXT," +
                "driver TEXT," +
                "driver_nu TEXT," +
                "driver_vehicle_no TEXT," +
                "pick_up TEXT," +
                "drop_ TEXT," +
                "drop_points TEXT," +
                "mg_code TEXT," +
                "booking_type TEXT," +
                "trip_charge INTEGER," +
                "lower_trip_charge INTEGER," +
                "discount_amount INTEGER," +
                "trip_amount INTEGER," +
                "total_charge INTEGER," +
                "trip_distance REAL," +
                "lower_trip_distance REAL," +
                "loading_charge INTEGER," +
                "unloading_charge INTEGER," +
                "drop_point_charge INTEGER," +
                "surge_amount INTEGER," +
                "surge_percentage INTEGER," +
                "estimated_lower_bill INTEGER," +
                "estimated_upper_bill INTEGER," +
                "minimum_time INTEGER," +
                "minimum_distance REAL," +
                "minimum_bill INTEGER," +
                "customer_notes TEXT," +
                "final_balance INTEGER," +
                "amount_to_be_paid INTEGER," +
                "date TEXT," +
                "status TEXT);";
        sqLiteDatabase.execSQL(query);

        Log.e("DATABASE_Created", "!!!!!!!!!!!!!!!!!!!!!!DATABASE_CREATED!!!!!!!!!!!!!!!!\n" + query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    void insertInfo(ObjectInfo objectInfo) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("trip_id", objectInfo.getTripID());
        contentValues.put("vehicle", objectInfo.getVehicle());
        contentValues.put("driver", objectInfo.getDriver());
        contentValues.put("driver_nu", objectInfo.getDriverNumber());
        contentValues.put("driver_vehicle_no", objectInfo.getDriverVehicleNumber());
        contentValues.put("pick_up", objectInfo.getPickUp());
        contentValues.put("drop_", objectInfo.getDrop());
        contentValues.put("drop_points", objectInfo.getDropPoints());
        contentValues.put("mg_code", objectInfo.getMgCode());
        contentValues.put("booking_type", objectInfo.getBokingType());
        contentValues.put("trip_charge", objectInfo.getTripCharge());
        contentValues.put("lower_trip_charge", objectInfo.getLowerTripCharge());
        contentValues.put("discount_amount", objectInfo.getDiscountAmount());
        contentValues.put("trip_amount", objectInfo.getTripAmount());
        contentValues.put("total_charge", objectInfo.getTotalCharge());
        contentValues.put("trip_distance", objectInfo.getTripDistance());
        contentValues.put("lower_trip_distance", objectInfo.getLowerTripDistance());
        contentValues.put("loading_charge", objectInfo.getLoadingCharge());
        contentValues.put("unloading_charge", objectInfo.getUnloadingCharge());
        contentValues.put("drop_point_charge", objectInfo.getDropPointCharge());
        contentValues.put("surge_amount", objectInfo.getSurgeAmount());
        contentValues.put("surge_percentage", objectInfo.getSurgePercentage());
        contentValues.put("estimated_lower_bill", objectInfo.getEstimatedLowerBill());
        contentValues.put("estimated_upper_bill", objectInfo.getEstimatedUperBill());
        contentValues.put("minimum_time", objectInfo.getMinimumTime());
        contentValues.put("minimum_distance", objectInfo.getMinimumDistance());
        contentValues.put("minimum_bill", objectInfo.getMinimumBill());
        contentValues.put("customer_notes", objectInfo.getCustomerNotes());
        contentValues.put("final_balance", objectInfo.getFinalBalance());
        contentValues.put("amount_to_be_paid", objectInfo.getAmountToBePaid());
        contentValues.put("date", objectInfo.getDate());
        contentValues.put("status", objectInfo.getStatus());

        try {
            long noOfRows = db.insert(TABLE_NAME, null, contentValues);
            Log.e("Insert", noOfRows + " ");
            db.close();
            Toast.makeText(context, "DATA INSERTED", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("Error IN INSERTION", "ERROR DURING INSERTION" + e.toString());
            Toast.makeText(context, "ERROR DURING INSERTION", Toast.LENGTH_SHORT).show();

        }
    }

    void getAllDATA(long tripID) {
        String query = "SELECT * FROM" + TABLE_NAME + " WHERE trip_id = " + tripID;

        DBHandler dbHandler = new DBHandler(context);
        Cursor cursor = dbHandler.getReadableDatabase().rawQuery(query, null);
        cursor.moveToFirst();
        String[] result = new String[cursor.getColumnCount()];
        int i;
        for (i = 0; i<cursor.getColumnCount(); i++)
        {
            result[i] = cursor.getString(i).toString() ;
                Log.e("Column" + i, result[i]);
        }
        //  result;
    }
}