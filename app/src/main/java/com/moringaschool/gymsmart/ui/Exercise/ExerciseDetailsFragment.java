package com.moringaschool.gymsmart.ui.Exercise;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.moringaschool.gymsmart.R;
import com.moringaschool.gymsmart.Result;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ExerciseDetailsFragment extends Fragment {

    @BindView(R.id.exerciseName) TextView mName;
    @BindView(R.id.exercise_desc) TextView mDescription;
    @BindView(R.id.category) TextView mCategory;
    @BindView(R.id.muscles_list) ListView mMuscles;
    @BindView(R.id.equipments_list) ListView mEquipments;
    @BindView(R.id.saveButton) Button saveExercise;

    private Result mExercise;


    public ExerciseDetailsFragment() {
        // Required empty public constructor
    }


    public static ExerciseDetailsFragment newInstance
            (Result result){

        ExerciseDetailsFragment exerciseDetailsFragment = new ExerciseDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable("exercise", Parcels.wrap(result));
        exerciseDetailsFragment.setArguments(args);
        return exerciseDetailsFragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mExercise = Parcels.unwrap(getArguments().getParcelable("exercise"));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_exercise_details,container,false);
        ButterKnife.bind(this,view);

        List<String> muscles = new ArrayList<>();
       

        return view;
    }

}