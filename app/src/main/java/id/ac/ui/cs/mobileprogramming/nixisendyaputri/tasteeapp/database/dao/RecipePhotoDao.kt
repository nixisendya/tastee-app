package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.entity.RecipePhoto

@Dao
interface RecipePhotoDao {

    @Insert
    fun insert(photo: RecipePhoto)

    @Query("DELETE FROM photo_table")
    fun deleteAllPhotos()

    @Query("SELECT * FROM photo_table ")
    fun getAllPhotos(): LiveData<List<RecipePhoto>>

}