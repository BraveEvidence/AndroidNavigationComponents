package com.sawant.pritish.navigationcomponents

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_confirmation.*


class ConfirmationFragment : Fragment() {

// amount
    private var receipient: String?=null
    private var money: Money?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        receipient = arguments?.getString("receipent")
        money = arguments?.getParcelable("amount")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        confirmation_message.text = "You have sent ${money?.amount} to $receipient"
    }


}


/*


























































 */