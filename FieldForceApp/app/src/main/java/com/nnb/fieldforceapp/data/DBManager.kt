package com.nnb.fieldforceapp.data

import com.nnb.fieldforceapp.data.model.Case
import com.nnb.fieldforceapp.data.model.Product
import io.realm.Realm

/**
 * Created by nnbinh on 1/15/18.
 */
object DBManager {
	private val realm: Realm by lazy { Realm.getDefaultInstance() }
	fun getProducts(): MutableList<Product> {
		var res: MutableList<Product> = arrayListOf()
		val ls = realm.where(Product::class.java).findAll()
		if (ls.isNotEmpty()) {
			res = realm.copyFromRealm(ls)
		}
		return res
	}

	fun getCases(): MutableList<Case> {
		var res: MutableList<Case> = arrayListOf()
		val ls = realm.where(Case::class.java).findAll()
		if (ls.isNotEmpty()) {
			res = realm.copyFromRealm(ls)
		}
		return res
	}

	fun saveCase(item: Case) {
		realm.executeTransaction { r-> r.insertOrUpdate(item) }
	}

	fun getNewCaseId():Int {
		val currentIdNum = realm.where(Case::class.java).max("id")
		return if (currentIdNum == null) 1 else currentIdNum!!.toInt() + 1
	}
}