package shopping.repository

import shopping.model.product.Product
import shopping.model.product.ProductCode
import shopping.model.product.ProductName
import shopping.model.product.UnitPrice

class ProductRepositoryImpl : ProductRepository {

    private val database : List<Product> = listOf(
            Triple("いちご","150","001"),
            Triple("米","200","002"),
            Triple("みかん","250","003"),
            Triple("なす","300","004"),
            Triple("とちおとめ","400","005"))
            .map { Product(
                    productName = ProductName(it.first),
                    unitPrice = UnitPrice(it.second.toInt()),
                    productCode = ProductCode(it.third))
            }

    override fun find(productCode: String): Product? {
        return database.firstOrNull { it.productCode.value == productCode }
    }
}