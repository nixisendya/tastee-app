package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.entity.NutritionFacts
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.entity.RecipeMenu
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.repository.NutritionFactsRepository

class NutritionFactsViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: NutritionFactsRepository = NutritionFactsRepository(application)
    private var allFacts: LiveData<List<NutritionFacts>> = repository.getAllFacts()
    private lateinit var fact: LiveData<NutritionFacts>

    fun insert(fact: NutritionFacts) {
        repository.insert(fact)
    }

    fun getAllFacts(): LiveData<List<NutritionFacts>> {
        return allFacts
    }

    fun getFact(listId: Int): LiveData<NutritionFacts> {
        fact = repository.getFact(listId)
        return fact
    }
}