package com.example.diana.finalapplication

class ContactModel {

        var name: String? = null
        var mobile: String? = null
        var home: String? = null
        var work: String? = null


        fun setNames(name: String) {
            this.name = name
        }

        fun getNumbers(): String {
            return mobile.toString()
        }

        fun setNumbers(number: String) {
            this.mobile = number
        }

        fun getNames(): String {
            return mobile.toString()
        }

    fun getHomeNumber(): String {
        return home.toString()
    }

    fun setHomeNumber(number: String) {
        this.home = number
    }

    fun getWorkNumber(): String {
        return work.toString()
    }

    fun setWorkNumber(number: String) {
        this.work = number
    }

    }