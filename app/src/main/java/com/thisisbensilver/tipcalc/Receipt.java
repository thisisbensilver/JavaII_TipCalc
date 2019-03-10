package com.thisisbensilver.tipcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Receipt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        this.setTitle(R.string.titleReceipt);

        NumberFormat df = new DecimalFormat("$#.00");

        Intent mIntent = getIntent();
        Bundle extras = mIntent.getExtras();

        Double bill = extras.getDouble("KEY_BILL");
        Double taxRate = extras.getDouble("KEY_TAX");
        Double tipRate = extras.getDouble("KEY_TIP");

        Double tax = bill*taxRate;
        Double tip = bill*tipRate;
        Double grandTotal = bill + tip + tax;

        ((TextView) findViewById(R.id.id_bill_total_r)).setText(getResources().getString( R.string.labelTotal) + " " + df.format(bill));
        ((TextView) findViewById(R.id.id_tax_total_r)).setText(getResources().getString( R.string.labelTax) + " " + df.format(tax));
        ((TextView) findViewById(R.id.id_tip_total_r)).setText(getResources().getString( R.string.labelTip) + " " + df.format(tip));
        ((TextView) findViewById(R.id.id_grand_total_r)).setText(getResources().getString( R.string.labelGrandTotal) + " " + df.format(grandTotal));

        int i = 0;

    }
}
