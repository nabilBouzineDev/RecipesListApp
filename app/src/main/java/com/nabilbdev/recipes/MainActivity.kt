package com.nabilbdev.recipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nabilbdev.recipes.ui.theme.RecipesTheme

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

                }
            }
        }
    }
}

@Composable
fun RecipesApp() {
}

@Composable
fun RecipeCard(modifier: Modifier = Modifier) {

}

@Composable
fun RecipeTitleAndDescription(modifier: Modifier = Modifier) {

}

@Composable
fun RecipeButton(modifier: Modifier = Modifier) {

}

@Composable
fun RecipeIcon(modifier: Modifier = Modifier) {

}

@Preview(showSystemUi = true)
@Composable
fun RecipesAppPreview() {
    RecipesTheme {
        RecipesApp()
    }
}