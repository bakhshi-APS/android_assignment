package pune.sicsr.assignment_tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TasksMenue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_menu);
    }

    public void goTaskOne(View view) {
        startActivity(new Intent(this, AddViewFruits.class));
    }

    public void goTaskTwo(View view) {
        startActivity(new Intent(this, EmployeesActivity.class));
    }

    public void goTaskThree(View view) {
        startActivity(new Intent(this, DoctorsActivity.class));

    }

    public void goTaskFour(View view) {
        startActivity(new Intent(this, PatientsActivity.class));

    }
}
