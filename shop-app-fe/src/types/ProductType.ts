import { UUID } from "crypto";

export default interface ProductType {
    productID: UUID,
    categoryID: UUID,
    productName: string,
    productDescription: string,
    productPrice: number,
    productWeight: number,
    productImageURL: string,
    categoryName: string,
    categoryDescription: string
}