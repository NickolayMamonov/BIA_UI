package com.whysoezzy.bia_ui.presentation.login_num

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginNumViewModel @Inject constructor(): ViewModel() {
    private val _phoneNumText = mutableStateOf("")
    val phoneNumText : State<String> = _phoneNumText

    fun setPhoneNumText(phoneNum: String){
        _phoneNumText.value = phoneNum
    }
}