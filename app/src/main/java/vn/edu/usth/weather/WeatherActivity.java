package vn.edu.usth.weather;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import vn.edu.usth.weather.Fragment.ForecastFragment;
import vn.edu.usth.weather.Fragment.WeatherAndForecast;
import vn.edu.usth.weather.Fragment.WeatherFragment;

public class WeatherActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i("WeatherActivity", "onCreate: This is a log message.");

        PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);

        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        mediaPlayer = MediaPlayer.create (this, R.raw.kiss_the_rain);
        mediaPlayer.start();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

//        String filePath = Environment.getExternalStorageDirectory()+"/music/kiss_the_rain.mp3";
//        mediaPlayer = MediaPlayer.create(this, Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "/music/kiss_the_rain.mp3"));

//        try {
//            mediaPlayer.setDataSource(filePath);
//            mediaPlayer.prepare();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), "kiss_the_rain.mp3");
//        mediaPlayer = new MediaPlayer();
//        try {
//            mediaPlayer.setDataSource(file.getAbsolutePath());
//            mediaPlayer.prepare();
//            mediaPlayer.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//        ForecastFragment forecastFragment = new ForecastFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.container, forecastFragment).commit();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
        Log.i("WeatherActivity", "onPause: This is a log message.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("WeatherActivity", "onDestroy: This is a log message.");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mediaPlayer.reset();
        Log.i("WeatherActivity", "onResume: This is a log message.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("WeatherActivity", "onStart: This is a log message.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("WeatherActivity", "onStop: This is a log message.");
    }

    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 3;
        private String titles[] = new String[] { "Hanoi", "Paris", "Toulouse" };
        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return PAGE_COUNT; // number of pages for a ViewPager
        }
        @Override
        public Fragment getItem(int page) {
            return new WeatherAndForecast();
// returns an instance of vn.edu.usth.weather.Fragment corresponding to the specified page
//        switch (page) {
//            case 0: return WeatherAndForecast.newInstance();
//            case 1: return WeatherAndForecast.newInstance();
//            case 2: return WeatherAndForecast.newInstance();
//        }
//        return new EmptyFragment(); // failsafe
        }
        @Override
        public CharSequence getPageTitle(int page) {
// returns a tab title corresponding to the specified page
            return titles[page];
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                // do something when search is pressed here
                return true;
            case R.id.action_refresh:
                CharSequence text = "Refreshing";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(this, text, duration);
                toast.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
