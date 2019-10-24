package com.moringaschool.gymsmart.ui.Exercise;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moringaschool.gymsmart.ExerciseListAdapter;
import com.moringaschool.gymsmart.R;
import com.moringaschool.gymsmart.Result;
import com.moringaschool.gymsmart.WgaApi;
import com.moringaschool.gymsmart.WgaClient;
import com.moringaschool.gymsmart.WgaResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExerciseFragment extends Fragment {

    @BindView(R.id.exercise_recyclerview) RecyclerView mRecyclerview;

    private ExerciseListAdapter mAdapter;

    public List<Result> exercises;


    public ExerciseFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    private void showUnsuccessfulMessage() {
    }

    private void showExercise() {
        mRecyclerview.setVisibility(View.VISIBLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.exercise_fragment,container,false);
        ButterKnife.bind(this,view);


        WgaApi client = WgaClient.getClient();

        Call<WgaResponse> call = client.getExersices();
        call.enqueue(new Callback<WgaResponse>() {

            @Override
            public void onResponse(Call<WgaResponse> call, Response<WgaResponse> response) {
                if (response.isSuccessful()){

                    exercises= response.body().getResults();
                    mAdapter=new ExerciseListAdapter(ExerciseFragment.this,exercises);
                    mRecyclerview.setAdapter(mAdapter);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                    mRecyclerview.setLayoutManager(layoutManager);
                    mRecyclerview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));



                    mRecyclerview.setHasFixedSize(true);


                    showExercise();
                }else {

                }
            }

            @Override
            public void onFailure(Call<WgaResponse> call, Throwable t) {


            }
        });

        return  view;
    }

}
