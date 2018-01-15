package com.nnb.fieldforceapp.ui.root

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import com.nnb.fieldforceapp.R
import com.nnb.fieldforceapp.base.activities.DIActivity
import com.nnb.fieldforceapp.base.recyclerView.BaseViewHolder
import com.nnb.fieldforceapp.data.model.Action
import com.nnb.fieldforceapp.di.activities.root.RootModule
import kotlinx.android.synthetic.main.activity_root.*
import javax.inject.Inject
import com.nnb.fieldforceapp.ui.cases.CasesActivity


/**
 * Created by nnbinh on 1/4/18.
 */
class RootActivity : DIActivity(),
		IRootContract.View,
		BaseViewHolder.OnClickListener<Action> {
	companion object {
		fun start(ctx: Context) {
			val intent = Intent(ctx, RootActivity::class.java)
			ctx.startActivity(intent)
		}
	}

	@Inject lateinit var presenter : RootPresenter
	@Inject lateinit var actions : MutableList<Action>
	private val adapter: ActionsAdapter by lazy { ActionsAdapter(this) }
	override fun onActivityInject() {
		appComponent.rootComponentBuilder()
				.sessionModule(RootModule())
				.build()
				.inject(this)
		presenter.attachView(this)
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.mn_root, menu)
		return true
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_root)
		setupRecyclerView()
	}

	override fun onMessage(message: String) {
		showMessage(mainLayout, message)
	}

	override fun onMessage(resId: Int) {
		showMessage(mainLayout, resources.getString(resId))
	}

	override fun onClickItem(item: Action?, position: Int) {
		CasesActivity.start(this)
	}

	private fun setupRecyclerView() {
		recyclerView.setItemViewCacheSize(20)
		val manager = LinearLayoutManager(this)
		recyclerView.layoutManager = manager
		recyclerView.adapter = adapter
	}
}