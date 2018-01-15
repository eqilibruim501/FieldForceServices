package com.nnb.fieldforceapp.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by nnbinh on 1/15/18.
 */
object DateUtil {
	val FORMAT_dd_MM_yyyy = "dd/MM/yyyy"
	val FORMAT_FULL_dd_MM_yyyy = "dd/MM/yyyy HH:mm:ss"

	fun getToday(): Date {
		return Calendar.getInstance().time
	}

	fun getFullToday(): String {
		return convertToString(getToday(), FORMAT_FULL_dd_MM_yyyy)
	}

	fun getShortToday(): String {
		return convertToString(getToday(), FORMAT_dd_MM_yyyy)
	}
	fun isToday(date: Date): Boolean {
		val dateCal = Calendar.getInstance()
		dateCal.time = date

		val today = Calendar.getInstance()
		return today.get(Calendar.YEAR) == dateCal.get(Calendar.YEAR) &&
				today.get(Calendar.MONTH) == dateCal.get(Calendar.MONTH) &&
				today.get(Calendar.DAY_OF_MONTH) == dateCal.get(Calendar.DAY_OF_MONTH)
	}



	fun convertToDate(strDate: String, format: String): Date? {
		val dateFormat = SimpleDateFormat(format)
		try {
			return dateFormat.parse(strDate)
		} catch (e: ParseException) {
			e.printStackTrace()
		}

		return null
	}

	fun convertToString(year: Int, month: Int, dayOfMonth: Int, format: String): String {
		val calendar = Calendar.getInstance()
		calendar.set(year, month, dayOfMonth, 0, 0, 0)
		return DateUtil.convertToString(calendar.time, format)
	}

	fun convertToString(date: Date, format: String): String {
		val dateFormat = SimpleDateFormat(format)
		return dateFormat.format(date)
	}
}