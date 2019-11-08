package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.fragments

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.R
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.entity.RecipePhoto
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.adapter.PhotoGalleryAdapter
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.viewmodel.RecipePhotoViewModel
import kotlinx.android.synthetic.main.fragment_recycler_list.*
import kotlinx.android.synthetic.main.fragment_recyclergrid_list.*
import kotlin.math.roundToInt

class RecipeGridListFragment : Fragment() {

    companion object {
        fun newInstance() = RecipeGridListFragment()
    }

    private lateinit var viewModel: RecipePhotoViewModel
    private val photoAdapter = PhotoGalleryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_recyclergrid_list, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecipePhotoViewModel::class.java)

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.getAllPhotos().observe(this,
            Observer<List<RecipePhoto>> {t ->
                photoAdapter.setPhotos(t!!)
                setLayoutInFragment(t.size)})
    }

    private fun setLayoutInFragment(length: Int) {
        val display = activity?.windowManager?.defaultDisplay
        val outMetrics = DisplayMetrics()
        display?.getMetrics(outMetrics)

        val density = resources.displayMetrics.density
        val dpWidth = outMetrics.widthPixels / density
        val columns = (dpWidth/180).roundToInt()

        if (length > 0) {
            grid_recycler_view.visibility = View.VISIBLE
            gallery_empty_state.visibility = View.GONE

            grid_recycler_view.apply {
                layoutManager = GridLayoutManager(activity, columns)
                adapter = photoAdapter
            }
        } else {
            grid_recycler_view.visibility = View.GONE
            gallery_empty_state.visibility = View.VISIBLE
        }

    }
}