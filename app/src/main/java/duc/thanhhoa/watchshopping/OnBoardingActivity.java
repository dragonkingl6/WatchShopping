package duc.thanhhoa.watchshopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.LinearLayout;

import duc.thanhhoa.watchshopping.adapter.SliderAdapter;

public class OnBoardingActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);

        //call adapter

        sliderAdapter= new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
    }
}