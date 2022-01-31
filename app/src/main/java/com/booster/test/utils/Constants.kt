package com.booster.test.utils

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.booster.test.R
import com.booster.test.model.Question
import java.util.regex.Pattern

object Constants {

    const val INVESTOR_TYPE = "investor_type"
    const val SCORE = "score"

    @JvmStatic
    fun navigateFragment(findNavController: NavController, id: Int) {
        navigateFragment(findNavController, id, null)
    }


    @JvmStatic
    fun navigateFragment(findNavController: NavController, id: Int, bundle: Bundle?) {
        val navBuilder = NavOptions.Builder()
        navBuilder.setEnterAnim(R.anim.enter).setExitAnim(R.anim.exit).setPopEnterAnim(R.anim.pop_enter).setPopExitAnim(R.anim.pop_exit)
        findNavController.navigate(id, bundle, navBuilder.build())
    }

    @JvmStatic
    fun checkEmail(email: String): Boolean {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }

    private val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val question1 = Question(
            1,
            "When do you plan to make a signiicant lump sum withdrawal from your portfolio, for example, for the purchase of a irst home or for retirement needs? (From age 65 at the earliest)",
            "Within 2 years",
            "In 2 to 5 years",
            "In 6 to 10 years",
            "In 11 to 20 years",
            "More than 20 years",
            1,3,5,7,10
        )
        val question2 = Question(
            2,
            "Which of the following questions best describes your thoughts about risks and returns?",
            "I want to minimise my risk and am therefore willing to accept low returns",
            "I am willing to take a moderate amount of risk to generate low to medium returns",
            "I am willing to take a reasonable amount of risk to provide a more medium return",
            "In order to receive higher returns, I am willing to take a relatively high amount of risk",
            "I want to maximise my returns and am willing to accept a high level of risk",
            1,3,5,7,10
        )
        val question3 = Question(
            3,
            "Protecting my investment portfolio from a fall in value at any time is more important to me than achieving high returns?",
            "Strongly Agree",
            "Agree",
            "Neither agree or disagree",
            "Disagree",
            "Strongly Disagree",
            1,3,5,7,10
        )
        val question4 = Question(
            4,
            "Consider you have an investment balance of at least \$20,000 or more. If after a short period of time (less than 1 year) your balance has dropped in value, which statement relects best how you would feel about this?",
            "I would be unhappy with any drop in value",
            "I would be OK with a drop in value of no more than 5%",
            "I would be OK with a drop in value of no more than 10%",
            "I would be OK with a drop in value of up to 15% ",
            "I would be OK with a drop in value of up to 20%",
            1,3,5,7,10
        )
        val question5 = Question(
            5,
            "How often would you tend to worry about your investment returns?",
            "Daily",
            "Monthly",
            "Quarterly",
            "Annually",
            "Never or only occasionally over the longer term",
            1,3,5,7,10
        )
        questionsList.add(question1)
        questionsList.add(question2)
        questionsList.add(question3)
        questionsList.add(question4)
        questionsList.add(question5)


        return questionsList
    }

}