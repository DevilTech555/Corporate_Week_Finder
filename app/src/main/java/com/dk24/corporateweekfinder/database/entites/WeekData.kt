package com.dk24.corporateweekfinder.database.entites

import com.dk24.corporateweekfinder.enums.WeekType
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class WeekData {
    @Id(assignable = true)
    var id: Long = 0
    var weekType: String? = null
    var startDate: String? = null
    var endDate: String? = null
}
