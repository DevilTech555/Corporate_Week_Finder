package com.dk24.corporateweekfinder.database

import android.content.Context
import com.dk24.corporateweekfinder.database.entites.MyObjectBox
import com.dk24.corporateweekfinder.database.entites.WeekData
import io.objectbox.Box
import io.objectbox.BoxStore


class AppDatabase {

    companion object {

        @Volatile private var INSTANCE: AppDatabase? = null

        private var store: BoxStore? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase().also {
                    INSTANCE = it
                    store =  MyObjectBox.builder()
                        .androidContext(context.applicationContext)
                        .build()
                }
            }

        private fun buildDatabase() = AppDatabase()

        fun getWeekDataList() = store?.boxFor(WeekData::class.java)?.all

        fun putWeekData(weekData: WeekData) {
            store?.boxFor(WeekData::class.java)?.put(weekData)
        }
    }
}
