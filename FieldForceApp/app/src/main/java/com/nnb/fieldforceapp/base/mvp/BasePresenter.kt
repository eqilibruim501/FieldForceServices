package com.nnb.fieldforceapp.base.mvp

import java.lang.ref.WeakReference

/**
 * Created by nnbinh on 1/7/18.
 */
open class BasePresenter<V: ILifeCycle.View>: ILifeCycle.Presenter<V> {
	private var weekRef: WeakReference<V>? = null
	val view: V?
		get() = weekRef?.get()

	private val isViewAttached: Boolean
		get() = weekRef != null && weekRef!!.get() != null

	override fun attachView(view: V) {
		if (!isViewAttached) {
			weekRef = WeakReference(view)
			view.setPresenter(this)
		}
	}

	override fun detachView() {
		weekRef?.clear()
		weekRef = null
	}

	override fun onResume() {
	}

	override fun onPause() {
	}
}