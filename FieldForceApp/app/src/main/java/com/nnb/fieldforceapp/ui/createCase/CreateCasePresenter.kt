package com.nnb.fieldforceapp.ui.createCase

import com.nnb.fieldforceapp.base.mvp.BasePresenter
import com.nnb.fieldforceapp.data.model.Case
import javax.inject.Inject

/**
 * Created by nnbinh on 1/9/18.
 */
class CreateCasePresenter @Inject constructor() : BasePresenter<ICreateCaseContract.View>(),
		ICreateCaseContract.Presenter {
	override fun validateName(name: String): Boolean {
		return name.isNotEmpty()
	}

	override fun save(name: String, number: String, priority: String, origin: String, customer: String, statusReason: String) {
		val newItem = Case(name, number, priority, origin, customer, statusReason)
		newItem.save()
		view?.successful(newItem)
	}
}