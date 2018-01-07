package com.nnb.fieldforceapp.ui.root

import android.databinding.DataBindingUtil
import android.view.ViewGroup
import com.nnb.fieldforceapp.R
import com.nnb.fieldforceapp.base.recyclerView.BaseAdapter
import com.nnb.fieldforceapp.base.recyclerView.BaseViewHolder
import com.nnb.fieldforceapp.data.model.Action
import com.nnb.fieldforceapp.databinding.LayoutItemActionBinding

/**
 * Created by nnbinh on 1/7/18.
 */
class ActionsAdapter(private val listener: BaseViewHolder.OnClickListener<Action>) : BaseAdapter<Action>(Action.actions) {
	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<Action> {
		return ActionHolder(parent!!)
	}

	inner class ActionHolder(parent: ViewGroup) : BaseViewHolder<Action>(parent, R.layout.layout_item_action) {
		private val bind : LayoutItemActionBinding = DataBindingUtil.bind(itemView)
		override fun onBindItem(item: Action, position: Int) {
			setOnClickListener(listener)
			bind.item = item
			bind.imgIcon.setImageResource(item.imageResId)
			bind.executePendingBindings()
		}
	}
}