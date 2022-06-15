package com.fintonic.beers.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fintonic.beers.model.data.entitiesVO.BeerVo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel: ViewModel() {
    //LiveData
    val beers = MutableLiveData<List<BeerVo>>()

    fun getAllBeers() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

            }
        }
    }
}