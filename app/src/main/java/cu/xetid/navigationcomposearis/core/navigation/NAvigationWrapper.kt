package cu.xetid.navigationcomposearis.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import cu.xetid.navigationcomposearis.DetailScreen
import cu.xetid.navigationcomposearis.HomeScreen
import cu.xetid.navigationcomposearis.LoginScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen() {
                navController.navigate(Home)
            }
        }

        composable<Home> {
            HomeScreen() {
                navController.navigate(Detail(it))
            }
        }

        composable<Detail> { backStackEntry ->
            val detail: Detail = backStackEntry.toRoute()
            DetailScreen(detail.name) {
        /*        navController.navigate(Login) {
                    popUpTo<Login> {
                        inclusive = true// Borrar todoa la pila incluyendo el primer login y solo dejando el actual k estoy metiendo en el momento           }
                }
        */
                navController.popBackStack() //salto hacia la vista anterior sin importar k este en una nueva aplicacion. navigationUp encambio al estar en nueva app le da atras a esa app y no vuelve a la nuestra
            }
        }

    }
}
