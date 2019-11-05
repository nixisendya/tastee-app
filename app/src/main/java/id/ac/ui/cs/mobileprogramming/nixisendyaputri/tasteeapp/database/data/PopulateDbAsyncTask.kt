package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.data
import android.os.AsyncTask
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.R
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.RecipeDatabase
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.entity.RecipeMenu

class PopulateDbAsyncTask(db: RecipeDatabase?) : AsyncTask<Unit, Unit, Unit>() {
    private val recipeDao = db?.recipeDao()

    override fun doInBackground(vararg p0: Unit?) {
        recipeDao?.insert(
            RecipeMenu(
            id = 0,
            imageResId = R.drawable.all_recipe1,
            name = "Summer Pasta Primavera",
            rating = "4.6",
            total_cook_time = "30 min",
            prep_time = "10 min",
            cook_time = "20 min",
            difficulty = "easy",
            servings = "2 pp")
        )
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.all_recipe2,
                name = "Juicy Steakhouse Burgers",
                rating = "4.8",
                total_cook_time = "35 min",
                prep_time = "10 min",
                cook_time = "25 min",
                difficulty = "hard",
                servings = "3 pp"
            )
        )
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.all_recipe3,
                name = "Chicken Curry",
                rating = "4.4",
                total_cook_time = "40 min",
                prep_time = "10 min",
                cook_time = "30 min",
                difficulty = "hard",
                servings = "2 pp"
            )
        )
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.all_recipe4,
                name = "Baja Fish Tacos",
                rating = "4.5",
                total_cook_time = "35 min",
                prep_time = "10 min",
                cook_time = "25 min",
                difficulty = "easy",
                servings = "4 pp"
            )
        )
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.all_recipe5,
                name = "Green Salad",
                rating = "4.4",
                total_cook_time = "20 min",
                prep_time = "15 min",
                cook_time = "5 min",
                difficulty = "easy",
                servings = "3 pp"
            )
        )
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.all_recipe6,
                name = "Strawberry Shortcake",
                rating = "4.7",
                total_cook_time = "35 min",
                prep_time = "10 min",
                cook_time = "25 min",
                difficulty = "easy",
                servings = "2 pp"
            )
        )
    }
}