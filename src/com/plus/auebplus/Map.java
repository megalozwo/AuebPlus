package com.plus.auebplus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;



 
public class Map extends FragmentActivity implements LocationListener   {
	 // Google Map 
	private LatLng center = new LatLng(37.993988,23.731903); 
	LatLng southEast = new LatLng(37, 24.0);
	LatLng northWest = new LatLng(38.5,23);
    private GoogleMap googleMap;
    LocationManager locationManager;
    boolean GPSenabled;
    //My location
    LatLng mylatLng;
    Marker[] markers = new Marker[12];
    AlertDialog alert;

    
    OnInfoWindowClickListener iwListener = new OnInfoWindowClickListener() {
		
    	@Override
    	public void onInfoWindowClick(Marker marker) {
    		// TODO Auto-generated method stub
    		LatLng markerPosition=marker.getPosition();
    		Intent intent = new Intent(android.content.Intent.ACTION_VIEW, 
    			    Uri.parse("http://maps.google.com/maps?saddr="+mylatLng.latitude+","+mylatLng.longitude+
    			    		"&daddr="+markerPosition.latitude+","+markerPosition.longitude));
    			startActivity(intent);
    	}
	};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
      //Get my Location
        
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        GPSenabled = locationManager
        		  .isProviderEnabled(LocationManager.GPS_PROVIDER);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        Location myLocation = locationManager.getLastKnownLocation(provider);
        mylatLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());   
      
   
             try {
                 // Loading map
                 initilizeMap();
             } catch (Exception e) {
                 e.printStackTrace();
             }
    }
    @Override
    protected void onResume() {
        super.onResume();
        //initilizeMap();
    }
 
    
  

	/**
     * function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap() {
    	if(GPSenabled){
    		//setContentView(R.layout.map);
        	
             if (googleMap == null) {
            	 SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager()
        			.findFragmentById(R.id.mapfrag);

        	googleMap = mapFrag.getMap();
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
            Toast.makeText(getApplicationContext(),
                    "The Map is Loading... this may take a while", Toast.LENGTH_LONG)
                    .show();
            googleMap.getUiSettings().setZoomControlsEnabled(false); // true to enable
            googleMap.setMyLocationEnabled(true); // false to disable
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
           
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 10));
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);
            
            addMarkers();
            showAlertDialog2();
            
        	}
    	}else{
        	showAlertDialog();
        }
   
    }
 
 
    
    
    
    private void addMarkers() {
  		// TODO Auto-generated method stub
      
    	markers[0] = googleMap.addMarker(new MarkerOptions().position(new LatLng(37.993988, 23.731903)).title("Οικονομικό Πανεπιστήμιο Αθηνών"));
    	markers[0].showInfoWindow();
        markers[1] =googleMap.addMarker(new MarkerOptions().position(new LatLng(37.995545, 23.733054)).title("Κτήριο επί της οδού Δεριγνύ"));
        markers[2] =googleMap.addMarker(new MarkerOptions().position(new LatLng(37.996112, 23.737249)).title("Κτήριο επί της οδού Ύδρας"));     
        markers[3] =googleMap.addMarker (new MarkerOptions().position(new LatLng(37.996129, 23.739757)).title("Κτήριο Μεταπτυχιακών Σπουδών ΟΠΑ"));      
        markers[4] =googleMap.addMarker(new MarkerOptions().position(new LatLng(37.984697, 23.737439)).title("Εκδόσεις Rosili"));     
        markers[5] =googleMap.addMarker( new MarkerOptions().position(new LatLng(37.99251, 23.731045)).title("Εκδόσεις Ε.Μπένου"));   
        markers[6] =googleMap.addMarker(new MarkerOptions().position(new LatLng(37.983475, 23.736444)).title("Εκδόσεις Gutenberg-Τυπωθήτω"));    
        markers[7] =googleMap.addMarker(new MarkerOptions().position(new LatLng(37.981044, 23.731013)).title("Εκδόσεις ZHTH"));    
        markers[8] =googleMap.addMarker(new MarkerOptions().position(new LatLng(37.981044, 23.731520)).title("Εκδόσεις Κλειδάριθμος"));      
        markers[9] =googleMap.addMarker(new MarkerOptions().position(new LatLng(37.988705, 23.73046)).title("Εκδόσεις Σταμούλη"));      	
        markers[10] =googleMap.addMarker(new MarkerOptions().position(new LatLng(37.984849, 23.735102)).title("Πανεπιστημιακές Εκδόσεις Κρήτης"));      	
        markers[11] =googleMap.addMarker(new MarkerOptions().position(new LatLng(37.984849, 23.735102)).title("Εκδόσεις ΙΩΝ"));    
       
        googleMap.setOnInfoWindowClickListener(iwListener);
    }



	


	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

	public void showAlertDialog(){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				Map.this);
 
			// set title
			alertDialogBuilder.setTitle("Aueb Plus");
 
			// set dialog message
			alertDialogBuilder
				.setMessage("Your GPS sensor is not enabled. If you want to use this service, you need to enable it " +
        			"through your phone's settings and try again")
				.setCancelable(false)
				.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						Map.this.finish();
					}
				  });
				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();
			}
	public void showAlertDialog2(){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				Map.this);
 
			// set title
			alertDialogBuilder.setTitle("Aueb Plus");
 
			// set dialog message
			alertDialogBuilder
				.setMessage("- Click on a Marker to see the location's name."+"\n"+"- Click on the name pop-up to get" +
						" directions")
				.setCancelable(false)
				.setNegativeButton("Ok",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
							
					}
				  });
				AlertDialog alert = alertDialogBuilder.create();
				alert.show();
			}
	
	

}