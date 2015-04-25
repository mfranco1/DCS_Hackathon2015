package dcshackathon2015.dcshackathon2015;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;


public class Destination extends ActionBarActivity {

    SharedPreferences sharedPreferences;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    String source, sourceTest, destination, destinationTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        sharedPreferences = getSharedPreferences("Ampalaya", Context.MODE_PRIVATE);
        source = sharedPreferences.getString("source", "");
        destination = sharedPreferences.getString("destination", "");

        if(source==""){
            source = "";
        }
        if(destination == ""){
            destination = "";
        }

        /*if(source == sharedPreferences){
            source = "";
        }
        if(destination == null){
            destination = "";
        }*/

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        Button home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Home.class));
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_destination, menu);
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

    public void prepareListData() {
        DBHandler2 dbHandler = new DBHandler2(this);
        Cursor c = dbHandler.getTerminalItems(source,destination);

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        List<String> l;
        int counter = 0;
        //if(c.moveToFirst()) {
        c.moveToFirst();
        while (c.isAfterLast()==false) {
            //System.out.println(c);
            listDataHeader.add(c.getString(c.getColumnIndex("origin")) + " - " + c.getString(c.getColumnIndex("destination")));
            l = new ArrayList<String>();
            l.add("Time available: " + c.getString(c.getColumnIndex("availability")));
            l.add("Average waiting time: " + c.getString(c.getColumnIndex("average_waiting_time")));
            l.add("Ave. waiting time (rush hour): " + c.getString(c.getColumnIndex("average_waiting_time_rush")));
            l.add("Average travel time: " + c.getString(c.getColumnIndex("average_travel_time")));
            l.add("Ave. travel time (rush hour): " + c.getString(c.getColumnIndex("average_travel_time_rush")));
            listDataChild.put(listDataHeader.get(counter), l);
            c.moveToNext();
            counter++;
        }
        c.close();
        //}

       /* List<String> top250;
        listDataHeader.add("Top 250");
        top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");
        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data

        listDataHeader.add("Now Showing");
        top250 = new ArrayList<String>();
        top250.add("The Conjuring");
        top250.add("Despicable Me 2");
        top250.add("Turbo");
        top250.add("Grown Ups 2");
        top250.add("Red 2");
        top250.add("The Wolverine");
        listDataChild.put(listDataHeader.get(1), top250);
*/

        /*
        // Adding child data
        listDataHeader.add("Top 250");
        listDataHeader.add("Now Showing");
        listDataHeader.add("Coming Soon..");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        */
    }
}
