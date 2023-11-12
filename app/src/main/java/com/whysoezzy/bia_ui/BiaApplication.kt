package com.whysoezzy.bia_ui

import android.app.Application
import com.whysoezzy.bia_ui.di.AppModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber

@HiltAndroidApp
class BiaApplication : Application()