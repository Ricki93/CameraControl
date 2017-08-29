package fhws.projektarbeit.arcontrolledcamera;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import fhws.projektarbeit.arcontrolledcamera.configuration.ConfigurationData;
import fhws.projektarbeit.arcontrolledcamera.fragments.FragmentControl;
import fhws.projektarbeit.arcontrolledcamera.fragments.SplashScreenFragment;

public class MainActivity extends Activity {

    private boolean debug = false;
    private ConfigurationData configurationData;
    private FragmentControl fragmentControl;

    public FragmentControl getFragmentControl(){return fragmentControl;};

    public ConfigurationData getConfigurationData(){
        return configurationData;
    }
    public void setConfigurationData(ConfigurationData value){
        configurationData = value;
    }

    public boolean getDebug(){
        return debug;
    }
    public void setDebug(boolean value){
        debug = value;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        this.fragmentControl = new FragmentControl(getFragmentManager(), R.id.main_fragment_container);
        this.fragmentControl.replaceFragment(fragmentControl.getSplashScreenFragment());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
    }


}
