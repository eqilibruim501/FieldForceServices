package com.nnb.fieldforceapp.di.activities.root

import com.nnb.fieldforceapp.di.scope.ActivityScope
import com.nnb.fieldforceapp.ui.root.RootActivity
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Created by nnbinh on 1/7/18.
 */
@ActivityScope
@Subcomponent(modules = [(RootModule::class)])
interface RootComponent {
	@Subcomponent.Builder
	interface Builder {
		@BindsInstance
		fun sessionModule(module: RootModule): Builder
		fun build(): RootComponent
	}

	fun inject(activity: RootActivity)
}