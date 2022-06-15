package com.fintonic.beers.model.data.entities

data class Beer(
    val abv: Double,
    val attenuationLevel: Double,
    val boilVolume: String,
    val brewersTips: String,
    val contributedBy: String,
    val description: String,
    val ebc: Int?,
    val firstBrewed: String,
    val foodPairing: List<String>,
    val ibu: Double?,
    val id: Int,
    val imageUrl: String,
    val ingredients: Ingredients,
    val method: Method,
    val name: String,
    val ph: Double?,
    val srm: Double?,
    val tagLine: String,
    val targetFg: Double,
    val targetOg: Double,
    val volume: String
)

data class Ingredients(
    val hops: List<Hop>,
    val malt: List<Malt>,
    val yeast: String
)

data class Hop(
    val add: String,
    val amount: String,
    val attribute: String,
    val name: String
)

data class Malt(
    val amount: String,
    val name: String
)

data class Method(
    val fermentation: Fermentation,
    val mashTemp: List<MashTemp>,
    val twist: String?
)

data class Fermentation(
    val temp: String
)

data class MashTemp(
    val duration: Double?,
    val temp: String
)
