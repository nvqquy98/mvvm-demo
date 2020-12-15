package com.odinwar.mvvmdemoapp.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.odinwar.mvvmdemoapp.data.model.MovieItem
import com.odinwar.mvvmdemoapp.data.model.TypeTrending
import com.odinwar.mvvmdemoapp.data.source.repository.MovieRepository
import com.odinwar.mvvmdemoapp.utils.Constant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel : ViewModel() {

    private val repository by lazy { MovieRepository.newInstance() }
    private var totalPage = Constant.DEFAULT_PAGE
    private var pageCurrent = Constant.DEFAULT_PAGE

    private val _dataMovie by lazy {
        MutableLiveData<List<MovieItem>>().apply {
            value = listOf()
        }
    }
    val dataMovie: LiveData<List<MovieItem>> = _dataMovie

    private val _loadError by lazy {
        MutableLiveData<Exception>()
    }
    val loadError: LiveData<Exception> = _loadError

    fun loadData(page: Int = Constant.DEFAULT_PAGE) {
        repository.getMovieTrending(TypeTrending.POPULAR, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data ->
                    data.apply {
                        totalPages?.let { this@HomeViewModel.totalPage = it }
                        pageCurrent?.let { this@HomeViewModel.pageCurrent = it }
                        _dataMovie.value = data.data
                    }
                }, { error ->
                    _loadError.value = error as Exception?
                }
            )
    }
}
