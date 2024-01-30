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
    ),
    Recipe(
        R.string.recipe_title_07,
        R.drawable.recipe_image_07,
        R.string.recipe_description_07,
        R.string.recipe_duration_07,
        R.string.recipe_kcal_07
    ),
    Recipe(
        R.string.recipe_title_08,
        R.drawable.recipe_image_08,
        R.string.recipe_description_08,
        R.string.recipe_duration_08,
        R.string.recipe_kcal_08
    ),
    Recipe(
        R.string.recipe_title_09,
        R.drawable.recipe_image_09,
        R.string.recipe_description_09,
        R.string.recipe_duration_09,
        R.string.recipe_kcal_09
    ),
    Recipe(
        R.string.recipe_title_10,
        R.drawable.recipe_image_10,
        R.string.recipe_description_10,
        R.string.recipe_duration_10,
        R.string.recipe_kcal_10
    )

    /** I supposed to add 30 meals here.
     * However, since I accomplish the required UI and logic, there's no need to add more...
     */
)