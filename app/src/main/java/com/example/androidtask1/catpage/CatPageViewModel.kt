package com.example.androidtask1.catpage

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtask1.data.remote.responses.Cat
import com.example.androidtask1.data.remote.responses.CatItem
import com.example.androidtask1.repository.CatRepository
import com.example.androidtask1.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatPageViewModel @Inject constructor(
    private val catRepo: CatRepository
):ViewModel(){

    var cat = mutableStateOf<CatItem>(CatItem(1,"1","a",1))
    var isLoading= mutableStateOf(false)
    var loadError=mutableStateOf("")

    init {
        getCat()
    }

    fun getCat(){
        viewModelScope.launch {
            isLoading.value=true
            val result=catRepo.getCat()

            when(result){
                is Resource.Success->{
                    loadError.value =""
                    isLoading.value=false
                    cat.value= result.data!![0]


                }
                is Resource.Error ->{
                    isLoading.value=false
                    loadError.value=result.message!!

                }
            }
        }
    }


}