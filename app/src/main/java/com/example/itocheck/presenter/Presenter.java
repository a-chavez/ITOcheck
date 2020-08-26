package com.example.itocheck.presenter;

import com.example.itocheck.model.Calc;


public class Presenter implements IPresenter{
    private Calc calc;
    private IViewPresenter view;

    public Presenter(IViewPresenter view) {
        this.view = view;
        calc = new Calc();
    }

    @Override
    public void alert(boolean alert) {

    }
}
