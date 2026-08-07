package navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
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

@Composable
fun App() {

    val navConfig = remember {
        SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(RegistrationRoute.Main::class)
                    subclass(MatchingRoute.Main::class)
                    subclass(MatchingRoute.Details::class)
                    subclass(LoginRoute.Main::class)
                }
            }
        }
    }

    val backStack =
        rememberNavBackStack(
            configuration = navConfig,
            elements = arrayOf(LoginRoute.Main)
        )

    MaterialTheme {
        NavDisplay(
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                // Подключаем графы из разных impl-модулей
                registrationGraph(
                    navigateToLogin = {
                        backStack.add(LoginRoute.Main)
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
                loginGraph {
                    backStack.add(MatchingRoute.Main)
                }
            },
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            )
        )
    }
}