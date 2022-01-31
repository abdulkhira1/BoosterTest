package com.booster.test.ui.fragment

import android.content.ActivityNotFoundException
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.booster.test.MainActivity
import com.booster.test.R
import com.booster.test.utils.Constants
import kotlinx.android.synthetic.main.fragment_score.*
import kotlinx.android.synthetic.main.fragment_score.btnSubmit
import kotlinx.android.synthetic.main.fragment_sign_up.*
import java.lang.Exception
import android.widget.Toast

import android.content.Intent




class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

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

        val type = arguments?.getString(Constants.INVESTOR_TYPE)
        val score = arguments?.getString(Constants.SCORE)

        editName.doOnTextChanged { _, _, _, _ ->
            if (name_layout.isErrorEnabled) {
                name_layout.isErrorEnabled = false
            }
        }

        editNumber.doOnTextChanged { _, _, _, _ ->
            if (number_layout.isErrorEnabled) {
                number_layout.isErrorEnabled = false
            }
        }

        editEmail.doOnTextChanged { _, _, _, _ ->
            if (email_layout.isErrorEnabled) {
                email_layout.isErrorEnabled = false
            }
        }

        btnSubmit.setOnClickListener {
            val name = editName.text.toString().trim()
            val email = editEmail.text.toString().trim()
            val number = editNumber.text.toString().trim()

            if (name.isEmpty()){
                name_layout.error = "Enter your name"
            } else if (number.isEmpty() || number.length < 10 || number.length > 10){
                number_layout.error = "Enter valid number"
            } else if (email.isEmpty() || !Constants.checkEmail(editEmail.text.toString())) {
                email_layout.error = "Enter valid email id"
            } else {
                val data = "Name : $name \nMobile Number: $number \nEmail Address: $email \nScore: $score \nInvestor Type: $type"
                val i = Intent(Intent.ACTION_SEND)
                i.type = "message/rfc822"
                i.putExtra(Intent.EXTRA_EMAIL, arrayOf("me@example.com"))
                i.putExtra(Intent.EXTRA_SUBJECT, "Investor Score")
                i.putExtra(Intent.EXTRA_TEXT, data)
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."))
                } catch (ex: ActivityNotFoundException) {
                    Toast.makeText(
                        mainActivity,
                        "There are no email clients installed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }

    }

}