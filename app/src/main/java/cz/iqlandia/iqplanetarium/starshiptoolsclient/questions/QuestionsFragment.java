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

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.iqlandia.iqplanetarium.starshiptoolsclient.NetworkAdapter;
import cz.iqlandia.iqplanetarium.starshiptoolsclient.R;
import cz.iqlandia.iqplanetarium.starshiptoolsclient.databinding.FragmentQuestionsBinding;

public class QuestionsFragment extends Fragment {

    private FragmentQuestionsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentQuestionsBinding.inflate(inflater, container, false);
        RelativeLayout root = binding.getRoot();
        root.findViewById(R.id.button2).setOnClickListener((l) -> NetworkAdapter.get("http://192.168.99.64:8765/submit/-1"));
        try {
            RecyclerView courseRV = root.findViewById(R.id.idRV);

//             Here, we have created new array list and added data to it
            JSONArray array = new JSONArray(NetworkAdapter.get(getResources().getString(R.string.questions)));
            Toast.makeText(this.getContext(), "Requested", Toast.LENGTH_SHORT).show();
            ArrayList<QuestionModel> courseModelArrayList = new ArrayList<>();
            for (int i = 0; i < array.length() - 1; i++) {
//                Toast.makeText(this.getContext(), "Building " + i, Toast.LENGTH_SHORT).show();
                JSONObject obj = array.getJSONObject(i);
                courseModelArrayList.add(new QuestionModel(obj.getString("a"), obj.getString("q"), obj.getInt("id")));
            }
            // we are initializing our adapter class and passing our arraylist to it.
            QuestionAdapter courseAdapter = new QuestionAdapter(this.getContext(), courseModelArrayList);

            // below line is for setting a layout manager for our recycler view.
            // here we are creating vertical list so we will provide orientation as vertical
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);

//            // in below two lines we are setting layoutmanager and adapter to our recycler view.
            courseRV.setLayoutManager(linearLayoutManager);
            courseRV.setAdapter(courseAdapter);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this.getContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}