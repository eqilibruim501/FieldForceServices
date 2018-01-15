package com.nnb.fieldforceapp.ui.cases

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.nnb.fieldforceapp.R
import com.nnb.fieldforceapp.base.activities.DIActivity
import com.nnb.fieldforceapp.data.model.Case
import com.nnb.fieldforceapp.di.activities.cases.CasesModule
import com.nnb.fieldforceapp.ui.createCase.CreateCaseActivity
import kotlinx.android.synthetic.main.activity_cases.*
import javax.inject.Inject

/**
 * Created by nnbinh on 1/9/18.
 */
class CasesActivity : DIActivity() , ICasesContract.View {
	companion object {
		fun start(ctx: Context) {
			val intent = Intent(ctx, CasesActivity::class.java)
			ctx.startActivity(intent)
		}
	}

	@Inject lateinit var presenter: CasesPresenter
	@Inject lateinit var adapter: CasesAdapter
	override fun onActivityInject() {
		appComponent.casesComponentBuilder()
				.sessionModule(CasesModule())
				.build()
				.inject(this)
		presenter.attachView(this)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_cases)
		setupRecyclerView(recyclerView,adapter)
	}

	override fun onResume() {
		super.onResume()
		adapter.clearAll()
		presenter.requestLoadCases()
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.mn_cases, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem?): Boolean {
		when(item?.itemId) {
			R.id.actAdd -> {
				CreateCaseActivity.start(this)
			}
			R.id.actSearch -> {}
			R.id.actFilter -> {}
		}
		return true
	}

	override fun onMessage(resId: Int) {
		showMessage(mainLayout, resources.getString(resId))
	}

	override fun onMessage(message: String) {
		showMessage(mainLayout, message)
	}

	override fun loadOnUI(item: Case) {
		adapter.add(item)
	}
}