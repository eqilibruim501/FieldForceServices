package com.nnb.fieldforceapp.base.mvp

/**
 * Created by nnbinh on 1/7/18.
 */
interface ILifeCycle {
	interface View {
		fun setPresenter(presenter: BasePresenter<*>)
		fun onMessage(resId: Int)
		fun onMessage(message: String)
	}

	interface Presenter<in V: View> {
		fun attachView(view: V)
		fun detachView()
		fun onResume()
		fun onPause()
	}
}