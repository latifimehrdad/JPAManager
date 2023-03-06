package com.hoomanholding.jpamanager.view.fragment.report

import android.os.Bundle
import android.view.View
import com.hoomanholding.jpamanager.JpaFragment
import com.hoomanholding.jpamanager.R
import com.hoomanholding.jpamanager.databinding.FragmentReportBinding
import com.hoomanholding.jpamanager.view.activity.MainActivity


/**
 * create by m-latifi on 3/6/2023
 */
class ReportFragment(override var layout: Int = R.layout.fragment_report):
    JpaFragment<FragmentReportBinding>(){

    //---------------------------------------------------------------------------------------------- onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    //---------------------------------------------------------------------------------------------- onViewCreated



    //---------------------------------------------------------------------------------------------- showMessage
    private fun showMessage(message: String) {
        activity?.let {
            (it as MainActivity).showMessage(message)
        }
    }
    //---------------------------------------------------------------------------------------------- showMessage


}