package com.example.projektaktywnosc

import android.app.Activity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class FireStoreClass {
    private val mFireStore = FirebaseFirestore.getInstance();

    fun registerUser(activity: StronadoRestracji, userInfo: User){
        //mFireStore.collection("users")
        mFireStore.collection(Constants.USERS)
            .document(userInfo.id)
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {

                activity.userRegistrationSuccess()
            }
            .addOnFailureListener { e ->
                Log.e(
                    activity.javaClass.simpleName,
                    "Problem z rejestracją użytkownika",
                    e
                )
            }

    }
    fun getCurrentUserID(): String {

        val currentUser = FirebaseAuth.getInstance().currentUser
        var currentUserID = ""
        if(currentUser != null){
            currentUserID = currentUser.uid
        }
        return currentUserID
    }



    fun getUserDetails(activity: Activity){
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserID())
            .get()
            .addOnSuccessListener { document ->

                Log.i(activity.javaClass.simpleName,document.toString())
                val user = document.toObject(User::class.java)!!

                when(activity){
                    is MainActivity -> {
                        activity.userLoggedInSuccess(user)
                    }




                }
            }
    }
    fun  updateUserWaga(activity: Activity, idealnawaga: Int){

        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserID())
            .update("Idealna waga",idealnawaga)
    }
    fun  updateUserWzrost(activity: Activity, wzrost: Int){

        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserID())
            .update("Wzrost",wzrost)
    }

}