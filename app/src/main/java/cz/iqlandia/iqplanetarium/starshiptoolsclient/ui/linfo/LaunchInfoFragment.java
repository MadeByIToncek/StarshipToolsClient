package cz.iqlandia.iqplanetarium.starshiptoolsclient.ui.linfo;

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