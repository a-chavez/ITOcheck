package com.example.itocheck;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.itocheck.databinding.FragmentFirstBinding;
import com.example.itocheck.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    private FragmentSecondBinding mBinding;
    private String tv1,tv2,tv3;
    private String url;

    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        if (getArguments() != null) {
            tv1 = getArguments().getString("edi");
            tv2 = getArguments().getString("num");
            tv3 = getArguments().getString("dir");
            url = getArguments().getString("url");
        }
    }



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        mBinding = FragmentSecondBinding.inflate(inflater,container,false);
        mBinding.tvEdif.setText(tv1);
        mBinding.tvDep.setText(tv2);

        Glide.with(getContext()).load(url).centerCrop().into(mBinding.imageView);

        return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }




}