package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.entity.RecipeMenu

@Dao
interface RecipeDao {
    @Insert
    fun insert(recipe: RecipeMenu)

    @Query("DELETE FROM recipe_table")
    fun deleteAllRecipes()

    @Query("SELECT * FROM recipe_table ")
    fun getAllRecipes(): LiveData<List<RecipeMenu>>

    @Query("SELECT * FROM recipe_table WHERE id=:listId")
    fun detailRecipe(listId: Int): LiveData<RecipeMenu>
}