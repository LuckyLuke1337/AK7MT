package com.example.pocketpharma

import android.icu.text.AlphabeticIndex
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import androidx.recyclerview.widget.RecyclerView

class recordViewModel(private val repository: recordRepository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allRecords: LiveData<List<Record>> = repository.allRecords.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(record: Record) = viewModelScope.launch {
        repository.insert(record)
    }
}

class recordViewModelFactory(private val repository: recordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(recordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return recordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}