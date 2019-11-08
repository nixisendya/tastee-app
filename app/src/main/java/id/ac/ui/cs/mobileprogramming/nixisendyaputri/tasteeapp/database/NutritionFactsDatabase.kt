package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.dao.NutritionFactsDao
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.data.PopulateFactsDbAsyncTask
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.entity.NutritionFacts

@Database(entities = [NutritionFacts::class], version = 1)
abstract class NutritionFactsDatabase : RoomDatabase() {

    abstract fun factsDao(): NutritionFactsDao

    companion object {
        private var instance: NutritionFactsDatabase? = null

        fun getInstance(context: Context): NutritionFactsDatabase? {
            if (instance == null) {
                synchronized(NutritionFactsDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NutritionFactsDatabase::class.java, "facts_database"
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
                PopulateFactsDbAsyncTask(instance)
                    .execute()
            }
        }
    }
}
