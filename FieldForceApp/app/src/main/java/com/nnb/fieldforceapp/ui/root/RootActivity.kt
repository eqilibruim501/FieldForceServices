package com.nnb.fieldforceapp.ui.root

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.nnb.fieldforceapp.R
import com.nnb.fieldforceapp.base.BaseActivity

/**
 * Created by nnbinh on 1/4/18.
 */
class RootActivity : BaseActivity() {
	companion object {
		fun start(ctx: Context) {
			val intent = Intent(ctx, RootActivity::class.java)
			ctx.startActivity(intent)
		}
	}
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_root)
	}
}