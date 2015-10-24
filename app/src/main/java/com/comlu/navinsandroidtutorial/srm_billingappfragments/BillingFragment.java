package com.comlu.navinsandroidtutorial.srm_billingappfragments;

import android.app.Activity;
import android.app.Fragment;//support.v4.
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class BillingFragment extends Fragment {
    EditText v1;
    EditText v2;
    int discount=1;
    private OnFragmentInteractionListener mListener;
    public BillingFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_main, container, false);
        v1=(EditText)view.findViewById(R.id.editText);
        v2=(EditText)view.findViewById(R.id.editText1);
        RadioGroup radioGroup = (RadioGroup)view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public  void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioButton) {
                    discount = 10;
                    Toast.makeText(getActivity(), "10 % discount selected",
                            Toast.LENGTH_SHORT).show();
                }
                else if(checkedId==R.id.radioButton2) {
                    discount = 20;
                    Toast.makeText(getActivity(), "20 % discount selected",
                            Toast.LENGTH_SHORT).show();
                }



            }
        });
        Button submit=(Button)view.findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int val1=Integer.parseInt(v1.getText().toString());
                    int val2=Integer.parseInt(v2.getText().toString());
                    double result=val1+val2;
                    result=result-result*((double)discount/100);
                    Double res= new Double(result);
                    mListener.onFragmentInteraction(res.toString());


                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "One of the field entry is not entered or Wrongly entered",
                            Toast.LENGTH_SHORT).show();
                }



            }
        });
        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implemenet MyListFragment.OnItemSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String uri);
    }
}
