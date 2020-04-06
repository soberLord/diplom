package com.example.diploma.repository

import com.example.diploma.model.Record
import java.util.*

class DailyRecordsRepository : IRepository  {
    override val valuesMap = mutableMapOf<UUID, Record>()
    override val type: String
        get() = IRepository.dailyRecordsRepository
}