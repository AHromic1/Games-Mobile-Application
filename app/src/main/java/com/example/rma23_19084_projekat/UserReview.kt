package com.example.rma23_19084_projekat

data class UserReview(
    override val username: String, //ne da override
    override val timestamp: Long,
    val review: String
):UserImpression()  //trazi konstruktor da se popuni!
//klasu sam popravila u skladu s odgovorima na Piazzi, isto vrijedi i za UserRating te UserImpression