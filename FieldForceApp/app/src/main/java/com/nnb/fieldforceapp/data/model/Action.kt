package com.nnb.fieldforceapp.data.model

import com.nnb.fieldforceapp.R


/**
 * Created by nnbinh on 1/7/18.
 */
class Action(val id: Int, var imageResId: Int, var name: String, var description: String) {
	companion object {
		val actions:MutableList<Action> by lazy {
			val ls: MutableList<Action> = arrayListOf()

			ls.add(Action(1, R.mipmap.ic_launcher_round, "Dashboard", "Quick Overview"))
			ls.add(Action(2, R.mipmap.ic_launcher_round, "Accounts", "List of Accounts"))
			ls.add(Action(3, R.mipmap.ic_launcher_round, "Bookable Resource Bookings", "List of Bookable Resource Bookings"))
			ls.add(Action(4, R.mipmap.ic_launcher_round, "Contacts", "List of Contacts"))
			ls.add(Action(5, R.mipmap.ic_launcher_round, "Customer Asset", "List of Customer Asset"))
			ls.add(Action(6, R.mipmap.ic_case, "Case", "List of Cases"))
			ls.add(Action(7, R.mipmap.ic_launcher_round, "Agreements", "List of Agreements"))
			ls.add(Action(8, R.mipmap.ic_launcher_round, "Time Off Requests", "List of Time Off Requests"))
			ls.add(Action(9, R.mipmap.ic_gps, "Map", "View Entities on a Map"))
			ls.add(Action(10, R.mipmap.ic_launcher_round, "Activities", "List of activities"))
			ls.add(Action(11, R.mipmap.ic_launcher_round, "Calendar", "Calendar"))

			ls
		}
	}
}