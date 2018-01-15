package com.nnb.fieldforceapp.data.model

import com.nnb.fieldforceapp.data.DBManager
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by nnbinh on 1/9/18.
 */
open class Product(): RealmObject() {
	@PrimaryKey
	private var id: Int = 0
	private var name: String = ""
	private var purchaseName: String = ""

	companion object {
		fun getAll(): MutableList<Product> = DBManager.getProducts()
	}

	constructor(name: String, purchaseName: String): this() {
		this.name = name
		this.purchaseName = purchaseName
	}


}