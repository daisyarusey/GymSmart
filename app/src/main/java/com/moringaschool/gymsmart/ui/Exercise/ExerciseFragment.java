package com.moringaschool.gymsmart.ui.Exercise;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;
import com.moringaschool.gymsmart.ExerciseDetailsResponse;
import com.moringaschool.gymsmart.ExerciseListAdapter;
import com.moringaschool.gymsmart.R;
import com.moringaschool.gymsmart.Result;
import com.moringaschool.gymsmart.WgaApi;
import com.moringaschool.gymsmart.WgaClient;

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

        Call<ExerciseDetailsResponse> call = client.getExersices();
        call.enqueue(new Callback<ExerciseDetailsResponse>() {

            @Override
            public void onResponse(Call<ExerciseDetailsResponse> call, Response<ExerciseDetailsResponse> response) {
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
            public void onFailure(Call<ExerciseDetailsResponse> call, Throwable t) {


            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerview);
        return  view;



    }
    Result deleteExercise = null;

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int postion  = viewHolder.getAdapterPosition();
            switch (direction){
                case ItemTouchHelper.LEFT:
                    deleteExercise= exercises.get(postion);
                    exercises.remove(postion);
                    mAdapter.notifyItemRemoved(postion);
                    Snackbar.make(mRecyclerview,"Deleted Exercise",Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    exercises.add(postion,deleteExercise);
                                    mAdapter.notifyItemInserted(postion);
                                }
                            }).show();
                    break;

                case ItemTouchHelper.RIGHT:
                    break;
            }

        }
    };

}
