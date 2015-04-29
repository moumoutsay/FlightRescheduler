package edu.cmu.sv.flight.rescheduler.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import edu.cmu.sv.flight.rescheduler.database.sql.SQLCmdNearbyAirport;
import edu.cmu.sv.flight.rescheduler.entities.Airport;

/**
 * Created by moumoutsay on 4/10/15.
 *
 * This is an empty class now.
 *
 * Schema Airport Create, Read, Update, Delete Operation
 */
public class NearByAirportCRUD {
    private DBUtil db;
    private Context context;

    public NearByAirportCRUD(Context context) {
        this.context = context;
    }

    public void insertNearby(Airport fromAirport, Airport toAirport) {
        db = DBUtil.getInstance(context);
        SQLiteDatabase writableDB = db.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(SQLCmdNearbyAirport.AIRPORT_ID, fromAirport.getId());
            cv.put(SQLCmdNearbyAirport.NEARBY_ID, toAirport.getId());
            writableDB.insert(SQLCmdNearbyAirport.TABLE_NAME, null, cv);
        }
        catch(Exception e) {
            Log.d("Exception", e.getMessage());
        }
        finally {
            if(writableDB != null && writableDB.isOpen())
                writableDB.close();
        }

        //Log.d("Database", "Insert 1 record into "+ SQLCmdNearbyAirport.TABLE_NAME +" table");
    }

    public List<Airport> findNearby(Airport fromAirport) {
        List<Airport> nearbyList = new ArrayList<>();

        db = DBUtil.getInstance(context);
        SQLiteDatabase readableDB = db.getReadableDatabase();
        Cursor cursor = readableDB.rawQuery(SQLCmdNearbyAirport.FIND_NEARBY,
                new String[]{Integer.toString(fromAirport.getId())});

        try {
            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    String city = cursor.getString(2);
                    String code = cursor.getString(3);
                    double latitude = Double.parseDouble(cursor.getString(4));
                    double longitude = Double.parseDouble(cursor.getString(5));
                    String timezone = cursor.getString(6);
                    // Adding airport to list
                    Airport airport = new Airport(name, city, code, latitude, longitude, timezone);
                    airport.setId(id);
                    nearbyList.add(airport);
                } while (cursor.moveToNext());
            }
        }
        finally {
            cursor.close();
            //readableDB.close();
        }

        Log.d("Database", "findNearby("+fromAirport.getCode() + ") " +
                " returns " + nearbyList.size() + " records");
        return nearbyList;
    }
}
