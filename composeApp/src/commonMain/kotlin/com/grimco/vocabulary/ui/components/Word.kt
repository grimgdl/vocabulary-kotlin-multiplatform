package com.grimco.vocabulary.ui.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Word(
    label: String,
    modifier: Modifier = Modifier,
    onClickWord: (label: String) -> Unit
) {

    var visibility by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    AnimatedVisibility(
        visible = visibility,
        enter = expandVertically( animationSpec = tween(300)) + fadeIn(),
        exit = shrinkVertically(animationSpec = tween(300)) + fadeOut()
    ) {
        Column (
            modifier = modifier
                .clickable {
                    scope.launch {
                        visibility = false
                        delay(300)
                        onClickWord(label)
                    }
                }

        ){

            Text(
                text = label
            )

            Text("hola  fads")


        }
    }


    LaunchedEffect(Unit) {
        visibility = true
    }


}