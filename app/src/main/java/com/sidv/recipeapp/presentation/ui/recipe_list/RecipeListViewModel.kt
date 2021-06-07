package com.sidv.recipeapp.presentation.ui.recipe_list

import androidx.lifecycle.ViewModel
import com.sidv.recipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val randomString: String,
    private val repository: RecipeRepository,
    @Named("auth_token") private val authToken: String
) : ViewModel() {
    init {
        println("viewmodel: $randomString")
    }
}
