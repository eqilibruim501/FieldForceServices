package com.nnb.fieldforceapp.base.activities

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.net.ConnectivityManager
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.nnb.fieldforceapp.R

/**
 * Created by nnbinh on 1/4/18.
 */
abstract class BaseActivity : AppCompatActivity() {
	private val wLoadingDlg: Dialog by lazy {
		with(Dialog(this)) {
			this.window.setBackgroundDrawableResource(android.R.color.transparent);
			this.setContentView(R.layout.layout_loading_indicator)
			this
		}
	}

	@SuppressLint("MissingPermission")
	protected fun isOnline(): Boolean {
		val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
		val networkInfo = manager.activeNetworkInfo
		var isAvailable = false
		if (networkInfo != null && networkInfo.isConnected) {
			// Network is present and connected
			isAvailable = true
		}
		return isAvailable
	}

	/**
	 * request hide keyboard
	 */
	protected fun hideKeyboard() {
		val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
		imm.hideSoftInputFromWindow(this.window.decorView.applicationWindowToken, 0)
	}

	/**
	 * show message
	 * @param view: is parent layout of screen
	 * @param message: is message to show
	 * */
	protected fun showMessage(view: View, message: String) {
		Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
	}

	protected fun showHideLoadingIndicator(isShow: Boolean) {
//		hide loading dialog
		if (wLoadingDlg.isShowing)
			wLoadingDlg.dismiss()

//		show loading dialog
		if (isShow)  {
			wLoadingDlg.show()
		}
	}

	/**
	 * start fragment but don't add it into BackStack
	 * @param layoutId : id of layout where show fragment UI
	 * @param fm: the fragment you want to show
	 * */
	protected fun startFragmentNoBackStack(layoutId: Int, fm: Fragment) {
		if (fm.isAdded)
			return
		supportFragmentManager.beginTransaction()
				.replace(layoutId, fm)
				.commit()
	}

	/**
	 * setup toolbar quickly
	 * */
	fun setupToolBar(toolbar: Toolbar) {
		setSupportActionBar(toolbar)
		supportActionBar?.setDisplayHomeAsUpEnabled(true)
		supportActionBar?.setDisplayShowHomeEnabled(true)
		toolbar.setNavigationOnClickListener { finish() }
	}

	/**
	 * setup recycler view quickly
	 * */
	fun setupRecyclerView(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>, layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)) {
		recyclerView.setItemViewCacheSize(20)
		recyclerView.layoutManager = layoutManager
		recyclerView.adapter = adapter
	}
}