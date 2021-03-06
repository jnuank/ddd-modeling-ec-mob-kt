package shopping.model.cart

data class Cart(
        val items : List<CartItem>
) {
    val 小計 = items.map { it.小計.value }.sum().let { shopping.model.cart.小計(it) }

    fun showCartItems() : String {
        // TODO 別のレイヤー（多分プレゼンテーション層のレイヤー）のオブジェクトに出力処理を委譲する
        val list = mutableListOf<String>()

        list.add("商品名,単価,数量,合計")

        items
                .forEach {
            list.add("${it.product.productName.value},${it.product.unitPrice.value},${it.quantity.value},${it.小計.value}")
        }


        list.add("小計: ${小計.value}円")

        return list.joinToString("\n")
    }
}