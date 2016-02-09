package chsieh099.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    public String[] arraySpinner;
    public int exerciseType = 0; //0 for reps, 1 for mins
    public String exercise;
    public int input;
    public static int cal = 0;
    public ListAdapter list = new ListAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.arraySpinner = new String[]{
                "Pushups",          //reps
                "Situps",           //reps
                "Squats",           //reps
                "Leg-Lifts",        //mins
                "Planks",           //mins
                "Jumping Jacks",    //mins
                "Pullups",          //reps
                "Cycling",          //mins
                "Walking",          //mins
                "Jogging",          //mins
                "Swimming",         //mins
                "Stair-Climbing"    //mins
        };

        Spinner exerciseSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exerciseSpinner.setAdapter(adapter);

        exerciseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                exercise = (String) parent.getItemAtPosition(position);
                if (exercise == "Pushups" || exercise == "Situps" ||
                        exercise == "Squats" || exercise == "Pullups") {
                    exerciseType = 0;
                    refresh();
                } else {
                    exerciseType = 1;
                    refresh();
                }
            }

            public void onNothingSelected(AdapterView parent) {
            }
        });

        EditText editText = (EditText) findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s == null || s.toString().equals("")) {
                    input = 0;
                    refresh();
                }
                if (s != null && !s.toString().equals("")) {
                    input = Integer.parseInt(s.toString());
                    refresh();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        GridView lv = (GridView) findViewById(R.id.gridView);
        lv.setAdapter(list);
    }

    public void refresh() {
        TextView repOrMin = (TextView) findViewById(R.id.textView3);
        if (exerciseType == 0) {
            repOrMin.setText("reps");
        } else {
            repOrMin.setText("minutes");
        }

        TextView calories = (TextView) findViewById(R.id.textView);
        if (exercise == "Pushups") {
            cal = input * 100 / 350;
        } if (exercise == "Situps") {
            cal = input * 100 / 200;
        } if (exercise == "Squats") {
            cal = input * 100 / 225;
        } if (exercise == "Leg-Lifts") {
            cal = input * 100 / 25;
        } if (exercise == "Planks") {
            cal = input * 100 / 25;
        } if (exercise == "Jumping Jacks") {
            cal = input * 100 / 10;
        } if (exercise == "Pullups") {
            cal = input * 100 / 100;
        } if (exercise == "Cycling") {
            cal = input * 100 / 12;
        } if (exercise == "Walking") {
            cal = input * 100 / 20;
        } if (exercise == "Jogging") {
            cal = input * 100 / 12;
        } if (exercise == "Swimming") {
            cal = input * 100 / 13;
        } if (exercise == "Stair-Climbing") {
            cal = input * 100 / 15;
        }
        calories.setText(Integer.toString(cal));
        list.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
