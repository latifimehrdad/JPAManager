package com.hoomanholding.jpamanager.view.fragment.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hoomanholding.jpamanager.JpaFragment
import com.hoomanholding.jpamanager.R
import com.hoomanholding.jpamanager.databinding.FragmentSplashBinding
import com.hoomanholding.jpamanager.view.activity.MainActivity
import com.zar.core.enums.EnumApiError
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by m-latifi on 11/8/2022.
 */


@AndroidEntryPoint
class SplashFragment(override var layout: Int = R.layout.fragment_splash) :
    JpaFragment<FragmentSplashBinding>() {

    private val splashViewModel: SplashViewModel by viewModels()

    //---------------------------------------------------------------------------------------------- onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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



    //---------------------------------------------------------------------------------------------- setListener
    private fun setListener() {
        binding.materialButtonLogin.setOnClickListener {
            checkUserIsLogged()
        }

        binding.imageViewManegerApp.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_HomeFragment)
        }
    }
    //---------------------------------------------------------------------------------------------- setListener


    //---------------------------------------------------------------------------------------------- checkUserIsLogged
    private fun checkUserIsLogged() {
        if (splashViewModel.userIsEntered())
            gotoFragmentHome()
        else
            gotoFragmentLogin()
    }
    //---------------------------------------------------------------------------------------------- checkUserIsLogged


    //---------------------------------------------------------------------------------------------- gotoFragmentLogin
    private fun gotoFragmentLogin() {
        findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
    }
    //---------------------------------------------------------------------------------------------- gotoFragmentLogin


    //---------------------------------------------------------------------------------------------- gotoFragmentHome
    private fun gotoFragmentHome() {
        observeLiveDate()
        splashViewModel.requestGetData()
    }
    //---------------------------------------------------------------------------------------------- gotoFragmentHome


    //---------------------------------------------------------------------------------------------- observeLiveDate
    private fun observeLiveDate() {
        splashViewModel.errorLiveDate.observe(viewLifecycleOwner) {
            showMessage(it.message)
            when (it.type) {
                EnumApiError.UnAuthorization -> (activity as MainActivity?)?.gotoFirstFragment()
                else -> {}
            }
        }

        splashViewModel.successLiveData.observe(viewLifecycleOwner) {
            if (it)
                findNavController().navigate(R.id.action_splashFragment_to_HomeFragment)
        }
    }
    //---------------------------------------------------------------------------------------------- observeLiveDate


}