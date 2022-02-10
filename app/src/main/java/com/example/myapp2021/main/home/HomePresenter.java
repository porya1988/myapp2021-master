package com.example.myapp2021.main.home;
import android.util.Log;
import com.example.myapp2021.model.IMessageListner;
public class HomePresenter implements IMessageListner {
    IHomeView iHomeView;
    HomeInteractor interactor;


    public HomePresenter(IHomeView iHomeView) {

        this.iHomeView = iHomeView;
        Log.e("", "");
        interactor = new HomeInteractor();
    }


    public void getCategory() {

        if (iHomeView != null) {


            iHomeView.showProgressbar();
            interactor.getCategory(this);
        } else {
            Log.e("error", "");
        }

    }

    public void getAllfoods(String category){
        if (iHomeView != null) {
            iHomeView.showProgressbar();
            interactor.getAllfoods(category,this);
            Log.e("","");
        } else {
            Log.e("error", "");
        }
    }


    @Override
    public void onSuccess(Object responseMessage) {
        iHomeView.onSuccess(responseMessage);
        iHomeView.hideProgressbar();
    }

    @Override
    public void onFailure(String errorResponseMessage) {
        iHomeView.onFailure(errorResponseMessage);
    }
}
