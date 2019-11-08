package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "facts_table")
data class NutritionFacts(

    var imageResId: Int,
    var factTitle: String,
    var factDescription: String

) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}