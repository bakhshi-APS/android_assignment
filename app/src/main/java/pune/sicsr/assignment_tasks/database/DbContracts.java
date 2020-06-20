package pune.sicsr.assignment_tasks.database;

import android.provider.BaseColumns;

public final class DbContracts {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.

    public static final String TASK_TWO_DB = "tasktwodb.db";


    public static String SQL_CREATE_ENTRIES_FRUITS =
            "CREATE TABLE " + TableEntries.TABLE_NAME_FRUITS + " (" +
                    TableEntries._ID + " INTEGER PRIMARY KEY," +
                    TableEntries.FRUIT_NAME + " TEXT," +
                    TableEntries.FRUIT_ID + " INTEGER)";

    public static String SQL_DELETE_FRUITS_ENTRIES =
            "DROP TABLE IF EXISTS " + TableEntries.TABLE_NAME_FRUITS;


    // Employee tables SQL
    public static String SQL_DELETE_ENTRIES_EMPLOYEES =
            "DROP TABLE IF EXISTS " + TableEntries.TABLE_NAME_EMPLOYEES;

    public static String SQL_CREATE_ENTRIES_EMPLOYEES =
            "CREATE TABLE " + TableEntries.TABLE_NAME_EMPLOYEES + " (" +
                    TableEntries._ID + " INTEGER PRIMARY KEY," +
                    TableEntries.EMP_NAME + " TEXT," +
                    TableEntries.EMP_SALARY + " LONG," +
                    TableEntries.EMP_RATING + " DOUBLE)";


    private DbContracts() {
    }

    public static class TableEntries implements BaseColumns {
        // Fruits Table entries
        public static final String TABLE_NAME_FRUITS = "fruits";
        public static final String FRUIT_NAME = "fruit_name";
        public static final String FRUIT_ID = "fruit_id";


        // Employees Table entries

        public static final String TABLE_NAME_EMPLOYEES = "employees";
        public static final String EMP_NAME = "employee_name";
        public static final String EMP_SALARY = "employee_salary";
        public static final String EMP_RATING = "employee_id";


    }


}
