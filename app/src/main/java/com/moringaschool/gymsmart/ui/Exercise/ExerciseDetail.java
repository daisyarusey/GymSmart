package com.moringaschool.gymsmart.ui.Exercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.moringaschool.gymsmart.ExercisePagerAdapter;
import com.moringaschool.gymsmart.R;
import com.moringaschool.gymsmart.Result;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExerciseDetail extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mViewPager;

    private ExercisePagerAdapter adapterViewPager;

    List<Result> exercises;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);
        ButterKnife.bind(this);

        exercises = Parcels.unwrap(getIntent().getParcelableExtra("exercises"));
        int startingPosition =getIntent().getIntExtra("position",0);

        adapterViewPager= new ExercisePagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,exercises);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
