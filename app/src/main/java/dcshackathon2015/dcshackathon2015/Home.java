package dcshackathon2015.dcshackathon2015;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class Home extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
        //int count = c.getColumnCount();
        //terminalView.setText(Integer.toString(count));
        c.close();
    }
}
