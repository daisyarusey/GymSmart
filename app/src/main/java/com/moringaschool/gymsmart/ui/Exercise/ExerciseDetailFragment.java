package com.moringaschool.gymsmart.ui.Exercise;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.moringaschool.gymsmart.Equipment;
import com.moringaschool.gymsmart.Muscle;
import com.moringaschool.gymsmart.R;
import com.moringaschool.gymsmart.Result;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExerciseDetailFragment extends Fragment {
    @BindView(R.id.exerciseName) TextView mName;
    @BindView(R.id.exercise_desc) TextView mDescription;
    @BindView(R.id.category) TextView mCategory;
    @BindView(R.id.muscles) TextView mMuscles;
    @BindView(R.id.equipments) TextView mEquipments;
    @BindView(R.id.saveExerciseButton) Button saveExercise;

    private Result mExercise;


    public ExerciseDetailFragment() {
        // Required empty public constructor
    }

    public static ExerciseDetailFragment newInstance
            (Result exercise){

        ExerciseDetailFragment exerciseDetailsFragment = new ExerciseDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("exercise", Parcels.wrap(exercise));
        exerciseDetailsFragment.setArguments(args);
        return exerciseDetailsFragment;

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mExercise = Parcels.unwrap(getArguments().getParcelable("exercises"));
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise_detail,container,false);
        ButterKnife.bind(this,view);

        List<String> muscles = new ArrayList<>();
        List<String> equipments = new ArrayList<>();

        for (Muscle muscle: mExercise.getMuscles()){
            muscles.add(muscle.getName());
        }
        for (Equipment equipment: mExercise.getEquipment()){
            equipments.add(equipment.getName());
        }

        mName.setText(mExercise.getName());
        mDescription.setText(mExercise.getDescription());
        mCategory.setText(mExercise.getCategory().getName());
        mMuscles.setText(android.text.TextUtils.join(",",muscles));
        mEquipments.setText(android.text.TextUtils.join(",",equipments));

        return view;
    }

}
