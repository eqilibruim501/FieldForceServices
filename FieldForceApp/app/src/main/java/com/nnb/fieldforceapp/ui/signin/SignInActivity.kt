package com.nnb.fieldforceapp.ui.signin

import android.os.Bundle
import com.nnb.fieldforceapp.R
import com.nnb.fieldforceapp.base.activities.BaseActivity
import com.nnb.fieldforceapp.ui.root.RootActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

/**
 * Created by nnbinh on 1/4/18.
 */
class SignInActivity : BaseActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_sign_in)
		actSignIn.setOnClickListener {
			RootActivity.start(this)
		}
	}
}