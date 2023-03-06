package com.hoomanholding.jpamanager.view.fragment.profile

import android.os.Bundle
import android.view.View
import com.hoomanholding.jpamanager.JpaFragment
import com.hoomanholding.jpamanager.R
import com.hoomanholding.jpamanager.databinding.FragmentProfileBinding
import com.hoomanholding.jpamanager.view.activity.MainActivity


/**
 * create by m-latifi on 3/6/2023
 */
class ProfileFragment(override var layout: Int = R.layout.fragment_profile):
    JpaFragment<FragmentProfileBinding>(){

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