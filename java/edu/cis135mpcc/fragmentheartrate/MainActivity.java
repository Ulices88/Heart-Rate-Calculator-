package edu.cis135mpcc.fragmentheartrate;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private outputFrag mOutputFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (getResources().getBoolean(R.bool.two_panel)){
            inputFrag input = new inputFrag();
            mOutputFrag = new outputFrag();

            transaction.replace(R.id.input_content,input);
            transaction.replace(R.id.output_content,mOutputFrag);
            transaction.commit();

        }else {

            inputFrag input = new inputFrag();
            transaction.replace(R.id.content, input);
            transaction.commit();

        }


    }

    public void calculate(View button) {


        TextView ageInput = (TextView) findViewById(R.id.age_input);


        int age_value = Integer.parseInt(ageInput.getText().toString());

         if (age_value == 0) {
            Toast.makeText(this, "Enter Valid Age", Toast.LENGTH_LONG).show();
            age_value = Integer.parseInt(ageInput.getText().toString());


        }

        if (!getResources().getBoolean(R.bool.two_panel)) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            outputFrag output = new outputFrag();

            output.setValues(age_value);
            transaction.addToBackStack("back to input");
            transaction.replace(R.id.content, output);
            transaction.commit();
        }else{
            mOutputFrag.setValues(age_value);

        }


    }
}
