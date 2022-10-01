package com.therealbluepandabear.alternotube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.therealbluepandabear.alternotube.models.RumbleScraper
import com.therealbluepandabear.alternotube.models.RumbleSearchResult
import com.therealbluepandabear.alternotube.ui.theme.AlternoTubeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlternoTubeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainComposable()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RumbleSearchResult(rumbleSearchResult: RumbleSearchResult, onClick: () -> Unit) {
    ListItem(
        headlineText = {
            rumbleSearchResult.title?.let { title ->
                Text(title)
            }
        },

        supportingText = {
            rumbleSearchResult.channel.let { creator ->
                val text = when {
                    rumbleSearchResult.views > 0 -> {
                        "${creator.name}, ${rumbleSearchResult.views} views"
                    }

                    else -> {
                        creator.name ?: ""
                    }
                }

                Row {
                    Text(text)

                    if (creator.isVerified) {
                        Icon(
                            painter = painterResource(R.drawable.ic_baseline_verified_24),
                            tint = Color.Cyan,
                            contentDescription = stringResource(id = R.string.mainActivity_verified_content_description)
                        )
                    }
                }
            }
        },

        leadingContent = {
            AsyncImage(
                rumbleSearchResult.thumbnailSrc,
                contentDescription = null,
                modifier = Modifier.size(100.dp, 100.dp)
            )
        },

        modifier = Modifier.clickable {
            onClick.invoke()
        }
    )
    Divider()
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MainComposable() {
    val viewModel: MainActivityViewModel = viewModel()
    val keyboardController = LocalSoftwareKeyboardController.current

    var openDialog by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.wrapContentSize()
        ) {
            OutlinedTextField(
                value = viewModel.searchQuery,
                onValueChange = { viewModel.searchQuery = it },
                label = {
                    Text(
                        stringResource(id = R.string.mainActivity_search)
                    )
                }
            )

            Button(
                onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        viewModel.searchResults = RumbleScraper.create().scrapeSearchResultsFromQuery(viewModel.searchQuery)
                    }
                    keyboardController?.hide()
                },
            ) {
                Text(
                    stringResource(id = R.string.mainActivity_search)
                )
            }
        }

        LazyColumn {
            items(viewModel.searchResults) {
                RumbleSearchResult(rumbleSearchResult = it) {
                    openDialog = true
                    viewModel.currentRumbleSearchResult = it
                }
            }
        }
    }

    if (openDialog) {
        AlertDialog(
            onDismissRequest = {
                openDialog = false
            },
            title = {
                Column {
                    Text(
                        text = viewModel.currentRumbleSearchResult?.title ?: ""
                    )
                    Spacer(
                        Modifier.height(8.dp)
                    )
                    Text(
                        text = "By ${viewModel.currentRumbleSearchResult?.channel?.name ?: ""}",
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            },
            text = {

            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog = false
                    }
                ) {
                    Text("Exit")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AlternoTubeTheme {
        MainComposable()
    }
}