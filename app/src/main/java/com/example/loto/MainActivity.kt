package com.example.loto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.loto.ui.theme.LotoTheme
import com.example.loto.viewModels.LoteriaViewModels
import com.example.loto.views.LoteriaView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : LoteriaViewModels by viewModels()
        enableEdgeToEdge()
        setContent {
            LotoTheme {
                Surface(
                    modifier=Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                    {
                        LoteriaView(viewModels = viewModel)
                    }
            }
        }
    }
}

