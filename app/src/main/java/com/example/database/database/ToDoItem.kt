package com.example.roomdb.database
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
// entity class
@Entity(tableName = "my_to_do_list")
data class TodoItem (
    @PrimaryKey(autoGenerate = true)
    var itemid: Long= 0L,
    @ColumnInfo(name = "item name")
    var itemname: String,
    @ColumnInfo(name = "is complete")
    var isDone: Boolean= false
)