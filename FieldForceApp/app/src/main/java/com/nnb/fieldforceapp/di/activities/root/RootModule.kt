package com.nnb.fieldforceapp.di.activities.root

import com.nnb.fieldforceapp.data.model.Action
import com.nnb.fieldforceapp.ui.root.RootPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by nnbinh on 1/7/18.
 */
@Module
class RootModule {
	@Provides
	internal fun providesPresenter(): RootPresenter = RootPresenter()

	@Provides
	internal fun providesActions(): List<Action> = Action.actions
}