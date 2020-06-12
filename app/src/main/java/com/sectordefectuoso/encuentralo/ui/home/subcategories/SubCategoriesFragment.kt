package com.sectordefectuoso.encuentralo.ui.home.subcategories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sectordefectuoso.encuentralo.R
import com.sectordefectuoso.encuentralo.data.model.Category
import com.sectordefectuoso.encuentralo.ui.home.adapter.CategoriesAdapter
import com.sectordefectuoso.encuentralo.utils.BaseFragment
import com.sectordefectuoso.encuentralo.utils.GridSpacingDecoration
import kotlinx.coroutines.ExperimentalCoroutinesApi


class SubCategoriesFragment : BaseFragment() {
    private lateinit var homeViewModel: SubCategoriesViewModel
    override val TAG: String
        get() = "HomeFragment"

    override fun getLayout(): Int = R.layout.fragment_home

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        /*
        homeViewModel =
              ViewModelProvider(this).get(HomeViewModel::class.java)

         */
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        var categories: ArrayList<Category> = arrayListOf(
            Category("1", "Reparacion", "", "", 1),
            Category("2", "Belleza", "", "",  2)
        )

        val rvCategories: RecyclerView = root.findViewById(R.id.rvCategories)
        val rvAdapter = CategoriesAdapter(categories)
        rvCategories.adapter = rvAdapter
        rvCategories.layoutManager = GridLayoutManager(this.context, 3, LinearLayoutManager.VERTICAL, false)

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.default_padding)
        rvCategories.addItemDecoration(GridSpacingDecoration(3 , spacingInPixels, true, 0))

        /*
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        */
        return root
    }
}
