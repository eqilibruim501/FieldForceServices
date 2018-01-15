package com.nnb.fieldforceapp.ui.createCase

import com.nnb.fieldforceapp.base.mvp.ILifeCycle
import com.nnb.fieldforceapp.data.model.Case

/**
 * Created by nnbinh on 1/9/18.
 */
interface ICreateCaseContract {
	interface View : ILifeCycle.View {
		fun successful(item: Case)
	}

	interface Presenter {
		fun validateName(name: String): Boolean
		fun save(name: String, number: String, priority: String, origin: String, customer: String, statusReason: String)
	}
}