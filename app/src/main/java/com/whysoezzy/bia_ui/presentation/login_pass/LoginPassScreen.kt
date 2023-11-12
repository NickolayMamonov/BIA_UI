package com.whysoezzy.bia_ui.presentation.login_pass

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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
import com.whysoezzy.bia_ui.presentation.login_num.LoginNumViewModel
import com.whysoezzy.bia_ui.presentation.ui.theme.SpaceMedium
import com.whysoezzy.bia_ui.presentation.ui.theme.SpaceSmall
import com.whysoezzy.bia_ui.presentation.ui.theme.SpaceVeryLarge
import com.whysoezzy.bia_ui.presentation.ui.utils.Screen

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginPassScreen(
    navController: NavController,
    viewModel: LoginPassViewModel = hiltViewModel()
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

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screen.LoginNumScreen.route)
                        }
                        .padding(SpaceSmall)

                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back_arrow),
                        contentDescription = null,
                        tint = Color.Black,

                    )
                }

                Text(
                    text = "Введите пароль",
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            Spacer(modifier = Modifier.height(SpaceSmall))
            Text(
                text = "Для получения пароля обратитесь к руководителю",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            StandardTextField(
                text = viewModel.phonePassText.value,
                onValueChange = {
                    viewModel.setPhonePassText(it)
                    isButtonEnabled = it.length == 6
                },
                onDoneAction = {
                    currentFocus.clearFocus()
                    softwareKeyboardController?.hide()
                },
                mask = "_ _ _ _ _ _",
                maskNumber = '_',
                hint = "_ _ _ _ _ _",
                maxLength = 6,
                )
            Spacer(modifier = Modifier.height(SpaceVeryLarge))
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                enabled = isButtonEnabled,
                onClick = {
                    navController.navigate(Screen.TasksScreen.route)
                }) {
                Text(
                    text = "Продолжить",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterVertically))

            }

        }



    }
}