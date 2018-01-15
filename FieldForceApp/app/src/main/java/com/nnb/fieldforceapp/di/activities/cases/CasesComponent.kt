package com.nnb.fieldforceapp.di.activities.cases

import com.nnb.fieldforceapp.di.scope.ActivityScope
import com.nnb.fieldforceapp.ui.cases.CasesActivity
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Created by nnbinh on 1/15/18.
 */
@ActivityScope
@Subcomponent(modules = [(CasesModule::class)])
interface CasesComponent {
	@Subcomponent.Builder
	interface Builder {
		@BindsInstance
		fun sessionModule(module: CasesModule): Builder
		fun build(): CasesComponent
	}

	fun inject(activity: CasesActivity)
}