package com.nabilbdev.recipes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * [Recipe] is a data class to represent the Recipe name, image, description, duration & calories
 */
data class Recipe(
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int,
    @StringRes val duration: Int,
    @StringRes val calories: Int
)