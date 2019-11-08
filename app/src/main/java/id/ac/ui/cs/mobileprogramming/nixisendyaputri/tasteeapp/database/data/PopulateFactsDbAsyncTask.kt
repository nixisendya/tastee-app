package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.data

import android.os.AsyncTask
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.R
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.NutritionFactsDatabase
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.entity.NutritionFacts

class PopulateFactsDbAsyncTask(db: NutritionFactsDatabase?) : AsyncTask<Unit, Unit, Unit>() {
    private val factsDao = db?.factsDao()

    override fun doInBackground(vararg p0: Unit?) {
        factsDao?.insert(
            NutritionFacts(
                imageResId = R.drawable.ic_avocado,
                factTitle = "Fun Fact About Avocados",
                factDescription = "An avocado has more than twice as much potassium as a banana."
            )
        )
        factsDao?.insert(
            NutritionFacts(
                imageResId = R.drawable.ic_broccoli,
                factTitle = "Fun Fact About Broccoli",
                factDescription = "Broccoli contains twice the vitamin C of an orange and almost as much calcium as whole milk!"
            )
        )
        factsDao?.insert(
            NutritionFacts(
                imageResId = R.drawable.ic_fried_egg,
                factTitle = "Fun Fact About Eggs",
                factDescription = "Eggs contain the highest quality food protein known. All parts of an egg are edible, including the shell."
            )
        )
        factsDao?.insert(
            NutritionFacts(
                imageResId = R.drawable.ic_peanut_butter,
                factTitle = "Fun Fact About Peanut Butter",
                factDescription = "To increase the protein in peanut butter, Brewer’s yeast can be mixed in - a useful tip for vegetarians."
            )
        )
        factsDao?.insert(
            NutritionFacts(
                imageResId = R.drawable.ic_lemon,
                factTitle = "Fun Fact About Lemons",
                factDescription = "Lemons are considered one of the world's healthiest foods - one lemon contains your daily dose of vitamin C!"
            )
        )
        factsDao?.insert(
            NutritionFacts(
                imageResId = R.drawable.ic_bubble_tea,
                factTitle = "Fun Fact About Modern Diet",
                factDescription = "Sugary drinks are the most fattening product in the modern diet - lay low on those bubble teas!"
            )
        )
        factsDao?.insert(
            NutritionFacts(
                imageResId = R.drawable.ic_kale,
                factTitle = "Fun Fact About Kale",
                factDescription = "Kale contains lutein and zeaxanthin, which protect the eyes from macular degeneration."
            )
        )
    }
}