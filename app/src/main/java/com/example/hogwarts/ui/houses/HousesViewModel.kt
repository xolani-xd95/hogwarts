package com.example.hogwarts.ui.houses

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hogwarts.MainActivity
import com.example.hogwarts.network.api.ApiClient
import com.example.hogwarts.network.api.ApiHouse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HousesViewModel : ViewModel() {

    private val apiHouseClient = ApiClient.createService(ApiHouse::class.java)

    var allHousesResponse = MutableLiveData<ArrayList<String>>()
    fun getAllHouseResponse(): LiveData<ArrayList<String>> {
        return allHousesResponse
    }

    fun getAllHouses() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val reponse =
                apiHouseClient.getHouses(MainActivity.api_key)
            if (reponse.isSuccessful) {
                withContext(Dispatchers.Main) {
                    allHousesResponse.value = reponse.body()
                }
            }
        } catch (t: Throwable) {
            Log.e(
                "Throwabele: ",
                "getAllSpells() call failed with exception - $t"
            )
        }
    }
}