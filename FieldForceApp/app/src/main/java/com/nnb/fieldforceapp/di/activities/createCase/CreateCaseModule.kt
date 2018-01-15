package com.nnb.fieldforceapp.di.activities.createCase

import com.nnb.fieldforceapp.ui.createCase.CreateCasePresenter
import dagger.Module
import dagger.Provides

/**
 * Created by nnbinh on 1/9/18.
 */
@Module
class CreateCaseModule {
	@Provides
	internal fun providesPresenter(): CreateCasePresenter = CreateCasePresenter()
}