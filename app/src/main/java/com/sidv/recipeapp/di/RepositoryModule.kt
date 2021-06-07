package com.sidv.recipeapp.di

import com.sidv.recipeapp.network.RecipeService
import com.sidv.recipeapp.network.model.RecipeDtoMapper
import com.sidv.recipeapp.repository.RecipeRepository
import com.sidv.recipeapp.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRecipeRepo(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {
        return RecipeRepositoryImpl(recipeService, recipeDtoMapper)
    }
}