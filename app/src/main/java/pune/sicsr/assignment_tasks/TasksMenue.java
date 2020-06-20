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
        startActivity(new Intent(this, AddViewActivity.class));
    }

    public void goTaskTwo(View view) {
        startActivity(new Intent(this, TaskTwo.class));
    }

    public void goTaskThree(View view) {
        startActivity(new Intent(this, TaskThree.class));

    }

    public void goTaskFour(View view) {
        startActivity(new Intent(this, TaskFour.class));

    }
}
