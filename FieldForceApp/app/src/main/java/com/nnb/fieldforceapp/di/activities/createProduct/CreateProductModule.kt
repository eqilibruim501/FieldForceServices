package com.nnb.fieldforceapp.di.activities.createProduct

import com.nnb.fieldforceapp.ui.createProduct.CreateProductPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by nnbinh on 1/9/18.
 */
@Module
class CreateProductModule {
	@Provides
	internal fun providesPresenter(): CreateProductPresenter = CreateProductPresenter()
}