package com.whysoezzy.bia_ui.presentation.login_num

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.whysoezzy.bia_ui.R
import com.whysoezzy.bia_ui.presentation.components.StandardTextField
import com.whysoezzy.bia_ui.presentation.ui.theme.SpaceMedium
import com.whysoezzy.bia_ui.presentation.ui.theme.SpaceSmall

@Composable
fun LoginNumScreen(
    navController: NavController,
    viewModel: LoginNumViewModel = hiltViewModel()
) {

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
                },
                hint = "(999)000-00-00",
                leadingIcon = "+7"

            )

        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            onClick = { /*TODO*/ }) {

        }

    }
}