package chsieh099.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by CassidyHsieh on 2/4/16.
 */
public class ListAdapter extends BaseAdapter {

    public Context context;

    public String[] exercises = new String[] {
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
    public int numExercises = exercises.length;

    public ListAdapter (Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return numExercises;
    }

    @Override
    public String getItem(int position) {
        return exercises[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater creator = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = creator.inflate(R.layout.exercise_list, null);
        }
        TextView ex = (TextView) convertView.findViewById(R.id.textView4);
        ex.setText(getItem(position));
        int calories = MainActivity.cal;
        int numTimes = 0;
        int repsMins = 0;
        if (getItem(position) == "Pushups") {
            numTimes = calories * 350 / 100;
            repsMins = 0;
        } if (getItem(position) == "Situps") {
            numTimes = calories * 200 / 100;
            repsMins = 0;
        } if (getItem(position) == "Squats") {
            numTimes = calories * 225 / 100;
            repsMins = 0;
        } if (getItem(position) == "Leg-Lifts") {
            numTimes = calories * 25 / 100;
            repsMins = 1;
        } if (getItem(position) == "Planks") {
            numTimes = calories * 25 / 100;
            repsMins = 1;
        } if (getItem(position) == "Jumping Jacks") {
            numTimes = calories * 10 / 100;
            repsMins = 1;
        } if (getItem(position) == "Pullups") {
            numTimes = calories * 100 / 100;
            repsMins = 0;
        } if (getItem(position) == "Cycling") {
            numTimes = calories * 12 / 100;
            repsMins = 1;
        } if (getItem(position) == "Walking") {
            numTimes = calories * 20 / 100;
            repsMins = 1;
        } if (getItem(position) == "Jogging") {
            numTimes = calories * 12 / 100;
            repsMins = 1;
        } if (getItem(position) == "Swimming") {
            numTimes = calories * 13 / 100;
            repsMins = 1;
        } if (getItem(position) == "Stair-Climbing") {
            numTimes = calories * 15 / 100;
            repsMins = 1;
        }
        TextView num = (TextView) convertView.findViewById(R.id.textView5);
        TextView repsOrMins = (TextView) convertView.findViewById(R.id.textView6);
        if (repsMins == 0) {
            repsOrMins.setText("reps");
        } else {
            repsOrMins.setText("minutes");
        }
        num.setText(Integer.toString(numTimes));

        return convertView;
    }
}
