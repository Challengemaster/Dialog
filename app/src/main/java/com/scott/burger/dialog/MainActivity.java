package com.scott.burger.dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    CharSequence[] items = {"Google","Apple","Microsoft"};
    boolean[] itemsChecked = new boolean[items.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.btn_dialog);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(0);
            }
        });
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 0:
                return new AlertDialog.Builder(this)
                        .setIcon(R.drawable.icon)
                        .setTitle("This is a dialog with some simple text...")
                        .setPositiveButton("OK", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton)
                            {
                                Toast.makeText(getBaseContext(),
                                        "OK clicked!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton)
                            {
                                Toast.makeText(getBaseContext(),
                                        "Cancel clicked!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setMultiChoiceItems(items, itemsChecked, new
                        DialogInterface.OnMultiChoiceClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked){
                                Toast.makeText(getBaseContext(),
                                        items[which]+(isChecked ? "Checked!":
                                        "Unchecked!"),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                        )
                        .create();


        }
        return null;
    }
}
