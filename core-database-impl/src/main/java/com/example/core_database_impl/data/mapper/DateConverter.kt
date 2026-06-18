package com.example.core_database_impl.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class DateConverter {

    private val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")

    @TypeConverter
    fun toLocalDate(value: String?): LocalDate? {
        return value?.let { LocalDate.parse(it) }
    }

    // Из LocalDate в строку для базы данных (ГГГГ-ММ-ДД)
    @TypeConverter
    fun fromLocalDate(date: LocalDate?): String? {
        return date?.toString()
    }

}