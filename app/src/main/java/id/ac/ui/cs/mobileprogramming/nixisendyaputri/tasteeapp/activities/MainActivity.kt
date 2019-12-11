package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.ui.AppBarConfiguration
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.R
import kotlinx.android.synthetic.main.activity_homepage.*
import androidx.lifecycle.ViewModelProviders
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.viewmodel.RecipeViewModel


class MainActivity : AppCompatActivity(){

    //private lateinit var appBarConfiguration: AppBarConfiguration

    init {
        System.loadLibrary("tastee")
    }

    /**
     * Get random number
     */
    external fun randNumber(): Int
    private lateinit var viewModel: RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        viewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)

        val number = randNumber()
        viewModel.detailRecipe(number).observe(this, Observer { recipe ->
            recipe?.let {
                textview_recommended.text = recipe.name
                //textview_recommended.text = number.toString()
            }
        })

        //textview_recommended.text = number.toString()
    }


}
