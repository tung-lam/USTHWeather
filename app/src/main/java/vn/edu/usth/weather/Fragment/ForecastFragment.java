package vn.edu.usth.weather.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.weather.R;

public class ForecastFragment extends Fragment {
    public ForecastFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View v = new View(getContext());
        View v = inflater.inflate(R.layout.fragment_forecast,container,false);
//        v.setBackgroundColor(0x20FF0000);
        return v;


//        LinearLayout linearLayout = new LinearLayout(getContext());
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//
//        TextView textView = new TextView(getContext());
//        textView.setText("Thursday");
//
//        ImageView imageView = new ImageView(getContext());
//        imageView.setImageResource(R.drawable.icon01);
//
//        linearLayout.addView(textView);
//        linearLayout.addView(imageView);
//
//        return linearLayout;
    }
}
