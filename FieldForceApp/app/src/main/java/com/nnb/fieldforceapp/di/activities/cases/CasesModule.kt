package com.nnb.fieldforceapp.di.activities.cases

import com.nnb.fieldforceapp.ui.cases.CasesAdapter
import com.nnb.fieldforceapp.ui.cases.CasesPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by nnbinh on 1/15/18.
 */
@Module
class CasesModule {
	@Provides
	internal fun providesPresenter(): CasesPresenter = CasesPresenter()

	@Provides
	internal fun providesAdapter(): CasesAdapter = CasesAdapter()
}