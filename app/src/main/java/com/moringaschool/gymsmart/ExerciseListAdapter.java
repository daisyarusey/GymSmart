package com.moringaschool.gymsmart;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.gymsmart.ui.Exercise.ExerciseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListAdapter.ExerciseViewHolder> {

    private List<Result> mExercises;
    private ExerciseFragment mcontext;

    public ExerciseListAdapter(ExerciseFragment context, List<Result> exercises){
        mcontext=context;
        mExercises=exercises;
    }

    @NonNull
    @Override
    public ExerciseListAdapter.ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_list_item,parent,false);
        ExerciseViewHolder viewHolder = new ExerciseViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        holder.bindExercise(mExercises.get(position));

    }

    @Override
    public int getItemCount() {
        return mExercises.size();
    }

    public class ExerciseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.exerciseName) TextView mName;
        @BindView(R.id.exercise_desc) TextView mDescription;
        @BindView(R.id.category) TextView mCategory;

        private Context mContext;

        public ExerciseViewHolder(View itemView){
            super(itemView);

            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();

            itemView.setOnClickListener(this);
        }

        public void bindExercise(Result exercise){
            mName.setText("Exercise name" + " " + exercise.getName());
            mCategory.setText("Category" + " " + String.valueOf(exercise.getCategory().getName()));
            mDescription.setText( "Description \n"+ " "+ Html.escapeHtml(exercise.getDescription()));

//
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();



        }
    }
}
