package pune.sicsr.assignment_tasks;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import pune.sicsr.assignment_tasks.adapter.CustomRecyclerAdapter;
import pune.sicsr.assignment_tasks.database.DbContracts;
import pune.sicsr.assignment_tasks.database.FruitDbHelper;
import pune.sicsr.assignment_tasks.model.Fruit;

public class AddViewActivity extends AppCompatActivity
        implements View.OnClickListener {

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    List<Fruit> fruitList;


    FruitDbHelper fruitDbHelper = new
            FruitDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycleViewContainer);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        fruitList = new ArrayList<>();

        //Adding Data into ArrayList
        mAdapter = new CustomRecyclerAdapter(this, fruitList);
        recyclerView.setAdapter(mAdapter);

        // Reading from Database and displaying into RecyclerView
        ReadFromDatabase();


    }

    private void ReadFromDatabase() {


//        SQLiteOpenHelper dbHelper;
        SQLiteDatabase db = fruitDbHelper.getReadableDatabase();

        String[] projection = {
                DbContracts.TableEntries.FRUIT_NAME,
                DbContracts.TableEntries.FRUIT_ID
        };

        // Filter results WHERE "title" = 'My Title'


        Cursor cursor = db.query(
                DbContracts.TableEntries.TABLE_NAME_FRUITS,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );


        List itemIds = new ArrayList<>();
        while (cursor.moveToNext()) {
            long fruitid = cursor.getLong(
                    cursor.getColumnIndexOrThrow(DbContracts.TableEntries.FRUIT_ID));
            String fruitName = cursor.getString(cursor.getColumnIndexOrThrow(DbContracts.TableEntries.FRUIT_NAME));
            fruitList.add(new Fruit(fruitName, fruitid));

        }
        cursor.close();

    }

    @Override
    public void onClick(View v) {

        //TODO 1 create a box
        //TODO

        View promptView = this.getLayoutInflater().inflate(R.layout.dialog_add_fruit, null);
        final AlertDialog alertD = new AlertDialog.Builder(this).create();

        // EditTexts
        final TextInputEditText fName, fId;

        fName = promptView.findViewById(R.id.fruit_name);
        fId = promptView.findViewById(R.id.fruit_id);


        alertD.setView(promptView);
        alertD.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        // TODO Add to Database

                        SQLiteDatabase db = fruitDbHelper.getWritableDatabase();
                        ContentValues values = new ContentValues();
                        values.put(DbContracts.TableEntries.FRUIT_NAME, fName.getText().toString());
                        values.put(DbContracts.TableEntries.FRUIT_ID, fId.getText().toString());

                        // Insert the new row, returning the primary key value of the new row
                        long newRowId = db.insert(DbContracts.TableEntries.TABLE_NAME_FRUITS, null, values);

                        Log.i("Row Inserted: ", "" + newRowId);
//                        ReadFromDatabase();


                        // TODO refresh the recyclerView

//                        mAdapter.notifyItemInserted(fruitList.size());
                        fruitList.clear();
                        mAdapter.notifyDataSetChanged();
                        recyclerView.invalidate();
                        recyclerView.refreshDrawableState();
                        ReadFromDatabase();
                    }

                });

        alertD.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        alertD.dismiss();
                    }
                });

        alertD.setCancelable(false);
//        alertD.create();
        alertD.show();

    }

}
