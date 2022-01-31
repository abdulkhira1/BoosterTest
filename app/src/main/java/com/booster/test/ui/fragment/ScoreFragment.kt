package com.booster.test.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.booster.test.MainActivity
import com.booster.test.R
import com.booster.test.utils.Constants
import kotlinx.android.synthetic.main.fragment_investor_type.*
import kotlinx.android.synthetic.main.fragment_score.*

class ScoreFragment : Fragment(R.layout.fragment_score) {

    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    @SuppressLint("SetTextI18n")
    private fun initView() {

        val score = arguments?.getString(Constants.SCORE)?.toInt()

        totalScore.text = arguments?.getString(Constants.SCORE)

        btnSubmit.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(Constants.INVESTOR_TYPE, arguments?.getString(Constants.INVESTOR_TYPE))
            bundle.putString(Constants.SCORE, totalScore.text.toString())
            Constants.navigateFragment(
                findNavController(),
                R.id.navigation_sign_up,
                bundle
            )
        }

        if (score != null) {
            when (score) {
                in 5..12 -> {
                    investorType.text = "Your are \"Defensive\" investor type"
                }
                in 13..20 -> {
                    investorType.text = "Your are \"Conservative\" investor type"
                }
                in 21..29 -> {
                    investorType.text = "Your are \"Balanced\" investor type"
                }
                in 30..37 -> {
                    investorType.text = "Your are \"Balanced Growth\" investor type"
                }
                in 38..44 -> {
                    investorType.text = "Your are \"Growth\" investor type"
                }
                in 45..50 -> {
                    investorType.text = "Your are \"Aggressive Growth\" investor type"
                }
            }
        }


    }

}