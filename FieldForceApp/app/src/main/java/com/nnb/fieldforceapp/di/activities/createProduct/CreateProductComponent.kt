package com.nnb.fieldforceapp.di.activities.createProduct

import com.nnb.fieldforceapp.di.scope.ActivityScope
import com.nnb.fieldforceapp.ui.createProduct.CreateProductActivity
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Created by nnbinh on 1/9/18.
 */
@ActivityScope
@Subcomponent(modules = [(CreateProductModule::class)])
interface CreateProductComponent {
	@Subcomponent.Builder
	interface Builder {
		@BindsInstance
		fun sessionModule(module: CreateProductModule): Builder
		fun build(): CreateProductComponent
	}

	fun inject(activity: CreateProductActivity)
}