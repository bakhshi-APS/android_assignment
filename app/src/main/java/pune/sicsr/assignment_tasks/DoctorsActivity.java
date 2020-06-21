package pune.sicsr.assignment_tasks;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import pune.sicsr.assignment_tasks.database.DbContracts;
import pune.sicsr.assignment_tasks.database.DoctDbHelper;

public class DoctorsActivity extends AppCompatActivity {

    private TextInputEditText doctSpecialize, doctId;


    DoctDbHelper doctDbHelper = new DoctDbHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_three);

        doctSpecialize = findViewById(R.id.doc_specialize);
        doctId = findViewById(R.id.doc_id);

    }

    public void insertToDb(View view) {


        // INSERT INTO DATABASE

        SQLiteDatabase db = doctDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbContracts.TableEntries.DOCT_SPECIALIZE, doctSpecialize.getText().toString());
        values.put(DbContracts.TableEntries.DOCT_SPECIALIZE_ID, String.valueOf(doctId.getText()));

        long newRowId = db.insert(DbContracts.TableEntries.TABLE_NAME_DOCTORS, null, values);
        Log.i("Row Inserted: ", "" + newRowId);
        Toast.makeText(this, "Insert: " + doctSpecialize.getText().toString() + "\nSuccess", Toast.LENGTH_LONG).show();

    }


    public void goToSpinnerControl(View view) {


        startActivity(new Intent(this, ViewDoctors.class));


    }
}
