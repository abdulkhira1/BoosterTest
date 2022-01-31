package com.booster.test.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.booster.test.MainActivity
import com.booster.test.R
import com.booster.test.model.Question
import com.booster.test.utils.Constants
import kotlinx.android.synthetic.main.fragment_investor_type.*
import kotlinx.android.synthetic.main.fragment_quiz_questions.*

class QuizQuestionsFragment : Fragment(R.layout.fragment_quiz_questions), View.OnClickListener {

    lateinit var mainActivity: MainActivity
    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var score = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        mQuestionList = Constants.getQuestions()
        setQuestion()

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        tvOptionFive.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {

        val question = mQuestionList!![mCurrentPosition - 1]

        defaultOptionsView()
        if (mCurrentPosition == mQuestionList!!.size) {
            btnSubmit.text = "Finish"
        } else {
            btnSubmit.text = "Submit"
        }

        progressBar.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition" + "/" + progressBar.max

        tvQuestion.text = question.question
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour
        tvOptionFive.text = question.optionFive
    }

    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, tvOptionOne)
        options.add(1, tvOptionTwo)
        options.add(2, tvOptionThree)
        options.add(3, tvOptionFour)
        options.add(4, tvOptionFive)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                mainActivity,
                R.drawable.default_option_border_bg
            )
        }

    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvOptionOne -> {
                selectedOptionView(tvOptionOne, 1)
            }
            R.id.tvOptionTwo -> {
                selectedOptionView(tvOptionTwo, 2)
            }
            R.id.tvOptionThree -> {
                selectedOptionView(tvOptionThree, 3)
            }
            R.id.tvOptionFour -> {
                selectedOptionView(tvOptionFour, 4)
            }
            R.id.tvOptionFive -> {
                selectedOptionView(tvOptionFive, 5)
            }
            R.id.btnSubmit -> {

                val question = mQuestionList?.get(mCurrentPosition - 1)
                when (mSelectedOptionPosition) {
                    1 -> {
                        score += question?.scoreOne!!
                    }
                    2 -> {
                        score += question?.scoreTwo!!
                    }
                    3 -> {
                        score += question?.scoreThree!!
                    }
                    4 -> {
                        score += question?.scoreFour!!
                    }
                    5 -> {
                        score += question?.scoreFive!!
                    }
                }
                mSelectedOptionPosition = 0
                mCurrentPosition++

                when {
                    mCurrentPosition <= mQuestionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        Toast.makeText(
                            mainActivity,
                            "You have successfully completed the Quiz",
                            Toast.LENGTH_SHORT
                        ).show()
                        val bundle = Bundle()
                        bundle.putString(
                            Constants.INVESTOR_TYPE,
                            arguments?.getString(Constants.INVESTOR_TYPE)
                        )
                        bundle.putString(Constants.SCORE, score.toString())
                        Constants.navigateFragment(
                            findNavController(),
                            R.id.navigation_score,
                            bundle
                        )
                        mCurrentPosition = 1
                    }
                }

                if (mCurrentPosition == mQuestionList!!.size) {
                    btnSubmit.text = "Finish"
                }

            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            mainActivity,
            R.drawable.selected_option_border_bg
        )
    }

}