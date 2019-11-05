package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.dao.RecipeDao
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.data.PopulateDbAsyncTask
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.entity.RecipeMenu

@Database(entities = [RecipeMenu::class], version = 1)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    companion object {
        private var instance: RecipeDatabase? = null

        fun getInstance(context: Context): RecipeDatabase? {
            if (instance == null) {
                synchronized(RecipeDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RecipeDatabase::class.java, "recipe_database"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()
                }
            }
            return instance
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(instance)
                    .execute()
            }
        }
    }
}