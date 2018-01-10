package com.nnb.fieldforceapp.ui.createProduct

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import com.nnb.fieldforceapp.R
import com.nnb.fieldforceapp.base.activities.DIActivity
import com.nnb.fieldforceapp.di.activities.createProduct.CreateProductModule
import javax.inject.Inject

/**
 * Created by nnbinh on 1/9/18.
 */
class CreateProductActivity : DIActivity(), ICreateProductContract.View {
	companion object {
		val REQ_CREATE_PRODUCT_ACTIVITY = 1001
		fun start(activity: Activity) {
			val intent = Intent(activity, CreateProductActivity::class.java)
			activity.startActivityForResult(intent, REQ_CREATE_PRODUCT_ACTIVITY)
		}
	}
	@Inject
	lateinit var presenter: CreateProductPresenter

	override fun onActivityInject() {
		appComponent.createProductComponentBuilder()
				.sessionModule(CreateProductModule())
				.build()
				.inject(this)
		presenter.attachView(this)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_create_product)
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.mn_create_product, menu)
		return true
	}

	override fun onMessage(resId: Int) {
	}

	override fun onMessage(message: String) {
	}
}