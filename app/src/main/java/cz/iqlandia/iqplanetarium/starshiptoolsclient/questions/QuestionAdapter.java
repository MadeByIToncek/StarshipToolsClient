/*
 * Copyright (c) 2023 - IToncek
 *
 * All rights to modifying this source code are granted, except for changing licence.
 * Any and all products generated from this source code must be shared with a link
 * to the original creator with clear and well-defined mention of the original creator.
 * This applies to any lower level copies, that are doing approximately the same thing.
 * If you are not sure, if your usage is within these boundaries, please contact the
 * author on their public email address.
 */

package cz.iqlandia.iqplanetarium.starshiptoolsclient.questions;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cz.iqlandia.iqplanetarium.starshiptoolsclient.NetworkAdapter;
import cz.iqlandia.iqplanetarium.starshiptoolsclient.R;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private final ArrayList<QuestionModel> QuestionModelArrayList;
    private final Context context;

    // Constructor
    public QuestionAdapter(Context context, ArrayList<QuestionModel> QuestionModelArrayList) {
        this.QuestionModelArrayList = QuestionModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public QuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAdapter.ViewHolder holder, int position) {
        // to set data to textview and imageview of each card layout
        QuestionModel model = QuestionModelArrayList.get(position);
        holder.author.setText(model.getAuthor());
        holder.question.setText(model.getQuestion());
        holder.button.setOnClickListener((l) -> submit(model.getId()));
    }

    private void submit(int id) {
        NetworkAdapter.get("http://192.168.99.64:8765/submit/" + id);
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number of card items in recycler view
        return QuestionModelArrayList.size();
    }

    // View holder class for initializing of your views such as TextView and Imageview
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView author;
        private final TextView question;
        private final Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.idAuthor);
            question = itemView.findViewById(R.id.idQuestion);
            button = itemView.findViewById(R.id.idButton);
        }
    }
}