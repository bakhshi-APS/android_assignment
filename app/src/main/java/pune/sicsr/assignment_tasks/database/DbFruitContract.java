package pune.sicsr.assignment_tasks.database;

import android.provider.BaseColumns;

public final class DbFruitContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.

    public static String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FruitEntry.TABLE_NAME + " (" +
                    FruitEntry._ID + " INTEGER PRIMARY KEY," +
                    FruitEntry.FRUIT_NAME + " TEXT," +
                    FruitEntry.FRUIT_ID + " INTEGER)";

    public static String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FruitEntry.TABLE_NAME;


    private DbFruitContract() {
    }

    public static class FruitEntry implements BaseColumns {
        public static final String TABLE_NAME = "fruits";
        public static final String FRUIT_NAME = "fruitname";
        public static final String FRUIT_ID = "fruitid";
    }
}
