package com.example.androidtask1.catpage

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage


@Composable
fun CatPage(
    viewModel: CatPageViewModel= hiltViewModel()
){

    val cat by remember {
        viewModel.cat
    }
    val isLoading by remember{
        viewModel.isLoading
    }
    val loadError by remember {
        viewModel.loadError
    }


    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        SubcomposeAsyncImage(
            model = cat.url,
            contentDescription = cat.id,
            loading = {
                CircularProgressIndicator(modifier = Modifier.fillMaxSize())
            },
            modifier = Modifier
                .weight(4f).padding(18.dp)

        )
        Box(modifier = Modifier.weight(1f)) {
            Button(
                onClick = { viewModel.getCat() },
                modifier=Modifier.size(height = 50.dp, width = 120.dp)
            )
             {
                Text(text = "Yeni Resim")
            }
        }
    }



    }

