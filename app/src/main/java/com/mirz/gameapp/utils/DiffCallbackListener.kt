package com.mirz.gameapp.utils

interface DiffCallbackListener<T> {
    fun areItemsTheSame(oldItem: T, newItem: T): Boolean
}