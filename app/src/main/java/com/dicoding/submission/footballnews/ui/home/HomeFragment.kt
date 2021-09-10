package com.dicoding.submission.footballnews.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.submission.footballnews.ContentData
import com.dicoding.submission.footballnews.R
import com.dicoding.submission.footballnews.sliders.FragmentSlider
import com.dicoding.submission.footballnews.sliders.SliderIndicator
import com.dicoding.submission.footballnews.sliders.SliderPagerAdapter
import com.dicoding.submission.footballnews.sliders.SliderView


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var mAdapter : SliderPagerAdapter
    private lateinit var mIndicator : SliderIndicator
    private lateinit var mLinearLayout : LinearLayout
    private lateinit var sliderView : SliderView
    private lateinit var activity : AppCompatActivity
    private lateinit var rvHome : RecyclerView
    private var list: ArrayList<HomeModelData> = arrayListOf()
    //private var title: String = "Home"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sliderView = view.findViewById(R.id.sliderView)
        mLinearLayout = view.findViewById(R.id.pagesContainer)
        activity = AppCompatActivity()
        setupSlider()

        rvHome = view.findViewById(R.id.rv_hot_news)
        rvHome.setHasFixedSize(true)

        list.addAll(ContentData.listData)
        showRecyclerHome()
    }

    private fun showRecyclerHome() {
        rvHome.layoutManager = LinearLayoutManager(getActivity())
        val homeAdapter = HomeAdapter(list)
        rvHome.adapter = homeAdapter

    }

    private fun setupSlider() {
        sliderView.setDurationSroll(800)
        val fragments: MutableList<Fragment> = java.util.ArrayList()
        fragments.add(FragmentSlider.newInstance("https://resources.premierleague.com/photos/2020/10/01/760f1dd3-3453-4223-9239-bad12a33864c/calvert-lewin-eve-wba-hat-trick-ball.png?width=930&height=620"))
        fragments.add(FragmentSlider.newInstance("https://resources.premierleague.com/photos/premierleague/photo/2020/10/03/f636d224-24c7-4c8c-b967-15ae568916c9/2020-10-03T124251Z_1444566335_UP1EGA30ZBF7L_RTRMADP_3_SOCCER-ENGLAND-CHE-CRY-REPORT.JPG?width=860&height=573"))
        fragments.add(FragmentSlider.newInstance("https://resources.premierleague.com/photos/2020/10/03/473dd53d-8983-4b0a-bfd1-75c7db07cf47/1278274174.jpg?width=860&height=573"))
        fragments.add(FragmentSlider.newInstance("https://resources.premierleague.com/photos/2020/10/04/94d08fba-d9aa-4393-969c-0d2871264abb/1278434704.jpg?width=860&height=573"))
        fragments.add(FragmentSlider.newInstance("https://resources.premierleague.com/photos/2020/10/07/63e63052-ae76-4b8d-a3cc-f69ae1b6d3ac/GettyImages-1151086797.jpg?width=928&height=620"))

        mAdapter = SliderPagerAdapter(fragmentManager, fragments)
        sliderView.adapter = mAdapter
        mIndicator =
            SliderIndicator(getActivity()!!, mLinearLayout, sliderView, R.drawable.indicator_circle)
        mIndicator.setPageCount(fragments.size)
        mIndicator.show()
    }
}