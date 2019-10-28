package com.moringaschool.gymsmart;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.gymsmart.ui.Exercise.ExerciseDetailFragment;

import java.util.List;

public class ExercisePagerAdapter extends FragmentPagerAdapter {

    private List<Result> mExercises;

    public ExercisePagerAdapter( FragmentManager fm, int behavior,List<Result>exercises) {
        super(fm, behavior);
        mExercises=exercises;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return ExerciseDetailFragment.newInstance(mExercises.get(position));
    }

    @Override
    public int getCount() {
        return mExercises.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mExercises.get(position).getName();
    }
}
