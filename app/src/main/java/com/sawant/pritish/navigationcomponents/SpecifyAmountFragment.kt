package com.sawant.pritish.navigationcomponents


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal


class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    var navController: NavController? = null
    var receipent: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        receipent = arguments?.getString("receipent")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        send_btn.setOnClickListener(this)
        cancel_btn.setOnClickListener(this)
        recipient.text = "Sending money to $receipent"
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.send_btn -> {
                if(!TextUtils.isEmpty(input_amount.text.toString())){
                    val amount = Money(BigDecimal(input_amount.text.toString()))
                    val bundle = bundleOf("receipent" to receipent,
                        "amount" to amount)
                    navController?.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment,
                        bundle)
                }

            }
            R.id.cancel_btn -> {
               activity?.onBackPressed()
            }
        }
    }
}

/*


























































 */