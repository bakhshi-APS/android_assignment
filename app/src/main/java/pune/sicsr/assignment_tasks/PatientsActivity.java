package pune.sicsr.assignment_tasks;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import pune.sicsr.assignment_tasks.database.DbContracts;
import pune.sicsr.assignment_tasks.database.PatientDbHelper;

public class PatientsActivity extends AppCompatActivity {


    PatientDbHelper dbHelper = new PatientDbHelper(this);
    private TextInputEditText patientName, patientId, patientDob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_four);

        patientDob = findViewById(R.id.patient_dob);
        patientId = findViewById(R.id.patient_id);
        patientName = findViewById(R.id.patient_name);


    }

    public void insertToDb(View view) {


        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DbContracts.TableEntries.PATIENT_ID, String.valueOf(patientId.getText()));
        values.put(DbContracts.TableEntries.PATIENT_NAME, patientName.getText().toString());
        values.put(DbContracts.TableEntries.PATIENT_DOB, patientDob.getText().toString());

        long newRowId = db.insert(DbContracts.TableEntries.TABLE_NAME_PATIENTS, null, values);
        Log.i("Row Inserted: ", "" + newRowId);
        Toast.makeText(this, "Insert: " + patientName.getText().toString() + "\nSuccess", Toast.LENGTH_LONG).show();


        // Clearing the fields
        patientName.getText().clear();
        Objects.requireNonNull(patientId.getText()).clear();
        patientDob.getText().clear();
    }

    public void goToFindPatient(View view) {


        startActivity(new Intent(this, FindPatientActivity.class));


    }
}
