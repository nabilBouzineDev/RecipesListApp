@file:OptIn(ExperimentalMaterial3Api::class)

package com.nabilbdev.recipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.nabilbdev.recipes.ui.theme.RecipesTheme
import com.nabilbdev.recipes.ui.theme.calories_bg
import com.nabilbdev.recipes.ui.theme.duration_bg

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecipesApp()
                }
            }
        }
    }
}

@Composable
fun RecipesApp() {

    var expanded by remember { mutableStateOf(false) }

    RecipeCard(
        recipeName = R.string.recipe_title_01,
        recipeDescription = R.string.recipe_description_02,
        durationInMin = R.string.recipe_duration_01,
        calories = R.string.recipe_kcal_01,
        recipeIcon = R.drawable.recipe_image_01,
        expanded = expanded,
        onClick = { expanded = !expanded }
    )
}

@Composable
fun RecipeCard(
    @StringRes recipeName: Int,
    @StringRes recipeDescription: Int,
    @StringRes durationInMin: Int,
    @StringRes calories: Int,
    @DrawableRes recipeIcon: Int,
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .wrapContentSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .align(Alignment.CenterHorizontally)
        ) {
            RecipeIcon(
                recipeIcon = recipeIcon,
                recipeName = recipeDescription,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.padding_medium)))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                RecipeTitleAndDescription(
                    recipeName = recipeName,
                    recipeDescription = recipeDescription,
                    expanded = expanded
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
                RecipeTags(durationInMin = durationInMin, calories = calories)
            }
        }
    }
}

@Composable
fun RecipeTitleAndDescription(
    @StringRes recipeName: Int,
    @StringRes recipeDescription: Int,
    expanded: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = recipeName),
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        Row {
            if (!expanded) {
                Text(
                    text = stringResource(id = recipeDescription),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge
                )
            } else {
                Text(
                    text = stringResource(id = recipeDescription),
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun RecipeTags(
    @StringRes durationInMin: Int,
    @StringRes calories: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = duration_bg.copy(alpha = 0.35f)
            ),
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
        ) {
            Text(
                text = stringResource(id = durationInMin),
                color = duration_bg,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
        Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.padding_medium)))
        Card(
            colors = CardDefaults.cardColors(
                containerColor = calories_bg.copy(0.35f)
            ),
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
        ) {
            Text(
                text = stringResource(id = calories),
                color = calories_bg,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun RecipeIcon(
    @DrawableRes recipeIcon: Int,
    @StringRes recipeName: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = recipeIcon),
        contentScale = ContentScale.Fit,
        contentDescription = stringResource(id = recipeName),
        modifier = modifier
            .size(dimensionResource(id = R.dimen.image_size))
            .clip(CircleShape)
            .border(
                width = dimensionResource(id = R.dimen.padding_small),
                color = Color.White,
                shape = CircleShape
            )
    )
}

@Preview(showSystemUi = true)
@Composable
fun RecipesAppPreview() {
    RecipesTheme {
        RecipesApp()
    }
}