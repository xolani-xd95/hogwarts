package com.example.hogwarts.ui.spells

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hogwarts.network.api.ApiClient
import com.example.hogwarts.network.api.ApiSpell
import com.example.hogwarts.network.dto.SpellDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpellsViewModel : ViewModel() {

    private val apiSpellClient = ApiClient.createService(ApiSpell::class.java)

    var spellResponse = MutableLiveData<ArrayList<SpellDTO>>()
    fun getSpellResponse(): LiveData<ArrayList<SpellDTO>> {
        return spellResponse
    }

    fun getAllSpells() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val getAllSpellsResponse =
                apiSpellClient.getAllSpells("$2a$10$1JEnmtEF417yBaFZcr51qukRjaKv8d5toEG5DKP/IUZWIVwfsaF7y")
            if (getAllSpellsResponse.isSuccessful) {
                // switch to main thread for assiging the response to live data else will crash / throw excpetion if done in background thread
                withContext(Dispatchers.Main) {
                    spellResponse.value = getAllSpellsResponse.body()
                }
            }
        } catch (t: Throwable) {
            // usually output to cloud
            Log.e(
                "Throwabele: ",
                "getAllSpells() call failed with exception - $t"
            )
        }
    }
}