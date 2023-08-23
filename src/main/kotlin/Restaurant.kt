class Restaurant(private val menuFood: List<ItemFood>) : Order {
    private var foodMenu: ItemFood? = null

    override fun orderApp() {
        choicesMenuFood()
        insertPayment()
        choicesMethodShipment()
    }

    override fun showMenuFood() {
        menuFood.forEachIndexed { index, itemFood ->
            println(
                """
                ${index + 1} . ${itemFood.name} =  Rp.${itemFood.price}/portion
            """.trimIndent()
            )
        }
    }

    override fun choicesMenuFood(): ItemFood {
        while (true) {
            showMenuFood()

            val input = readlnOrNull()?.trim()
            val inputId = input?.toIntOrNull()

            if (inputId != null) {
                val menuResult = menuFood.find { itemFood -> itemFood.id == inputId }
                if (menuResult != null) {
                    foodMenu = menuResult
                    println(
                        """
                    Your Choice ${menuResult.id},
                    Name Menu : ${menuResult.name},
                    Price : Rp.${menuResult.price},
                """.trimIndent()
                    )
                    return menuResult
                } else {
                    println("Your choice was not found. Please input a valid number:")
                }
            } else {
                println("Invalid input. Please input a valid number:")
            }
        }
    }


    override fun insertPayment() {
        println("Insert Payment: ")
        val payment = readlnOrNull()?.trim()?.toIntOrNull()
        val foodPrice = foodMenu?.price
        if (payment != null && foodPrice != null && payment >= foodPrice) {
            println("Payment succes")
        } else {
            println("Invalid payment amount. Please input a valid amount.")
            insertPayment()
        }
    }


    override fun showMetodeShipment() {
        println(
            """
            Shipment metode Food
            1.Take Away
            2.Delivery
        """.trimIndent()
        )
    }

    override fun choicesMethodShipment() {
        showMetodeShipment()
        println("Choices Metode Shipment Food (1/2)")
        val choicesShipment = readlnOrNull()?.trim()?.toIntOrNull()
        if (choicesShipment != null && choicesShipment == 1 || choicesShipment != null && choicesShipment == 2) {
            val order1 = "Food Cooking ..."
            val order2 =
                "Your food is ready! ${if (choicesShipment == 1) "Please pick it up at the restaurant, OK?" else "The driver will come to your place soon!"}"
            val order3 = "order done .. "
            val delay = 5000L
            println(order1)
            Thread.sleep(delay)
            println(order2)
            Thread.sleep(delay)
            println(order3)
            Thread.sleep(3000)

        } else {
            println("Choices method shipment  not found")
            choicesMethodShipment()
        }


    }
}