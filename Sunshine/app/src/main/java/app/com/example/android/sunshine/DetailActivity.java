package app.com.example.android.sunshine;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //String detailForecastText = getIntent().getStringExtra("stringForecast");

        // Create a new fragment to put detailForecast into
        DetailActivityFragment detailFragment = new DetailActivityFragment();
        // Adds the extras in the intent to the fragment
        detailFragment.setArguments(getIntent().getExtras());

        // Call fragment manager to begin the process of replacing the fragment we first inflated
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment, detailFragment);
        transaction.addToBackStack(null);

        // Commit the transaction - replace the default fragment with the forecast detail.
        transaction.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        // Allows user to select settings activity
        if (id == R.id.action_settings) {
            // Create an intent to launch the settings activity when we click on an item in menu
            Intent settingsView = new Intent(this, SettingsActivity.class);
            startActivity(settingsView);
            Log.v("Sunshine", "settings");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
