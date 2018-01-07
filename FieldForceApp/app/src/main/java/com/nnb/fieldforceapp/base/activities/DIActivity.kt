package com.nnb.fieldforceapp.base.activities

import android.os.Bundle
import com.nnb.fieldforceapp.FieldForceApp
import com.nnb.fieldforceapp.base.mvp.BasePresenter
import com.nnb.fieldforceapp.base.mvp.ILifeCycle
import com.nnb.fieldforceapp.di.app.AppComponent

/**
 * Created by nnbinh on 1/7/18.
 */
abstract class DIActivity : BaseActivity(), ILifeCycle.View {
	private var wPresenter: BasePresenter<*>? = null
	val appComponent: AppComponent by lazy { FieldForceApp.appComponent }
	protected abstract fun onActivityInject()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		onActivityInject()
	}

	override fun setPresenter(presenter: BasePresenter<*>) {
		this.wPresenter = presenter
	}

	override fun onResume() {
		super.onResume()
		wPresenter?.onResume()
	}

	override fun onPause() {
		wPresenter?.onPause()
		super.onPause()
	}
	override fun onDestroy() {
		super.onDestroy()
		wPresenter?.detachView()
		wPresenter = null
	}
}