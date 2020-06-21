package pune.sicsr.assignment_tasks;

import androidx.appcompat.app.AppCompatActivity;
import pune.sicsr.assignment_tasks.database.DbContracts;
import pune.sicsr.assignment_tasks.database.DoctDbHelper;
import pune.sicsr.assignment_tasks.model.Fruit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ViewDoctors extends AppCompatActivity {


    Spinner specializationSpinner;

    DoctDbHelper dbHelper = new DoctDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_doctors);
        specializationSpinner = findViewById(R.id.doc_specialize_spinner);

        loadDataIntoSpinner();

    }

    private void loadDataIntoSpinner() {

//        SQLiteDatabase db = dbHelper.getReadableDatabase();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                DbContracts.TableEntries.DOCT_SPECIALIZE,
                DbContracts.TableEntries.DOCT_SPECIALIZE_ID
        };

        // Filter results WHERE "title" = 'My Title'


        Cursor cursor = db.query(
                DbContracts.TableEntries.TABLE_NAME_DOCTORS,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );


        // Retrieve data from db

        List<String> doctSpecializeList = new ArrayList<>();

        // Add the first Item as always 'Select Doctor Specialization'


        doctSpecializeList.add("Select Doctor Specialization");

        while (cursor.moveToNext()) {
            String doctSpecialize = cursor.getString
                    (cursor.getColumnIndexOrThrow(DbContracts.TableEntries.DOCT_SPECIALIZE));
            doctSpecializeList.add(doctSpecialize);
        }
        cursor.close();


        // Initializing spinner with adapter

        ArrayAdapter<String> spinnerDataAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, doctSpecializeList);

        spinnerDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        specializationSpinner.setAdapter(spinnerDataAdapter);
    }
}
