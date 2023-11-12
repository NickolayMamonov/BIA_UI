package com.whysoezzy.bia_ui.presentation.components


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    maxLength: Int,
    mask: String = "",
    maskNumber: Char,
    isError: Boolean = false,
    leadingIcon: String = "",
    keyboardType: KeyboardType = KeyboardType.Phone,
    onValueChange: (String) -> Unit,
    onDoneAction: () -> Unit
) {

    OutlinedTextField(
        value = text,
        onValueChange = {
            if(it.length <= maxLength) {
                onValueChange(it)
            }
        },
        placeholder = {
            Text(
                text = hint,
                style = MaterialTheme.typography.bodySmall
            )
        },

        shape = RoundedCornerShape(23.dp),
        isError = isError,
        textStyle = MaterialTheme.typography.headlineSmall,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onDoneAction()
            }
        ),
        singleLine = true,
        visualTransformation = PhoneNumFilter(mask, maskNumber),
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth()
    )
}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun StandardTextField(
//    text: String = "",
//    hint: String = "",
//    isError: Boolean = false,
//    keyboardType: KeyboardType = KeyboardType.Phone,
//    onValueChange: (String) -> Unit
//){
//    OutlinedTextField(
//        value = text,
//        onValueChange = onValueChange,
//        placeholder = {
//            Text(
//                text = hint,
//                style = MaterialTheme.typography.bodyLarge
//            )
//        },
//        shape = RoundedCornerShape(13.dp),
//        singleLine = true,
//        isError = isError,
//        keyboardOptions = KeyboardOptions(
//            keyboardType = keyboardType
//        ),
//        modifier = Modifier
//            .height(20.dp)
//            .fillMaxWidth()
//
//
//    )
//
//}