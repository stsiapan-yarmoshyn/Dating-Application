package navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.example.feature_login_api.navigation.LoginRoute
import com.example.feature_login_impl.navigation.loginGraph
import com.example.feature_matching_api.navigation.MatchingRoute
import com.example.feature_matching_impl.navigation.matchingGraph
import com.example.feature_registration_api.navigation.RegistrationRoute
import com.example.feature_registration_impl.navigation.registrationGraph
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import org.koin.compose.viewmodel.koinViewModel
import ui.splash.SplashScreen
import viewmodel.AuthState
import viewmodel.MainViewModel

@Composable
fun App() {

    val mainViewModel: MainViewModel = koinViewModel()
    val authState by mainViewModel.authState.collectAsState()

    val navConfig = remember {
        SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(
                        RegistrationRoute.RegistrationMain::class,
                        RegistrationRoute.RegistrationMain.serializer()
                    )
                    subclass(
                        MatchingRoute.MatchingMain::class,
                        MatchingRoute.MatchingMain.serializer()
                    )
                    subclass(MatchingRoute.MatchingDetails::class)
                    subclass(LoginRoute.LoginMain::class)
                }
            }
        }
    }

    val backStack =
        rememberNavBackStack(
            configuration = navConfig,
            elements = arrayOf(MatchingRoute.MatchingMain)
        )

    LaunchedEffect(authState) {
        when (authState) {
            is AuthState.Authenticated -> {
                // Если сессия валидна
                backStack.clear()
                backStack.add(MatchingRoute.MatchingMain)
            }

            is AuthState.Unauthenticated -> {
                // Если токена нет/протух
                backStack.clear()
                backStack.add(LoginRoute.LoginMain)
            }

            is AuthState.Loading -> {}
        }
    }

    MaterialTheme {
        if (authState is AuthState.Loading) {
            SplashScreen()
        } else {
            NavDisplay(
                backStack = backStack,
                onBack = { backStack.removeLastOrNull() },
                entryProvider = entryProvider {
                    // Подключаем графы из разных impl-модулей
                    registrationGraph(
                        navigateToLogin = {
                            backStack.clear()
                            backStack.add(LoginRoute.LoginMain)
                        }
                    )
                    matchingGraph(
                        backStack = backStack,
                        navigateToChat = {
                            //backStack.add(ChatRoute.Main)
                        },
                        navigateToProfile = {
                            //backStack.add(ProfileRoute.Main)
                        },
                        navigateToMatching = {
                            //backStack.add(ProfileRoute.Main)
                        }
                    )
                    loginGraph(
                        navigateToRegistration = {
                            backStack.add(RegistrationRoute.RegistrationMain)
                        },
                        navigateToMatching = {
                            backStack.clear()
                            backStack.add(MatchingRoute.MatchingMain)
                        }
                    )
                },
                entryDecorators = listOf(
                    rememberSaveableStateHolderNavEntryDecorator(),
                    rememberViewModelStoreNavEntryDecorator()
                )
            )
        }
    }
}