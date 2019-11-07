package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.R
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.fragments.IngredientsFragment
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.fragments.InstructionsFragment


class MyPagerAdapter(fm: FragmentManager, context: Context) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                IngredientsFragment()
            } else -> {
                return InstructionsFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    private val tabTitles = arrayOf<String>(
        context.resources.getString(R.string.string_ingredients),
        context.resources.getString(R.string.string_instruction)
    )


    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> tabTitles[0]
            else -> {
                return tabTitles[1]
            }
        }
    }
}