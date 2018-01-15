package com.nnb.fieldforceapp.ui.cases

import android.databinding.DataBindingUtil
import android.view.ViewGroup
import com.nnb.fieldforceapp.R
import com.nnb.fieldforceapp.base.recyclerView.BaseAdapter
import com.nnb.fieldforceapp.base.recyclerView.BaseViewHolder
import com.nnb.fieldforceapp.data.model.Case
import com.nnb.fieldforceapp.databinding.LayoutCaseItemBinding

/**
 * Created by nnbinh on 1/15/18.
 */
class CasesAdapter : BaseAdapter<Case>() {
	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<Case> {
		return CaseHolder(parent!!)
	}

	inner class CaseHolder(parent: ViewGroup) : BaseViewHolder<Case>(parent, R.layout.layout_case_item) {
		private val bind: LayoutCaseItemBinding = DataBindingUtil.bind(itemView)
		override fun onBindItem(item: Case, position: Int) {
			bind.item = item
		}

	}
}