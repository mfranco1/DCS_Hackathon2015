package dcshackathon2015.dcshackathon2015;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


/**
 * Created by gj_ on 4/25/2015.
 */
public class DBHandler2 extends SQLiteAssetHelper{

    private static final String DATABASE_NAME = "newDataBase.db";
    private static final int DATABASE_VERSION = 1;

    public interface TABLES{
        String TERMINAL = "Terminal";
        String TRIP = "Trip";
    }
    public interface TERMINAL_COLUMNS{
        String TERMINAL_ID = "Terminal_id";
        String TERMINAL_PLACE = "Terminal_place";
    }
    public interface TRIP_COLUMNS{
        String TRIP_ID = "Trip_id";
        String TRIP_NAME = "Trip_name";
        String TERMINAL_TERMINAL_ID = "Terminal_Terminal_id";
        String TRIP_AVAILABILITY = "Trip_availability";
    }

    public DBHandler2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor getTerminalItems(String source, String dest){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TABLES.TERMINAL);
        Cursor c = db.rawQuery("SELECT a.name AS origin, b.name AS destination, Trip.availability, Trip.average_waiting_time, Trip.average_waiting_time_rush, Trip.average_travel_time, Trip.average_travel_time_rush FROM Trip JOIN Terminal a, Terminal b ON Trip.terminal_id_origin = a.ID AND Trip.terminal_id_destination = b.ID WHERE a.name LIKE '%"+source+"%' AND b.name LIKE '%"+dest+"%'",null);
        //c.moveToFirst();
        return c;
    }

    public Cursor getTripItems(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TABLES.TRIP);
        Cursor c = qb.query(db, null, null, null, null, null, null);
        c.moveToFirst();
        return c;
    }
}
