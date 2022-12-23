package com.anjad.myphotoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.anjad.myphotoapp.ui.DetailsScreen
import com.anjad.myphotoapp.ui.MainScreen
import com.anjad.myphotoapp.ui.theme.MyPhotoAppTheme
import com.anjad.myphotoapp.utils.generateMockImageList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPhotoAppTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = NavRoutes.MainScreen.route,
                    ) {

                        composable(NavRoutes.MainScreen.route) {
                            MainScreen(
                                modifier = Modifier,
                                imageList = generateMockImageList(),
                                onImageClick = { imageClicked ->
                                    navController.navigate(NavRoutes.DetailsScreen.withArgs(imageClicked.title))
                                },
                            )
                        }

                        composable(
                            route = NavRoutes.DetailsScreen.route + "/{imageTitle}",
                            arguments = listOf(
                                navArgument("imageTitle") {
                                    type = NavType.StringType
                                    nullable = true
                                }
                            )
                        ) { entry ->
                            DetailsScreen(imageTitle = entry.arguments?.getString("imageTitle"))
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPhotoAppPreview() {
    MyPhotoAppTheme {
        MainScreen(modifier = Modifier, imageList = generateMockImageList(), onImageClick = {})
    }
}