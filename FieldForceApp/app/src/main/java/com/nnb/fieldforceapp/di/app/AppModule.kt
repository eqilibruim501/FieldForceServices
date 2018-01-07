package com.nnb.fieldforceapp.di.app

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by nnbinh on 1/7/18.
 */
@Module
class AppModule(val app: Application) {
	@Provides
	@Singleton
	fun provideContext(): Context = app
}