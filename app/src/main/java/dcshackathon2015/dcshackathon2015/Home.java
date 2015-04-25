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
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class Home extends ActionBarActivity {

    SharedPreferences sharedPreferences;
    private AutoCompleteTextView source;
    private AutoCompleteTextView destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPreferences = getSharedPreferences("Ampalaya", Context.MODE_PRIVATE);

        source = (AutoCompleteTextView) findViewById(R.id.searchSourceText);
        destination = (AutoCompleteTextView) findViewById(R.id.searchDestinationText);
        //populateAutoComplete();
        Button search = (Button) findViewById(R.id.searchLocationButton);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(sanitizeText(source.getText().toString(),destination.getText().toString())){
                    if(!isEmpty(source.getText().toString()) && isEmpty(destination.getText().toString())){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("source",source.getText().toString());
                        editor.commit();
                        startActivity(new Intent(getApplicationContext(), Destination.class));
                        finish();
                    }
                    else if(!isEmpty(destination.getText().toString()) && isEmpty(source.getText().toString())){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("destination",destination.getText().toString());
                        editor.commit();
                        startActivity(new Intent(getApplicationContext(), Destination.class));
                        finish();
                    }
                    else{
                        externalWrite(source.getText().toString(),destination.getText().toString());
                        startActivity(new Intent(getApplicationContext(), Destination.class));
                        finish();
                    }
                }
                else{
                    if(isEmpty(source.getText().toString())){
                        source.setError("Empty field is not valid");
                    }
                    if(isEmpty(destination.getText().toString())){
                        destination.setError("Empty field is not valid");
                    }
                }
            }
        }); //END
    }

    public void externalWrite(String t1, String t2){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("source",t1);
        editor.putString("destination",t2);
        editor.commit();
    }

    public boolean sanitizeText(String t1, String t2){
        Boolean valid = true;
        //valid = t1.matches("[a-zA-Z\\s]");
        //valid = t2.matches("[a-zA-Z\\s]");
        if((t1.length() > 40 || t2.length() > 40) || (isEmpty(t1) && isEmpty(t2))){
            valid = false;
        }
        //source.setText(valid.toString());
        return valid;
    }

    public boolean isEmpty(String t){
        Boolean empty = true;
        if(t.length() > 0){
            empty = false;
        }
        return empty;
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

    /*
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
    }*/
}
