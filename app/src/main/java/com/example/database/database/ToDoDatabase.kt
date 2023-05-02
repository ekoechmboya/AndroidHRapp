package com.example.database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdb.database.TodoItem

@Database(entities = [TodoItem::class], version = 1)
abstract class ToDoDatabase: RoomDatabase() {
    abstract fun todoDao() : ToDoDatabaseDAO
    companion object {
        private var INSTANCE: ToDoDatabase? = null
        fun getInstance(context: Context): ToDoDatabase {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ToDoDatabase::class.java,
                        "todo_list_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}