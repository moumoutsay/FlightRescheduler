package edu.cmu.sv.flight.rescheduler.database.sql;

import android.provider.BaseColumns;

/**
 * Created by hsuantzl on 2015/4/18.
 */
public abstract class NearbyAirport implements BaseColumns {
    public static final String TABLE_NAME = "nearby_airport";
    public static final String AIRPORT_ID = "airport_id";
    public static final String NEARBY_ID = "nearby_id";



    public static final String CREATE_SQL = "CREATE TABLE " + TABLE_NAME+"(" +
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            AIRPORT_ID + " INTEGER," +
            NEARBY_ID + " INTEGER," +
            " FOREIGN KEY(" + AIRPORT_ID + ")" +
            " REFERENCES " + Airport.TABLE_NAME + "(" + Airport._ID + ")" +
            " ON DELETE CASCADE ON UPDATE CASCADE, " +
            " FOREIGN KEY(" + NEARBY_ID + ")" +
            " REFERENCES " + Airport.TABLE_NAME + "(" + Airport._ID + ")" +
            " ON DELETE CASCADE ON UPDATE CASCADE );";
}
