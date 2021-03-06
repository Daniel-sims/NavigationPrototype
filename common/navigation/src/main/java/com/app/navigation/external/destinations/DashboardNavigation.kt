package com.app.navigation.external.destinations

import com.app.navigation.external.NavigationDestination

object DashboardNavigation : NavigationDestination {

    private const val DASHBOARD_ROUTE = "dashboard"

    override fun route(): String = DASHBOARD_ROUTE

    fun createDashboardRoute() = DASHBOARD_ROUTE
}


/***
NavigationDestination {

override fun route(): String = BOOK_DETAILS_BOTTOM_NAV_ROUTE

override val arguments: List<NamedNavArgument>
get() = listOf(navArgument(BOOK_ID_PARAM) { type = NavType.IntType })

const val BOOK_ID_PARAM = "book"

private const val DASHBOARD_ROUTE = "dashboard"
private const val BOOK_DETAILS_BOTTOM_NAV_ROUTE = "$BOOK_DETAILS_ROUTE/{$BOOK_ID_PARAM}"
fun createBookDetailsRoute(bookID: Int) = "$BOOK_DETAILS_ROUTE/${bookID}"

}
 ***/