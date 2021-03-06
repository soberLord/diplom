package com.example.diplom_DP.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.diplom_DP.model.Record
import java.util.*

@Entity (tableName = "records")
data class RecordEntity (
    @PrimaryKey
    override val uuid: UUID,
    override var date: Long,
    override var timeFrom: String,
    override var timeTo: String,
    override var title: String,
    override var info: String,
    override var type: String,
    override var isCompleted: Boolean
) : Record {
    override fun toString(): String {
        return "id - $uuid, $date, $timeFrom - $timeTo, $title, $info, $type"
    }
}