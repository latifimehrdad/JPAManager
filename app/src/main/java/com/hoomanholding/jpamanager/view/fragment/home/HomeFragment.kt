package com.hoomanholding.jpamanager.view.fragment.home

import android.os.Bundle
import android.view.View
import com.hoomanholding.jpamanager.JpaFragment
import com.hoomanholding.jpamanager.R
import com.hoomanholding.jpamanager.databinding.FragmentHomeBinding
import com.hoomanholding.jpamanager.view.activity.MainActivity


/**
 * create by m-latifi on 3/6/2023
 */
class HomeFragment(override var layout: Int = R.layout.fragment_home):
    JpaFragment<FragmentHomeBinding>(){

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