package com.nnb.fieldforceapp.ui.products

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.nnb.fieldforceapp.R
import com.nnb.fieldforceapp.base.activities.BaseActivity
import com.nnb.fieldforceapp.base.activities.DIActivity
import com.nnb.fieldforceapp.ui.createProduct.CreateProductActivity

/**
 * Created by nnbinh on 1/9/18.
 */
class ProductsActivity : BaseActivity() {
	companion object {
		fun start(ctx: Context) {
			val intent = Intent(ctx, ProductsActivity::class.java)
			ctx.startActivity(intent)
		}
	}
//	override fun onActivityInject() {
//	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_products)
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.mn_products, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem?): Boolean {
		when(item?.itemId) {
			R.id.actAdd -> {
				CreateProductActivity.start(this)
			}
			R.id.actSearch -> {}
			R.id.actFilter -> {}
		}
		return true
	}

//	override fun onMessage(resId: Int) {
//	}
//
//	override fun onMessage(message: String) {
//	}

}