package org.techtown.calculater.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity
data class History(
    @PrimaryKey val uid:Int?,
    @ColumnInfo(name="expression") val expression:String?,
    @ColumnInfo(name="result") val result:String?
)