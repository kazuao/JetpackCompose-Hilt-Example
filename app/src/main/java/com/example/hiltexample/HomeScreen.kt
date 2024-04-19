package com.example.hiltexample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hiltexample.viewModel.HomeScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    vm: HomeScreenViewModel = hiltViewModel()
) {
    val users by vm.users.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Users") })
        },
    ) { p ->
        Column {
            users.forEach { user ->
                ClickableText(
                    text = AnnotatedString(user.name),
                    modifier = Modifier.padding(all = 16.dp),
                    onClick = { navController.navigate(("users/${user.id}")) },
                )
            }
        }
    }
}
