package com.example.itocheck;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.itocheck.databinding.FragmentFirstBinding;
import com.example.itocheck.databinding.FragmentSecondBinding;
import com.example.itocheck.presenter.IPresenter;
import com.example.itocheck.presenter.IViewPresenter;
import com.example.itocheck.presenter.Presenter;

public class SecondFragment extends Fragment implements IViewPresenter {
    private FragmentSecondBinding mBinding;
    private String tv1,tv2,tv3,url;
    private int mscore, e=0;
    private IPresenter mPresenter;
    private Boolean a,b,c,d;

    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        mPresenter = new Presenter(this);

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


        mBinding.ibCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = mBinding.switch1.isChecked();
                b = mBinding.switch2.isChecked();
                c = mBinding.switch3.isChecked();
                d = mBinding.switch4.isChecked();
                if (mBinding.radioButton.isChecked())e=3;
                if (mBinding.radioButton2.isChecked())e=2;
                if (mBinding.radioButton3.isChecked())e=1;

                mPresenter.calculationScore(a,b,c,d,e);

               // Toast.makeText(getContext(),msj, Toast.LENGTH_SHORT).show();
            }
        });



    }


    @Override
    public void showAlert(int score) {
         Toast.makeText(getContext(),"alerta", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showNormal(int score) {
        Toast.makeText(getContext(),""+score, Toast.LENGTH_SHORT).show();
    }
}