package com.jocmp.basilreader.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jocmp.basil.AccountManager
import com.jocmp.basilreader.ui.accounts.accountIndex
import com.jocmp.basilreader.ui.accounts.navigateToAddAccount
import com.jocmp.basilreader.ui.articles.articleGraph
import com.jocmp.basilreader.ui.articles.navigateToArticles
import com.jocmp.basilreader.ui.theme.BasilReaderTheme
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun App(startDestination: String) {
    val navController = rememberNavController()

    BasilReaderTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavHost(
                navController = navController,
                startDestination = startDestination
            ) {
                accountIndex(
                    onSelect = {
                        navController.navigateToArticles()
                    }
                )
                articleGraph(navController = navController)
            }
        }
    }
}
