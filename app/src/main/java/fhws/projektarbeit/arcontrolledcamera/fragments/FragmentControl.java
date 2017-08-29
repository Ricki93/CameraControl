package fhws.projektarbeit.arcontrolledcamera.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import fhws.projektarbeit.arcontrolledcamera.configuration.BluetoothConfigurationData;

/**
 * Main fragment control
 */

public class FragmentControl {
    //Main fragment
    private MainConfigurationFragment mainConfigurationFragment;
    //Splash fragment
    private SplashScreenFragment splashScreenFragment;
    //WiFi fragments
    private WiFiConfigurationFragment wiFiConfigurationFragment;

    //Bluetooth fragments
    private BlueToothConfigurationFragment blueToothConfigurationFragment;

    //manager and container
    private int containerID;
    private FragmentManager fragmentManager;
    private int activeFragment;

    public FragmentControl(FragmentManager fragmentManager, int containerID){
        this.fragmentManager = fragmentManager;
        this.containerID = containerID;
        initializeFragments();
    }

    public void replaceFragment(Fragment fragment)
    {


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerID, fragment);

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    private void initializeFragments(){

        this.mainConfigurationFragment = new MainConfigurationFragment();
        this.splashScreenFragment = new SplashScreenFragment();
        this.wiFiConfigurationFragment = new WiFiConfigurationFragment();
        this.blueToothConfigurationFragment = new BlueToothConfigurationFragment();
    }

    public MainConfigurationFragment getMainConfigurationFragment() {
        return mainConfigurationFragment;
    }
    public WiFiConfigurationFragment getWiFiConfigurationFragment(){
        return wiFiConfigurationFragment;
    }
    public BlueToothConfigurationFragment getBlueToothConfigurationFragment(){
        return blueToothConfigurationFragment;
    }
    public SplashScreenFragment getSplashScreenFragment(){
        return splashScreenFragment;
    }

    public void ReturnToPreviousFragment(){

    }

}
