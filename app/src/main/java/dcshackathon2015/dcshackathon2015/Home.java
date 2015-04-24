package dcshackathon2015.dcshackathon2015;

<<<<<<< HEAD
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
=======
import android.content.Intent;
import android.database.Cursor;
>>>>>>> connecting_db
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
<<<<<<< HEAD
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
=======
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
>>>>>>> connecting_db


public class Home extends ActionBarActivity {

    private AutoCompleteTextView searchText;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
<<<<<<< HEAD

        sharedPreferences = getSharedPreferences("AmpalayaBitter", Context.MODE_PRIVATE);
        searchText = (AutoCompleteTextView) findViewById(R.id.searchLocationText);
        //populateAutoComplete();

        Button searchButton = (Button) findViewById(R.id.searchLocationButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = searchText.getText().toString();
                if(sanitizeText(location)){
                    searchLocation(location);
                }
            }
        });
    }

    public boolean sanitizeText(String t){
        Boolean valid = true;
        //valid = t.matches("[a-zA-Z0-9_@+.-]*");
        if(t.length() > 40 || t.length() < 1){
            valid = false;
            searchText.setError("Invalid input");
        }
        //searchText.setText(valid.toString());
        return valid;
    }

    public void searchLocation(String location){
        startActivity(new Intent(getApplicationContext(), Terminals.class));
        finish();
=======
>>>>>>> connecting_db
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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

    public void displayTerminal(View view){
        //Intent intent = new Intent(this, DBMethodHandler.class);
        //EditText editText = (EditText)findViewById(R.id.searchLocationButton);
        TextView terminalView = (TextView)findViewById(R.id.terminalView);
        //String toDisplay;
        DBHandler2 db = new DBHandler2(this);
        Cursor c = db.getTerminalItems();
        int count = c.getColumnCount();
        terminalView.setText(Integer.toString(count));
        c.close();
    }
}
