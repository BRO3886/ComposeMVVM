package com.sidv.recipeapp.network.responses

import com.google.gson.annotations.SerializedName
import com.sidv.recipeapp.network.model.RecipeDto

class RecipeSearchResponse(
    @SerializedName("count")
    var count: Int,
    @SerializedName("results")
    var results: List<RecipeDto>
)