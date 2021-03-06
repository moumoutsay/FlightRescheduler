package edu.cmu.sv.flight.rescheduler.database.sql;

import android.provider.BaseColumns;

/**
 * Created by hsuantzl on 2015/4/18.
 */
public abstract class SQLCmdRoute implements BaseColumns {
    public static final String TABLE_NAME = "route";
    public static final String FLIGHT_ID = "f_id";
    public static final String USER_ID = "u_id";



    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME+"(" +
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FLIGHT_ID + " INTEGER," +
            USER_ID + " INTEGER," +
            " FOREIGN KEY(" + FLIGHT_ID + ")" +
            " REFERENCES " + SQLCmdFlight.TABLE_NAME + "(" + SQLCmdFlight._ID + ")" +
            " ON DELETE CASCADE ON UPDATE CASCADE, " +
            " FOREIGN KEY(" + USER_ID + ")" +
            " REFERENCES " + SQLCmdUser.TABLE_NAME + "(" + SQLCmdUser._ID + ")" +
            " ON DELETE CASCADE ON UPDATE CASCADE );";
}
