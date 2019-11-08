package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.viewmodel.NutritionFactsViewModel
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.R
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.entity.NutritionFacts
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.entity.RecipePhoto
import kotlinx.android.synthetic.main.fragment_nutritionfact.*
import kotlinx.android.synthetic.main.fragment_recipedetail.*

class FactsFragment : Fragment() {

    companion object {
        fun newInstance() = FactsFragment()
    }

    private lateinit var viewModel: NutritionFactsViewModel
    private var randomId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_nutritionfact, container, false)

        viewModel = ViewModelProviders.of(this).get(NutritionFactsViewModel::class.java)
        observeViewModel()

        return view
    }


    fun observeViewModel() {

        randomFactIndex()
        Log.d("FactId", "$randomId")

        viewModel.getFact(randomId).observe(this, Observer { fact ->
            fact?.let {
                fact_icon.setImageResource(fact.imageResId)
                fact_description.text = fact.factDescription
            }
        })

    }

    private fun randomFactIndex() {

        randomId = (0..6).random()

    }
}