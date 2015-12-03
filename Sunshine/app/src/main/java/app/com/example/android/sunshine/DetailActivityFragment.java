package app.com.example.android.sunshine;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        // Read the forecast string passed by the intent to the activity to this fragment
        if (this.getArguments() != null) {
            String forecast = this.getArguments().getString("stringForecast");
            TextView textViewToChange = (TextView) rootView.findViewById(R.id.detailForecastTextView);
            textViewToChange.setText(forecast+" hello");
        }
        return rootView;
    }
}
