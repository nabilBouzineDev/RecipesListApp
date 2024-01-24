package com.nabilbdev.recipes.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.nabilbdev.recipes.R

data class Recipe(
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int,
    @StringRes val duration: Int,
    @StringRes val calories: Int
)

val loadRecipes = listOf(
    Recipe(
        R.string.recipe_title_01,
        R.drawable.recipe_image_01,
        R.string.recipe_description_01,
        R.string.recipe_duration_01,
        R.string.recipe_kcal_01
    ),
    Recipe(
        R.string.recipe_title_02,
        R.drawable.recipe_image_02,
        R.string.recipe_description_02,
        R.string.recipe_duration_02,
        R.string.recipe_kcal_02
    ),
    Recipe(
        R.string.recipe_title_03,
        R.drawable.recipe_image_03,
        R.string.recipe_description_03,
        R.string.recipe_duration_03,
        R.string.recipe_kcal_03
    ),
    Recipe(
        R.string.recipe_title_04,
        R.drawable.recipe_image_04,
        R.string.recipe_description_04,
        R.string.recipe_duration_04,
        R.string.recipe_kcal_04
    ),
    Recipe(
        R.string.recipe_title_05,
        R.drawable.recipe_image_05,
        R.string.recipe_description_05,
        R.string.recipe_duration_05,
        R.string.recipe_kcal_05
    ),
    Recipe(
        R.string.recipe_title_06,
        R.drawable.recipe_image_06,
        R.string.recipe_description_06,
        R.string.recipe_duration_06,
        R.string.recipe_kcal_06
    )
)