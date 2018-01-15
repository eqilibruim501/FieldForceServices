package com.nnb.fieldforceapp.di.activities.createCase

import com.nnb.fieldforceapp.di.scope.ActivityScope
import com.nnb.fieldforceapp.ui.createCase.CreateCaseActivity
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Created by nnbinh on 1/9/18.
 */
@ActivityScope
@Subcomponent(modules = [(CreateCaseModule::class)])
interface CreateCaseComponent {
	@Subcomponent.Builder
	interface Builder {
		@BindsInstance
		fun sessionModule(module: CreateCaseModule): Builder
		fun build(): CreateCaseComponent
	}

	fun inject(activity: CreateCaseActivity)
}