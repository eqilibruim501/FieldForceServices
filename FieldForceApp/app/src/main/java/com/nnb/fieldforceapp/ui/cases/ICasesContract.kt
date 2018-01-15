package com.nnb.fieldforceapp.ui.cases

import com.nnb.fieldforceapp.base.mvp.ILifeCycle
import com.nnb.fieldforceapp.data.model.Case

/**
 * Created by nnbinh on 1/15/18.
 */
interface ICasesContract {
	interface View : ILifeCycle.View {
		fun loadOnUI(item: Case)
	}

	interface Presenter {
		fun requestLoadCases()
	}
}