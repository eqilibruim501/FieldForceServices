package com.nnb.fieldforceapp.data.model

import com.nnb.fieldforceapp.data.DBManager
import com.nnb.fieldforceapp.utils.DateUtil
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by nnbinh on 1/15/18.
 */
open class Case(): RealmObject() {
	@PrimaryKey
	var id: Int = DBManager.getNewCaseId()
	var name: String = ""
	var number: String = ""
	var priority: String = ""
	var origin: String = ""
	var customer: String = ""
	var statusReason: String = ""
	var createdOn: String = DateUtil.getFullToday()

	companion object {
		fun getAll(): MutableList<Case> = DBManager.getCases()
	}

	constructor(name: String): this() {
		this.name = name
	}

	constructor(name: String, number: String = "", priority: String = "", origin: String = "", customer: String = "", statusReason: String = ""): this() {
		this.name = name
		this.number = number
		this.priority = priority
		this.origin = origin
		this.customer = customer
		this.statusReason = statusReason
	}

	fun save() { DBManager.saveCase(this) }
}