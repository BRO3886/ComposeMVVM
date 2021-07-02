package com.sidv.recipeapp.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sidv.recipeapp.domain.model.Recipe
import com.sidv.recipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val randomString: String,
    private val repository: RecipeRepository,
    @Named("auth_token") private val authToken: String
) : ViewModel() {
    val recipes: MutableState<List<Recipe>> = mutableStateOf(listOf())

    val query = mutableStateOf("")

    val isLoading = mutableStateOf(false)

    init {
        newSearch("chicken")

    }

    fun newSearch(item: String) {
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.search(
                token = authToken,
                page = 1,
                query = item,
            )
            recipes.value = result
            isLoading.value = false
        }
    }

    fun updateQuery(value: String) {
        query.value = value
    }
}
