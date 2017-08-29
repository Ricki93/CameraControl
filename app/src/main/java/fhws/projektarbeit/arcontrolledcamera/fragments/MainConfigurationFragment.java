package fhws.projektarbeit.arcontrolledcamera.fragments;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import fhws.projektarbeit.arcontrolledcamera.MainActivity;
import fhws.projektarbeit.arcontrolledcamera.R;
import fhws.projektarbeit.arcontrolledcamera.configuration.ConfigurationData;


/**
 * Main config fragment
 */

public class MainConfigurationFragment extends Fragment implements View.OnClickListener {

    private Button configureWifiButton;
    private Button configureBluetoothButton;
    private TextView wifiText;
    private TextView bluetoothText;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //TODO remove if nothing comes up
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.config_main_layout, container, false);
        //Find and assign UI elements
        configureWifiButton = (Button)view.findViewById(R.id.btnConfigreWifi);
        configureBluetoothButton = (Button) view.findViewById(R.id.btnConfigureBluetooth);
        wifiText = (TextView) view.findViewById(R.id.txtViewConfiguredDeviceWiFi);
        bluetoothText = (TextView) view.findViewById(R.id.txtViewConfiguredDeviceBlueTooth);
        //Set event listeners
        configureWifiButton.setOnClickListener(this);
        configureBluetoothButton.setOnClickListener(this);

        //setup navigation


        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onClick(View view) {
        FragmentControl fragmentControl = ((MainActivity) getActivity()).getFragmentControl();
        switch(view.getId()){
            case R.id.btnConfigreWifi:
                fragmentControl.replaceFragment(fragmentControl.getWiFiConfigurationFragment());
                break;
            case R.id.btnConfigureBluetooth:
                break;
            default:
                break;
        }
    }
}
