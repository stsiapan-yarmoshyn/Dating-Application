package com.example.datingapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core_navigation_api.NavigationDispatcher
import com.example.datingapplication.navigation.AppNavigator
import com.example.datingapplication.navigation.FeatureNavAdapter
import com.example.datingapplication.ui.theme.DatingApplicationTheme
import com.example.feature_registration_api.navigation.RegistrationNavHandler
import com.example.feature_registration_impl.screen.RegistrationViewModel
import com.example.feature_registration_impl.screen.ui.RegistrationScreen
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // 1. Внедряем глобальный диспетчер команд
    @Inject
    lateinit var navigationDispatcher: NavigationDispatcher

    // 2. Внедряем хендлер фичи (из api модуля)
    @Inject
    lateinit var registrationNavHandler: RegistrationNavHandler

    // 3. Внедряем список всех адаптеров (из app модуля)
    @Inject
    lateinit var featureNavAdapters: Set<@JvmSuppressWildcards FeatureNavAdapter>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DatingApplicationTheme {
                val navController = rememberNavController()

                // Создаем AppNavigator и кэшируем его, чтобы он не пересоздавался при Recomposition
                val appNavigator = remember(navController) {
                    AppNavigator(
                        registrationHandler = registrationNavHandler,
                        adapters = featureNavAdapters.toList(),
                        navController = navController
                    )
                }

                LaunchedEffect(Unit) {
                    navigationDispatcher.commands.collect { command ->
                        appNavigator.handleCommand(command)
                    }
                }


                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "registration", // либо Type-Safe роут, если настроили
                        modifier = Modifier.padding(innerPadding) // Применяем системные отступы ко ВСЕМ экранам
                    ) {
                        // Здесь объявляем экраны из ваших фич
                        composable("registration") {
                            // Вызываем Composable экран из registration-impl
                            RegistrationScreen()
                        }

//                        composable("login/{userId}") { backStackEntry ->
//                            val userId = backStackEntry.arguments?.getString("userId").orEmpty()
//                            // Вызываем Composable экран из login-impl
//                            LoginScreen(userId = userId)
//                        }

                        // Сюда же добавляются остальные фичи: matching, chat и т.д.
                    }
                }
            }
        }
    }
}