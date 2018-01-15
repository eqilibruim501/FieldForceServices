package com.nnb.fieldforceapp.di.app

import com.nnb.fieldforceapp.FieldForceApp
import com.nnb.fieldforceapp.di.activities.cases.CasesComponent
import com.nnb.fieldforceapp.di.activities.createCase.CreateCaseComponent
import com.nnb.fieldforceapp.di.activities.root.RootComponent
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
	fun createCaseComponentBuilder(): CreateCaseComponent.Builder
	fun casesComponentBuilder(): CasesComponent.Builder
}