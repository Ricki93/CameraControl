package fhws.projektarbeit.arcontrolledcamera.fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import fhws.projektarbeit.arcontrolledcamera.R;


//Main Fragment for wifi configuration
public class WiFiConfigurationFragment extends Fragment implements OnClickListener {

    //wifi manager components
    private WifiManager wifiManager;
    private WifiInfo wifiInfo;

    //View components
    private Button commitWifiButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //TODO wifi components
        wifiManager = (WifiManager) getActivity().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiInfo = wifiManager.getConnectionInfo();



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.config_wifi_layout, container, false);
        commitWifiButton = view.findViewById(R.id.btnCommitWifiSelection);
        commitWifiButton.setOnClickListener(this);

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        //TODO improve fragment manipulation
        switch(item.getItemId()){
            case R.id.home:
                showMainConfigurationFragment();
                break;
            default:
                break;
        }
        return true;
    }

    private void showMainConfigurationFragment() {

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnCommitWifiSelection:
                commitWifiSelection();
                break;
            default:
                break;
        }
    }

    private void commitWifiSelection() {

    }
}
