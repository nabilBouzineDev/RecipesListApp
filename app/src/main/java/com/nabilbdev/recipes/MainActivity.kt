@file:OptIn(ExperimentalMaterial3Api::class)

package com.nabilbdev.recipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import com.nabilbdev.recipes.data.Recipe
import com.nabilbdev.recipes.data.loadRecipes
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
    Scaffold(
        topBar = {
            RecipeTopAppBar()
        },
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
    ) {
        LazyColumn(contentPadding = it) {
            items(loadRecipes) { recipe ->
                RecipeCard(recipe = recipe)
            }
        }
    }
}

@Composable
fun RecipeTopAppBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.recipe_app_name),
                style = MaterialTheme.typography.titleLarge
            )
        },
        modifier = modifier
            .fillMaxWidth()
    )
}

@Composable
fun RecipeCard(
    recipe: Recipe,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue =
        if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.secondaryContainer,
        label = ""
    )

    Card(
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .wrapContentSize()
            .clickable { expanded = !expanded }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .align(Alignment.CenterHorizontally)
        ) {
            RecipeIcon(
                recipe = recipe,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.padding_medium)))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                RecipeTitleAndDescription(
                    recipe = recipe,
                    expanded = expanded
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
                RecipeTags(recipe = recipe)
            }
        }
    }
}

@Composable
fun RecipeTitleAndDescription(
    recipe: Recipe,
    expanded: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = recipe.title),
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        Row {
            if (!expanded) {
                Text(
                    text = stringResource(id = recipe.description),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge
                )
            } else {
                Text(
                    text = stringResource(id = recipe.description),
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun RecipeTags(
    recipe: Recipe,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(top = dimensionResource(id = R.dimen.padding_small))
            .fillMaxWidth()
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = duration_bg.copy(alpha = 0.35f)
            ),
            modifier = Modifier
        ) {
            Text(
                text = stringResource(id = recipe.duration),
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
        ) {
            Text(
                text = stringResource(id = recipe.calories),
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
    recipe: Recipe,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = recipe.image),
        contentScale = ContentScale.Fit,
        contentDescription = stringResource(id = recipe.title),
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