package com.example.covid_19tracker

data class Country(
        val Country: String,
        val TotalConfirmed:Int,
        val NewConfirmed:Int,
        val TotalDeaths: Int,
        val TotalRecovered:Int
)
