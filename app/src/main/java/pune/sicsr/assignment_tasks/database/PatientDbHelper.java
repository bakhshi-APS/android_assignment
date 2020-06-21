package pune.sicsr.assignment_tasks.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static pune.sicsr.assignment_tasks.database.DbContracts.SQL_CREATE_ENTRIES_PATIENTS;
import static pune.sicsr.assignment_tasks.database.DbContracts.SQL_DELETE_ENTRIES_PATIENTS;

public class PatientDbHelper extends SQLiteOpenHelper {


    static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "patients.db";


    public PatientDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES_PATIENTS);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES_PATIENTS);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}
