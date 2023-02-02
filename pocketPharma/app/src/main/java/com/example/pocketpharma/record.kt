package com.example.pocketpharma

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "record_table")
class Record(

    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "id_") val id_: String,
    @ColumnInfo(name = "KOD_LATKY") val KOD_LATKY: String,
    @ColumnInfo(name = "NAZEV_INN") val NAZEV_INN: String,
    @ColumnInfo(name = "NAZEV_EN") val NAZEV_EN: String,
    @ColumnInfo(name = "NAZEV") val NAZEV: String
)