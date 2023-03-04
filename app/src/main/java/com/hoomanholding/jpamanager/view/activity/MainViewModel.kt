package com.hoomanholding.jpamanager.view.activity

import android.content.SharedPreferences
import com.hoomanholding.jpamanager.JpaViewModel
import com.hoomanholding.jpamanager.tools.CompanionValues
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : JpaViewModel() {


    //---------------------------------------------------------------------------------------------- deleteAllData
    fun deleteAllData() {
        sharedPreferences
            .edit()
            .putString(CompanionValues.TOKEN, null)
            .apply()
    }
    //---------------------------------------------------------------------------------------------- deleteAllData


}