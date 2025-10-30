package com.example.demolazylist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demolazylist.page.addtolayout.AddBasicsScreen
import com.example.demolazylist.page.crud_list.CrudListScreen
import com.example.demolazylist.page.home.HomeScreen
import com.example.demolazylist.page.lazy_column.LazyColumnScreen
import com.example.demolazylist.page.lazy_row.LazyRowScreen
import com.example.demolazylist.page.multitype_click.detail.DetailTypeAScreen
import com.example.demolazylist.page.multitype_click.detail.DetailTypeBScreen
import com.example.demolazylist.page.multitype_click.detail.DetailTypeCScreen
import com.example.demolazylist.page.multitype_click.MultiTypeListScreen
import com.example.demolazylist.page.nestedlazy.NestedLazyListsScreen
import com.example.demolazylist.page.staggered_grid.StaggeredGridScreen

@Composable
fun AppNavGraph(modifier: Modifier = Modifier) {
    val nav = rememberNavController()

    NavHost(
        navController = nav,
        startDestination = Route.Home.path,
        modifier = modifier
    ) {
        composable(Route.Home.path) {
            HomeScreen(
                toAddBasics = { nav.navigate(Route.AddBasics.path) },
                toLazyColumn = { nav.navigate(Route.LazyColumn.path) },
                toLazyRow = { nav.navigate(Route.LazyRow.path) },
                toMultiType = { nav.navigate(Route.MultiType.path) },
                toCrud = { nav.navigate(Route.CrudList.path) },
                toGrid = { nav.navigate(Route.StaggeredGrid.path) },
                toScroll2D = { nav.navigate(Route.Scroll2D.path) }
            )
        }

        composable(Route.AddBasics.path) {
            AddBasicsScreen(onBack = { nav.popBackStack() })
        }
        composable(Route.LazyColumn.path) {
            LazyColumnScreen(onBack = { nav.popBackStack() })
        }
        composable(Route.LazyRow.path) {
            LazyRowScreen(onBack = { nav.popBackStack() })
        }

        composable(Route.MultiType.path) {
            MultiTypeListScreen(
                onBack = { nav.popBackStack() },
                openA = { nav.navigate(Route.MultiTypeDetailA.path) },
                openB = { nav.navigate(Route.MultiTypeDetailB.path) },
                openC = { nav.navigate(Route.MultiTypeDetailC.path) },
            )
        }
        composable(Route.MultiTypeDetailA.path) { DetailTypeAScreen(onBack = { nav.popBackStack() }) }
        composable(Route.MultiTypeDetailB.path) { DetailTypeBScreen(onBack = { nav.popBackStack() }) }
        composable(Route.MultiTypeDetailC.path) { DetailTypeCScreen(onBack = { nav.popBackStack() }) }

        composable(Route.CrudList.path) { CrudListScreen(onBack = { nav.popBackStack() }) }
        composable(Route.StaggeredGrid.path) { StaggeredGridScreen(onBack = { nav.popBackStack() }) }
        composable(Route.Scroll2D.path) { NestedLazyListsScreen(onBack = { nav.popBackStack() }) }
    }
}
