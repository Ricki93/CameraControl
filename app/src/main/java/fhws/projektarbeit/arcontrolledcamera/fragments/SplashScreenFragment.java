package fhws.projektarbeit.arcontrolledcamera.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;

import fhws.projektarbeit.arcontrolledcamera.MainActivity;
import fhws.projektarbeit.arcontrolledcamera.R;

//This is the fragment to dislay the loading screen
public class SplashScreenFragment extends Fragment implements View.OnClickListener {
    public static int SPLASH_SCREEN_TIMER = 3000;

    private int numberOfTimesSplashWasTouched = 0;

    private ImageView splashImage;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        View decorView = getActivity().getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        //Hide status bar
        //Listen to image view


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.splash_screen_layout, container, false);
        splashImage = (ImageView) view.findViewById(R.id.imgViewSplash);
        splashImage.setOnClickListener(this);
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();

        //
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                long timeToWait = System.currentTimeMillis() - startTime;
                if(timeToWait < SPLASH_SCREEN_TIMER){
                    //Use delayed posting by difference in current and start
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showConfigFragment();
                        }
                    }, SPLASH_SCREEN_TIMER - timeToWait);
                }
            }
        });

    }
    private void showConfigFragment()
    {

      //Show the configuration fragment
        FragmentControl fragmentControl =
        ((MainActivity)getActivity()).getFragmentControl();
        fragmentControl.replaceFragment(fragmentControl.getMainConfigurationFragment());
        //Toast.makeText(getContext(), "Debug message appearing after 3 seconds", Toast.LENGTH_SHORT).show();
    }




    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgViewSplash:
                numberOfTimesSplashWasTouched++;
                if(numberOfTimesSplashWasTouched > 5){
                    ((MainActivity) getActivity()).setDebug(true);
                    Toast.makeText(getContext(), "Debug activated", Toast.LENGTH_LONG).show();
                }
                return;
            default:
                break;
        }
    }
}

