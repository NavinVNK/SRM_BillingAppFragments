package com.comlu.navinsandroidtutorial.srm_billingappfragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ResultFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultFragment extends Fragment {


    TextView res;
    public ResultFragment() {
        // Required empty public constructor
    }

    void setResult(String result)
    {
         res.setText(result);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_result, container, false);
        res=(TextView)view.findViewById(R.id.resultText);
        Bundle bundle = this.getArguments();
        String i="";
        if (bundle != null) {
            i = bundle.getString("result", "0.0");
        }

        res.setText(i);
        return view;
    }



}
