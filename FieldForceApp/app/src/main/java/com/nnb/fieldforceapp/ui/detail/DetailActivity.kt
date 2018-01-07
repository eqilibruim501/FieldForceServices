package com.nnb.fieldforceapp.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.nnb.fieldforceapp.R
import com.nnb.fieldforceapp.base.activities.BaseActivity

/**
 * Created by nnbinh on 1/7/18.
 */
class DetailActivity : BaseActivity() {
	companion object {
		fun start(ctx: Context) {
			val intent = Intent(ctx, DetailActivity::class.java)
			ctx.startActivity(intent)
		}
	}
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_detail)
	}
}