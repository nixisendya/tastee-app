package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.R
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.viewmodel.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_ingredients.*


/**
 * A simple [Fragment] subclass.
 */
class IngredientsFragment : Fragment() {

    companion object {
        fun newInstance() = IngredientsFragment()
    }

    private lateinit var viewModel: RecipeViewModel
    private var recipeId = 0
    private var strRecipeId = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_ingredients, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let {
            recipeId = RecipeDetailFragmentArgs.fromBundle(it).id
        }

        viewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)
        observeViewModel()
    }

    fun observeViewModel() {

        viewModel.detailRecipe(recipeId+1).observe(this, Observer { recipe ->
            recipe?.let {
                textview_ingredients.text = recipe.ingredientList
            }
        })

    }
}