package com.android.plugin_test3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.plugin_test3.databinding.PluginTest3FragmentBinding;

import java.util.Random;

public class PluginTest3_Fragment extends Fragment {
    PluginTest3FragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = PluginTest3FragmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.pluginTest3FragmentTv.setText("fragment----binding:" + new Random().nextInt(Integer.MAX_VALUE));
    }
}
