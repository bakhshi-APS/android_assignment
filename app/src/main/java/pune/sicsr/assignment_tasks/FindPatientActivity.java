package pune.sicsr.assignment_tasks;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import pune.sicsr.assignment_tasks.database.DbContracts;
import pune.sicsr.assignment_tasks.database.PatientDbHelper;

public class FindPatientActivity extends AppCompatActivity {

    TextView result;
    PatientDbHelper dbHelper = new PatientDbHelper(this);
    private TextInputEditText patientId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_patient);

        patientId = findViewById(R.id.patient_id);

        result = findViewById(R.id.result);

    }

    public void FindPatient(View view) {

        // Search patient by PatientId in the db


        String id = String.valueOf(patientId.getText());

        SQLiteDatabase db = dbHelper.getReadableDatabase();


        String[] projection = {
                DbContracts.TableEntries.PATIENT_ID,
                DbContracts.TableEntries.PATIENT_NAME,
                DbContracts.TableEntries.PATIENT_DOB
        };

        // Filter results WHERE "title" = 'My Title'


        String selection = DbContracts.TableEntries.PATIENT_ID + " = ?";
        String[] selectionArgs = {id};

        Cursor cursor = db.query(
                DbContracts.TableEntries.TABLE_NAME_PATIENTS,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );

        String resultDb = "";
        while (cursor.moveToNext()) {
            long patientId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(DbContracts.TableEntries.PATIENT_ID));
            String patientName = cursor.getString
                    (cursor.getColumnIndexOrThrow(DbContracts.TableEntries.PATIENT_NAME));
            String patientDob = cursor.getString
                    (cursor.getColumnIndexOrThrow(DbContracts.TableEntries.PATIENT_DOB));

            resultDb += DbContracts.TableEntries.PATIENT_ID + ":" +
                    patientId + "\n" + DbContracts.TableEntries.PATIENT_NAME + ":"
                    + patientName + "\n" + DbContracts.TableEntries.PATIENT_DOB + ":" + patientDob;

        }
        cursor.close();


        // check if found

        if (resultDb.isEmpty() || resultDb.equals("")) {
            result.setText("Patient Not Found");
        } else
            result.setText(resultDb);


    }
}
