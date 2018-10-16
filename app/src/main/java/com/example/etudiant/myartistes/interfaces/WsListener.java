package com.example.etudiant.myartistes.interfaces;

public  interface WsListener{
    void errorRequest(int idRequest);
    void successRequest(int idRequest, String data);
}
