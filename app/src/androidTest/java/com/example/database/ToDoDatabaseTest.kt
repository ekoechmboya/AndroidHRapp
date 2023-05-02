package com.example.database

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.database.database.ToDoDatabase
import com.example.database.database.ToDoDatabaseDAO
import com.example.roomdb.database.TodoItem
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ToDoDatabaseTest{

    private lateinit var todoDao: ToDoDatabaseDAO
    private lateinit var db: ToDoDatabase


    // before annotation indicates that the test is run before anything else

    @Before
    fun createDb(){
        // current accessed activity
        val context = InstrumentationRegistry.getInstrumentation().targetContext
 // create an in memory database
        db = Room.inMemoryDatabaseBuilder(context, ToDoDatabase::class.java).allowMainThreadQueries().build()

        todoDao = db.todoDao()
    }
    // after annotates after the before action testing
    @After
    @Throws(IOException::class)
    fun deleteDb(){
        db.close()
    }
    @Test
    @Throws(Exception::class)
    fun insertandGetTodo()= runBlocking{
        val todoItem = TodoItem(itemid = 1, itemname = "DummyItem", isDone = false)
        todoDao.insert(todoItem)
        val oneItem = todoDao.getById(1)
        assertEquals(oneItem?.itemid, 1)
    }

}