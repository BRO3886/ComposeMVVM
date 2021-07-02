package com.sidv.recipeapp.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sidv.recipeapp.presentation.components.CircularLoadingIndicator
import com.sidv.recipeapp.presentation.components.RecipeCard
import dagger.hilt.android.AndroidEntryPoint

//or Fragment(R.layout.fragment_recipe_list)
@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {

                val recipes = viewModel.recipes.value
                val textValue = viewModel.query.value
                val focusManager = LocalFocusManager.current


                Column() {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row {
                            TextField(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(8.dp),
                                value = textValue,
                                onValueChange = {
                                    viewModel.updateQuery(it)
                                },
                                label = {
                                    Text(text = "Search")
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text,
                                    imeAction = ImeAction.Search,
                                ),
                                leadingIcon = {
                                    Icon(Icons.Filled.Search, "Search")
                                },
                                keyboardActions = KeyboardActions(onSearch = {
                                    viewModel.newSearch(textValue)
                                    focusManager.clearFocus()
                                }),
                                backgroundColor = MaterialTheme.colors.surface,
                            )
                        }
                    }
                    CircularLoadingIndicator(isLoading = viewModel.isLoading.value)
                    LazyColumn {
                        itemsIndexed(
                            items = recipes
                        ) { index, recipe ->
                            RecipeCard(
                                recipe = recipe,
                                onClick = {},
                            )
                        }
                    }

                }

            }
        }

    }
}