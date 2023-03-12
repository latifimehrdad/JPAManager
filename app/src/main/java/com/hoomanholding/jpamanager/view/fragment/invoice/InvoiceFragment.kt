package com.hoomanholding.jpamanager.view.fragment.invoice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.hoomanholding.jpamanager.JpaFragment
import com.hoomanholding.jpamanager.R
import com.hoomanholding.jpamanager.databinding.FragmentInvoiceBinding
import com.hoomanholding.jpamanager.view.activity.MainActivity
import dagger.hilt.android.AndroidEntryPoint


/**
 * create by m-latifi on 3/12/2023
 */

@AndroidEntryPoint
class InvoiceFragment(override var layout: Int = R.layout.fragment_invoice) :
    JpaFragment<FragmentInvoiceBinding>() {

    private val viewModel: InvoiceViewModel by viewModels()

    //---------------------------------------------------------------------------------------------- onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        setListener()
    }
    //---------------------------------------------------------------------------------------------- onViewCreated



    //---------------------------------------------------------------------------------------------- showMessage
    private fun showMessage(message: String) {
        activity?.let {
            (it as MainActivity).showMessage(message)
        }
    }
    //---------------------------------------------------------------------------------------------- showMessage



    //---------------------------------------------------------------------------------------------- observeLiveData
    private fun observeLiveData() {
        viewModel.errorLiveDate.observe(viewLifecycleOwner) {
            showMessage(it.message)
        }
    }
    //---------------------------------------------------------------------------------------------- observeLiveData




    //---------------------------------------------------------------------------------------------- setListener
    private fun setListener() {

    }


}