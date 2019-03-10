package com.thisisbensilver.tipcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle(R.string.titleMain);
    }

    public void calcTotals(View view) {

            Intent mIntent = new Intent(this, Receipt.class);

           Bundle extras = new Bundle();


            Double x = Double.parseDouble(((EditText) findViewById(R.id.id_bill_total)).getText().toString());

        extras.putDouble("KEY_BILL", Double.parseDouble(((EditText) findViewById(R.id.id_bill_total)).getText().toString()) );
        extras.putDouble("KEY_TAX", Double.parseDouble(((EditText) findViewById(R.id.id_tax_rate)).getText().toString()) );
        extras.putDouble("KEY_TIP", Double.parseDouble(((EditText) findViewById(R.id.id_tip_rate)).getText().toString()) );



        extras.putString("KEY_TEST","okay");
     //   Toast.makeText(this, "" + Double.parseDouble(((EditText) findViewById(R.id.id_bill_total)).getText().toString())  , Toast.LENGTH_LONG).show();


mIntent.putExtras(extras);


            if (mIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mIntent);
            }

        }
    }

