package com.example.myapp2021.main.home;
import android.util.Log;
import com.example.myapp2021.model.IMessageListner;
import com.example.myapp2021.webservice.WebserviceCaller;

public class HomeInteractor {

    WebserviceCaller webserviceCaller;

    public HomeInteractor() {
        webserviceCaller = new WebserviceCaller();
    }

    public void getCategory(IMessageListner listner) {

   webserviceCaller.getCategory(new IMessageListner() {
       @Override
       public void onSuccess(Object responseMessage) {
           listner.onSuccess(responseMessage);
           Log.e("","");
       }

       @Override
       public void onFailure(String errorResponseMessage) {
          listner.onFailure(errorResponseMessage);
           Log.e("","");
       }
   });

    }

   public void getAllfoods(String category,IMessageListner listner){
        webserviceCaller.getAllfoods(category, new IMessageListner() {
            @Override
            public void onSuccess(Object responseMessage) {
                listner.onSuccess(responseMessage);
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });
   }

}
