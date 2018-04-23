package edu.cis135mpcc.fragmentheartrate;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class outputFrag extends Fragment {
    private int mAgeValue;


    public outputFrag() {
        // Required empty public constructor
    }



    public void setValues(int age ){

    mAgeValue = age;
    setOutput();

    }

    private void setOutput(){

        View view = getView();
        if (view == null)
            return;



        int age = mAgeValue;


        int max = 220 - age;


        TextView outputMax = (TextView) view.findViewById(R.id.output_max);

        outputMax.setText(getString(R.string.Max_String) + "\n" + max + " Beats Per Minute");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_output, container, false);
    }




    @Override
    public void onStart() {
        super.onStart();
        setOutput();


    }


}
