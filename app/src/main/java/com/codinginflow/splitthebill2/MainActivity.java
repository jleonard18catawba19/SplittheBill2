package com.codinginflow.splitthebill2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
double enterTotalBill;
int enterNumParty;
double enterTipAmnt;
double amountPerPerson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText bill = (EditText) findViewById(R.id.txtBill);
        final EditText tip = (EditText) findViewById(R.id.txtTipAmt);
        final EditText party = (EditText) findViewById(R.id.txtParty);
        final EditText total = (EditText) findViewById(R.id.txtResult);
        Button amount = (Button) findViewById(R.id.btnAmount);
        amount.setOnClickListener(new View.OnClickListener(){
            final TextView Amount = ((TextView) findViewById(R.id.txtResult));
            @Override
            public void onClick(View v){
                enterTotalBill = Double.parseDouble(bill.getText().toString());
                enterNumParty= Integer.parseInt(party.getText().toString());
                enterTipAmnt= Double.parseDouble(tip.getText().toString());
                amountPerPerson= ((enterTotalBill+(enterTotalBill*(enterTipAmnt/100)))/enterNumParty);
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                total.setText("Cost for is " + currency.format(amountPerPerson));



        }

    });

    }
}
