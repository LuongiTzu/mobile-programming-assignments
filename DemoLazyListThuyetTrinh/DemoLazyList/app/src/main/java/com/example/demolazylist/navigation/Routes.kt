package com.example.demolazylist.navigation

sealed class Route(val path: String) {
    data object Home : Route("home")

    // Pages
    data object AddBasics : Route("add_basics")
    data object LazyColumn : Route("lazy_column")
    data object LazyRow : Route("lazy_row")
    data object MultiType : Route("multitype")
    data object MultiTypeDetailA : Route("multitype/detailA")
    data object MultiTypeDetailB : Route("multitype/detailB")
    data object MultiTypeDetailC : Route("multitype/detailC")
    data object CrudList : Route("crud_list")
    data object StaggeredGrid : Route("staggered_grid")
    data object Scroll2D : Route("nestedlazy")
}
