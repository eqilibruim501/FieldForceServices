package com.nnb.fieldforceapp.di.app

import com.nnb.fieldforceapp.FieldForceApp
import com.nnb.fieldforceapp.di.activities.root.RootComponent
import com.nnb.fieldforceapp.ui.root.RootActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by nnbinh on 1/7/18.
 */
@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
	fun inject(target: FieldForceApp)

	fun rootComponentBuilder(): RootComponent.Builder
}