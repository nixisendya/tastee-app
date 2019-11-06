package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.R
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.adapter.RecipeAdapter
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.entity.RecipeMenu
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.viewmodel.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_recycler_list.*

class MenuRecyclerFragment2 : Fragment() {

    companion object {
        fun newInstance() = MenuRecyclerFragment2()
    }

    private lateinit var recipeViewModel: RecipeViewModel
    private val recipeAdapter = RecipeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_recycler_list, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recipeViewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)

        list_recycler_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
            // set the custom adapter to the RecyclerView
            adapter = recipeAdapter
        }

        observeViewModel()
    }

    fun observeViewModel() {
        recipeViewModel.getAllRecipes()
            .observe(this, Observer<List<RecipeMenu>> { t -> recipeAdapter.setRecipes(t!!) })
    }

}