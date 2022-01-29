package com.example.myapp2021.Registration.RegisterListner;

public interface RegisterListner {


    public void onSuccess(String responseMessage);

    public void onUsernameError(String usernameResponseMessage);

    public void onFailure(String errorResponseMessage);

    public void onPasswordError(String passResponseMessage);

    public void onNameError(String nameResponseMessage);

    public void onFamilyError(String famResponseMesaage);

    public void onEmailError(String emailResponseMessage);
}
