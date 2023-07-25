package com.hamoosoft.dcapv_1.presentation.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hamoosoft.dcapv_1.R
import com.hamoosoft.dcapv_1.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val splashState = remember {
        Animatable(0.1f)
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        SplashScreenContent(splashState = splashState)
    }

    LaunchedEffect(key1 = true) {
        splashState.animateTo(0.9f, animationSpec = tween(durationMillis = 800, easing = {
            OvershootInterpolator(8f).getInterpolation(it)
        }))
        delay(5000)
        navController.navigate(Routes.Home.name)
    }
}

@Composable
fun SplashScreenContent(
    splashState: Animatable<Float, AnimationVector1D>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SplashedContent(splashState = splashState)
    }
}

@Composable
fun SplashedContent(
    splashState: Animatable<Float, AnimationVector1D>
) {

    Surface(
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.splashed_content_size))
            .scale(splashState.value),
        shape = CircleShape,
        color = MaterialTheme.colorScheme.primary,
        border = BorderStroke(width = 0.5.dp, MaterialTheme.colorScheme.onPrimary)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            SplashedImage()
            Spacer(modifier = Modifier.padding(2.dp))
            StyledText()

        }

    }
}

@Composable
fun SplashedImage() {
    Surface(modifier = Modifier.fillMaxSize(0.5f), shape = CircleShape) {
        Image(
            painter = painterResource(id = R.drawable.dc),
            contentDescription = stringResource(
                id = R.string.app_name
            ), contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun StyledText() {
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.Green,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 26.sp,
                fontFamily = FontFamily.SansSerif
            )
        ) { append("DC") }
        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                fontFamily = FontFamily.Monospace
            )
        ) { append("App\n\n ") }
        withStyle(
            style = SpanStyle(
                color = Color.Yellow,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 28.sp,
                fontFamily = FontFamily.Cursive
            )
        ) { append("Version - ") }
        withStyle(
            style = SpanStyle(
                color = Color.LightGray,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                fontFamily = FontFamily.Serif
            )
        ) { append("1.0") }

    }, textAlign = TextAlign.Center)
}
