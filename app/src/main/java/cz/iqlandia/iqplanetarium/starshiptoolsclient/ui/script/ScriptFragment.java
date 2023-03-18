package cz.iqlandia.iqplanetarium.starshiptoolsclient.ui.script;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import cz.iqlandia.iqplanetarium.starshiptoolsclient.R;
import cz.iqlandia.iqplanetarium.starshiptoolsclient.databinding.FragmentScriptBinding;

public class ScriptFragment extends Fragment {

    private FragmentScriptBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentScriptBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final WebView ww = binding.webview;

        ww.loadUrl(getResources().getString(R.string.script));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}