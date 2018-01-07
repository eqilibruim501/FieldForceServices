package com.nnb.fieldforceapp

import android.app.Application
import com.nnb.fieldforceapp.di.app.AppComponent
import com.nnb.fieldforceapp.di.app.AppModule
import com.nnb.fieldforceapp.di.app.DaggerAppComponent

/**
 * Created by nnbinh on 1/7/18.
 */
class FieldForceApp : Application() {
	companion object {
		@JvmStatic lateinit var appComponent: AppComponent
	}

	override fun onCreate() {
		super.onCreate()
		appComponent = DaggerAppComponent.builder()
				.appModule(AppModule(this))
				.build()
	}
}