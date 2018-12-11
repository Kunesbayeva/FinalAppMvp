package com.example.diana.finalapplication


import android.annotation.SuppressLint
import com.example.diana.finalapplication.core.api.errorHandler.RetrofitException
import com.example.diana.finalapplication.contactmodel.list.NewsListContract
import com.example.diana.finalapplication..core.util.BasePresenter
import com.example.diana.finalapplication..core.util.Logger
import com.example.diana.finalapplication.entity.Contact


class AddPresenter(private val repository: NewsListContract.Repository)
    : BasePresenter<NewsAddContract.View>(),
        NewsAddContract.Presenter{

    override fun viewIsReady() { }

    override fun destroy() {
        detachView()
    }

    @SuppressLint("CheckResult")
    override fun addContact(name: String, mobile: String, home: String, work : String) {
        if (validate (name, mobile, home, work)) {
            val cont = Contact (0, name, mobile, work, home)
            repository.addNews(cont).subscribe ({
                getView()?.onSuccess(cont)
            }, { it as RetrofitException
                Logger.msg("getNews error: ${it.getErrorBody()?.message}")
            })
        }
        else getView()?.onError()
    }

    private fun validate(name: String, mobile: String, home: String, work: String)Boolean {
        if (name.isEmpty()) {
            getView()?.showMessage("Name is empty")
            return false
        }
        if (mobile.isEmpty()) {
            getView()?.showMessage("Mobile is empty")
            return false
        }
        if (home.isEmpty()) {
            getView()?.showMessage("Home number is empty")
            return false
        }
        if (work.isEmpty()) {
            getView()?.showMessage("Work number is empty")
            return false
        }
        return true
    }
}