fun main() {
    val restaurant: Order = Restaurant(ListMenu.menu)
    var isContinueOrder = true
    while (isContinueOrder) {
        restaurant.orderApp()
        println("Do you want to continue ordering? (y/n)")
        val continueChoice = readln().trim().lowercase()
        if (continueChoice.lowercase() != "y") {
            isContinueOrder = false
            println("Thankyou for Order")
        }
    }
}