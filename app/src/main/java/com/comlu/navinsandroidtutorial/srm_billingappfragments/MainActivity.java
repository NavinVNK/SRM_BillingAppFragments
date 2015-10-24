package com.comlu.navinsandroidtutorial.srm_billingappfragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements BillingFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String inputSystem;
        inputSystem = android.os.Build.ID;
        Log.d("hai",inputSystem);
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();  // deprecated
        Log.d("hai",width+"");
        Log.d("hai",height+"");
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        double x = Math.pow(width/dm.xdpi,2);
        double y = Math.pow(height/dm.ydpi,2);
        double screenInches = Math.sqrt(x+y);
        Log.d("hai","Screen inches : " + screenInches+"");
        WindowManager wm = getWindowManager();
        Display d = wm.getDefaultDisplay();
        if((d.getWidth() > d.getHeight())||screenInches > 6.9) {
            //--For Tablet
            setContentView(R.layout.activity_main);
        }
        else{
            //---For Mobiles
            setContentView(R.layout.activity_frame);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (findViewById(R.id.fragment_container) != null) {
            Log.d("Fragment", "Dynamic");
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

          //; Create an instance of ExampleFragment
            BillingFragment firstFragment = new BillingFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(String result) {
        if (findViewById(R.id.fragment_container) != null) {

            Fragment fr = new ResultFragment();

            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

             Bundle args = new Bundle();
             args.putString("result", result);
             fr.setArguments(args);
           /* BillingFragment fb=(BillingFragment)getFragmentManager().findFragmentById(R.id.billing_fragment);
            if(fb!=null)
            {
               ft.remove(fb);
            }*/

            ft.replace(R.id.fragment_container, fr);
         //   ft.addToBackStack(null);
            ft.commit();

        }
        else{
            ResultFragment fb=(ResultFragment)getFragmentManager().findFragmentById(R.id.result_fragment);
            if(fb!=null)
            {
                fb.setResult(result);
            }


        }

    }
}
