package com.example.database.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdb.database.TodoItem


@Dao
interface ToDoDatabaseDAO {
    @Query("Select * from my_to_do_list")
    fun getAll(): LiveData<List<TodoItem>>
    @Query("Select * from my_to_do_list where itemid = :id")
    fun getById(id : Int) : TodoItem?

    @Insert
    suspend fun insert(item: TodoItem)

    @Update
    suspend fun update(item: TodoItem)

    @Delete
    suspend fun delete(item: TodoItem)

    @Query("Delete from my_to_do_list")
    suspend fun deleteAllTodos()
}