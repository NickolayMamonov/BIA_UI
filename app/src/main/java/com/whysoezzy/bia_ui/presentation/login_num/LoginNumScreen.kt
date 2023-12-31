package com.whysoezzy.bia_ui.presentation.login_num

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.whysoezzy.bia_ui.R
import com.whysoezzy.bia_ui.presentation.components.StandardTextField
import com.whysoezzy.bia_ui.presentation.ui.theme.SpaceLarge
import com.whysoezzy.bia_ui.presentation.ui.theme.SpaceMedium
import com.whysoezzy.bia_ui.presentation.ui.theme.SpaceSmall
import com.whysoezzy.bia_ui.presentation.ui.theme.SpaceVeryLarge
import com.whysoezzy.bia_ui.presentation.ui.utils.Screen

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginNumScreen(
    navController: NavController,
    viewModel: LoginNumViewModel = hiltViewModel()
) {
    val currentFocus = LocalFocusManager.current
    val softwareKeyboardController = LocalSoftwareKeyboardController.current

    // Определяем Insets с использованием LocalWindowInsets
    val viewInsets = LocalView.current.layoutDirection

    var text by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(SpaceMedium)

    ) {
        Row(
            modifier = Modifier
                .align(Alignment.TopStart)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.logo_small),
                contentDescription = "logo_small",
                modifier = Modifier.padding(7.dp)
            )
            Text(
                text = "Помощник логиста",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(SpaceSmall)
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(SpaceMedium)


        ) {
            Text(
                text = "Добро пожаловать в БИА.Помощник логиста",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            Text(
                text = "Введите свой номер для авторизации",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            StandardTextField(
                text = viewModel.phoneNumText.value,
                onValueChange = {
                    viewModel.setPhoneNumText(it)
                    isButtonEnabled = it.length == 10
                },
                mask = "+7(xxx)xxx-xx-xx",
                maskNumber = 'x',
                hint = "+7(999)000-00-00",
                maxLength = 10,
                onDoneAction = {
                    currentFocus.clearFocus()
                    softwareKeyboardController?.hide()
                },

            )
            Spacer(modifier = Modifier.height(SpaceVeryLarge))
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                enabled = isButtonEnabled,
                onClick = {
                    navController.navigate(Screen.LoginPassScreen.route)
                }) {
                Text(
                    text = "Продолжить",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    modifier = Modifier.align(CenterVertically))

            }

        }



    }
}