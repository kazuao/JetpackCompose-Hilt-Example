package com.example.hiltexample.viewModel

import androidx.lifecycle.ViewModel
import com.example.hiltexample.model.User
import com.example.hiltexample.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _users = MutableStateFlow(userRepository.getUsers())
    val users: StateFlow<List<User>> = _users
}