package com.example.android.sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.android.sqlite.Data.tourContract.tourEntry;

import com.example.android.sqlite.Data.tourContract;
import com.example.android.sqlite.Data.tourDbHelper;

import static android.R.attr.y;

public class MainActivity extends AppCompatActivity {
    private EditText date , name,dname ,oName,nName;
    private String name1,date1,dname1;
    private TextView txt=null,txt1=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = (EditText)findViewById(R.id.date);
        name = (EditText)findViewById(R.id.name);
        txt = (TextView)findViewById(R.id.txt);
        txt1 = (TextView)findViewById(R.id.txt1);
        dname = (EditText) findViewById(R.id.txt2);
        oName = (EditText) findViewById(R.id.txt3);
        nName = (EditText) findViewById(R.id.txt4);

    }
    public void dbinsert(View view){
        tourDbHelper  tdb = new tourDbHelper(this);
        name1 = name.getText().toString();
        date1 = date.getText().toString();

        tdb.insert(tdb,name1,date1);
        date.setText("");
        name.setText("");
    }
    public void dbSelect(View view){
        tourDbHelper  tdb = new tourDbHelper(this);
        Cursor cr = tdb.select(tdb);
        cr.moveToFirst();
        txt.setText("");
        txt1.setText("");
        do {
            txt.append(cr.getString(cr.getColumnIndex(tourEntry.NAME)));
            txt1.append(cr.getString(cr.getColumnIndex(tourEntry.DATE)));
        }while (cr.moveToNext());
        cr.close();
    }

    public void dbdelete(View view){
        tourDbHelper  tdb = new tourDbHelper(this);
        dname1 = dname.getText().toString();
        tdb.delete(tdb,dname1);
    }
    public void dbUpdate(View view){
        String newName = nName.getText().toString();
        String oldName = oName.getText().toString();
        tourDbHelper tdb = new tourDbHelper(this);
        tdb.update(tdb,oldName,newName);
    }
}
