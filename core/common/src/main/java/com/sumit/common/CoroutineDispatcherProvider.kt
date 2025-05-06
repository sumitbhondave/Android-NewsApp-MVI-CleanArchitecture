package com.sumit.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CoroutineDispatcherProvider {

    fun main(): CoroutineDispatcher = Dispatchers.Main

    fun default(): CoroutineDispatcher = Dispatchers.Default

    fun io(): CoroutineDispatcher = Dispatchers.IO
}