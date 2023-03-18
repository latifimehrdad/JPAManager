package com.hoomanholding.jpamanager.view.fragment.invoice

import androidx.lifecycle.MutableLiveData
import com.hoomanholding.jpamanager.JpaViewModel
import com.hoomanholding.jpamanager.R
import com.hoomanholding.jpamanager.model.data.request.OrderRequestModel
import com.hoomanholding.jpamanager.model.data.response.order.OrderModel
import com.hoomanholding.jpamanager.model.repository.OrderRepository
import com.hoomanholding.jpawarehose.di.ResourcesProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * create by m-latifi on 3/12/2023
 */

@HiltViewModel
class InvoiceViewModel @Inject constructor(
    private val orderRepository: OrderRepository,
    private val resourcesProvider: ResourcesProvider
) : JpaViewModel() {

    val orderLiveData: MutableLiveData<List<OrderModel>> by lazy {
        MutableLiveData<List<OrderModel>>()
    }



    //---------------------------------------------------------------------------------------------- requestGetOrder
    fun requestGetOrder() {
        job = CoroutineScope(IO + exceptionHandler()).launch {
            val request = OrderRequestModel(
                "14011001", "14011230", 0, 0
            )
            val response = orderRepository.requestGetOrder(request)
            if (response?.isSuccessful == true){
                val body = response.body()
                body?.let {
                    if (!it.hasError)
                        orderLiveData.postValue(it.data)
                    else
                        setMessage(it.message)
                } ?: run {
                    setMessage(resourcesProvider.getString(R.string.dataReceivedIsEmpty))
                }
            } else
                setMessage(response)
        }
    }
    //---------------------------------------------------------------------------------------------- requestGetOrder


}