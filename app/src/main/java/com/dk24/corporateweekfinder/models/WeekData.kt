package com.dk24.corporateweekfinder.models

import com.dk24.corporateweekfinder.utilites.SharedPreferHelper

data class WeekData(
    var label: String,
    var fromLabel: String,
    var toLabel: String,
    var fromSharedPrefersKey: SharedPreferHelper.Companion.Key,
    var toSharedPrefersKey: SharedPreferHelper.Companion.Key
)


fun getWeekDataConfigure() : List<WeekData> {
    val weekDataList: ArrayList<WeekData> = arrayListOf()
    WeekData(
        "Select dates for grooming week:",
        "Start Date",
        "End Date",
        SharedPreferHelper.Companion.Key.GROOMING_START_DATE,
        SharedPreferHelper.Companion.Key.GROOMING_END_DATE
    ).also {
        weekDataList.add(it)
    }
    WeekData(
        "Select dates for development week:",
        "Start Date",
        "End Date",
        SharedPreferHelper.Companion.Key.DEVELOPMENT_START_DATE,
        SharedPreferHelper.Companion.Key.DEVELOPMENT_END_DATE
    ).also {
        weekDataList.add(it)
    }
    WeekData(
        "Select dates for release week:",
        "Start Date",
        "End Date",
        SharedPreferHelper.Companion.Key.RELEASE_START_DATE,
        SharedPreferHelper.Companion.Key.RELEASE_END_DATE
    ).also {
        weekDataList.add(it)
    }
    return weekDataList.toList()
}
