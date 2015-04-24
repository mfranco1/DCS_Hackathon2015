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

    private static final String DATABASE_NAME = "database.db";
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

    public Cursor getTerminalItems(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TABLES.TERMINAL);
        //Cursor c = qb.query(db, null, null, null, null, null, null);
        //Cursor c = db.query(TABLES.TERMINAL, new String[] {TERMINAL_COLUMNS.TERMINAL_ID,TERMINAL_COLUMNS.TERMINAL_PLACE},"title_raw like " + "'%Smith%'", null, null, null, null);
        Cursor c = db.rawQuery("SELECT * FROM "+TABLES.TERMINAL,null);
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

    /*
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_TRIP = "trip";
    private static final String TABLE_TERMINAL = "terminal";

    //terminal column name
    private static final String TERMINAL = "Terminal";
    private static final String TERMINAL_ID = "Terminal_id";
    private static final String TERMINAL_PLACE = "Terminal_place";

    //trip column name
    private static final String TRIP = "Trip";
    private static final String  TRIP_ID = "Trip_id";
    private static final String TRIP_NAME = "Trip_name";
    private static final String TERMINAL_TERMINAL_ID = "Terminal_Terminal_id";
    private static final String TRIP_AVAILABILITY = "Trip_availability";

    //crate table
    public void onCreate(SQLiteDatabase db){
        String CREATE_TRIP_TABLE = "CREATE TABLE " + TRIP + "("
                + TRIP_ID + " INTEGER NOT NULL UNIQUE, " + TRIP_NAME
                + " TEXT NOT NULL, " + TERMINAL_TERMINAL_ID + " INTEGER NOT NULL, "
                + TRIP_AVAILABILITY + " INTEGER NOT NULL, PRIMARY KEY (" +
                TRIP_ID + "), FOREIGN KEY(" + TERMINAL_TERMINAL_ID + ") REFERENCES"
                + TERMINAL + "(" + TERMINAL_ID + "))";
        String CREATE_TERMINAL_TABLE = "CREATE TABLE " + TERMINAL + "(" + TERMINAL_ID
                + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + TERMINAL_PLACE
                + " TEXT NOT NULL)";
        db.execSQL(CREATE_TERMINAL_TABLE);
        db.execSQL(CREATE_TRIP_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TERMINAL);
        db.execSQL("DROP TABLE IF EXISTS " + TRIP);
        onCreate(db);
    }
    */
}
