package com.nnb.fieldforceapp.ui.createCase

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.nnb.fieldforceapp.R
import com.nnb.fieldforceapp.base.activities.DIActivity
import com.nnb.fieldforceapp.data.model.Case
import com.nnb.fieldforceapp.di.activities.createCase.CreateCaseModule
import kotlinx.android.synthetic.main.activity_create_case.*
import javax.inject.Inject

/**
 * Created by nnbinh on 1/9/18.
 */
class CreateCaseActivity : DIActivity(), ICreateCaseContract.View {
	companion object {
		val REQ_CREATE_PRODUCT_ACTIVITY = 1001
		fun start(activity: Activity) {
			val intent = Intent(activity, CreateCaseActivity::class.java)
			activity.startActivityForResult(intent, REQ_CREATE_PRODUCT_ACTIVITY)
		}
	}
	@Inject
	lateinit var presenter: CreateCasePresenter

	override fun onActivityInject() {
		appComponent.createCaseComponentBuilder()
				.sessionModule(CreateCaseModule())
				.build()
				.inject(this)
		presenter.attachView(this)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_create_case)
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.mn_create_case, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem?): Boolean {
		if (item?.itemId == R.id.actSave) {
			val name: String = txtName.text.toString()
			if(presenter.validateName(name)) {
				val number: String = txtCaseNumber.text.toString()
				val priority: String = txtPriority.text.toString()
				val origin: String = txtOrigin.text.toString()
				val customer: String = txtCustomer.text.toString()
				val statusReason: String = txtStatusReason.text.toString()
				presenter.save(name, number, priority, origin, customer, statusReason)
			}
		}

		return true
	}

	override fun onMessage(resId: Int) {
		showMessage(mainLayout, resources.getString(resId))
	}

	override fun onMessage(message: String) {
		showMessage(mainLayout, message)
	}

	override fun successful(item: Case) {
		showMessage(mainLayout, resources.getString(R.string.save_successful))
	}
}