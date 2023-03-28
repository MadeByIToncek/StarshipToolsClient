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

package cz.iqlandia.iqplanetarium.starshiptoolsclient.linfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import cz.iqlandia.iqplanetarium.starshiptoolsclient.R;
import cz.iqlandia.iqplanetarium.starshiptoolsclient.databinding.FragmentLinfoBinding;

public class LaunchInfoFragment extends Fragment {

    private FragmentLinfoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLinfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final WebView ww = binding.webview;

        ww.loadUrl(getResources().getString(R.string.linfo));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}