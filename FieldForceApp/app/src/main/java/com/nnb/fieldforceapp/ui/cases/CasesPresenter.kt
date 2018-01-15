package com.nnb.fieldforceapp.ui.cases

import com.nnb.fieldforceapp.base.mvp.BasePresenter
import com.nnb.fieldforceapp.data.model.Case
import io.reactivex.rxkotlin.toObservable

/**
 * Created by nnbinh on 1/15/18.
 */
class CasesPresenter : BasePresenter<ICasesContract.View>(), ICasesContract.Presenter {
	override fun requestLoadCases() {
		val ls = Case.getAll()
		if(ls.isNotEmpty()) {
			Case.getAll().toObservable().subscribe(
					{ view?.loadOnUI(it) },
					{ it.message?.let { err -> view?.onMessage(err) } })
		}else {
			initDummyData()
		}
	}

	private fun initDummyData() {
		(1..20).toObservable().subscribe {
			val priority = if (it % 2 == 0) "Normal" else "High"
			val newItem = Case("Case number $it", "$it", priority, "", "Customer $it", "")
			newItem.save()
			view?.loadOnUI(newItem)
		}

	}
}