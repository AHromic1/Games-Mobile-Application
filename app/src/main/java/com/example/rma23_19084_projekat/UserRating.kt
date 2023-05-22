package com.example.rma23_19084_projekat


/*data automatski ima settere gettere i sl, ne moraju se definisati*/
data class UserRating(
    override val username: String,
    override val timestamp: Long, //cannot be overwritten jer je timestamp final - dodala da je open
    val rating: Double
):UserImpression()