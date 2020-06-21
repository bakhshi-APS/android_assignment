package pune.sicsr.assignment_tasks;

import androidx.appcompat.app.AppCompatActivity;
import pune.sicsr.assignment_tasks.database.DbContracts;
import pune.sicsr.assignment_tasks.database.EmpDbHelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class EmployeesActivity extends AppCompatActivity {


    private RatingBar empRate;

    // EditTexts

    private TextInputEditText empName, empSalary;

    EmpDbHelper empDbHelper = new EmpDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_two);
        empRate = findViewById(R.id.rating);
        empName = findViewById(R.id.emp_name);
        empSalary = findViewById(R.id.emp_salary);
    }

    public void insertToDb(View view) {


        SQLiteDatabase db = empDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DbContracts.TableEntries.EMP_NAME, empName.getText().toString());
        values.put(DbContracts.TableEntries.EMP_SALARY, String.valueOf(empSalary.getText()));
        values.put(DbContracts.TableEntries.EMP_RATING, String.valueOf(empRate.getRating()));
        long newRowId = db.insert(DbContracts.TableEntries.TABLE_NAME_EMPLOYEES, null, values);

        Log.i("Row Inserted: ", "" + newRowId);

        Toast.makeText(this, "Insert: " + empName.getText().toString() + "\nSuccess", Toast.LENGTH_LONG).show();
        // Clear the fields

        empName.setText("");
        empSalary.setText("");
        empRate.setRating(Float.parseFloat("0.0"));
    }
}
