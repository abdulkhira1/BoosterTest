package com.booster.test.ui.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.booster.test.MainActivity
import com.booster.test.R
import com.booster.test.utils.Constants
import ir.mahozad.android.PieChart
import kotlinx.android.synthetic.main.fragment_investor_type.*

class InvestorTypeFragment : Fragment(R.layout.fragment_investor_type) {

    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

        txtTitle.text = arguments?.getString(Constants.INVESTOR_TYPE)

        btnStart.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(Constants.INVESTOR_TYPE, txtTitle.text.toString())
            Constants.navigateFragment(
                findNavController(),
                R.id.navigation_quiz,
                bundle
            )
        }

        pieChart.apply {
            labelsColor = Color.BLACK
            isAnimationEnabled = true
            legendPosition = PieChart.LegendPosition.BOTTOM
        }

        pieChart.slices = listOf(
            PieChart.Slice(0.15f, Color.MAGENTA),
            PieChart.Slice(0.1f, Color.YELLOW),
            PieChart.Slice(0.05f, Color.CYAN),
            PieChart.Slice(0.1f, Color.GRAY),
            PieChart.Slice(0.6f, Color.BLUE)
        )

    }

}