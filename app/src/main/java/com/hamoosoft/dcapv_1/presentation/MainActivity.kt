package com.hamoosoft.dcapv_1.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.hamoosoft.dcapv_1.navigation.DcAppNavigation
import com.hamoosoft.dcapv_1.presentation.ui.theme.DcApV_1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DcApV_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DcAppNavigation()
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        //Toast.makeText(baseContext,"ok data ",Toast.LENGTH_LONG).show()
        val bundle = intent?.extras

        var data =
            bundle!![Intent.EXTRA_STREAM] as Uri?

        Toast.makeText(baseContext, data.toString(), Toast.LENGTH_LONG).show()


    }
}
