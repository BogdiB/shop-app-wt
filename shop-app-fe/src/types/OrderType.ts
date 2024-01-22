import { UUID } from "crypto";

export default interface OrderType {
    productToQuantityMap: {productId: UUID, quantity: number},
    createdAt: string,
    country: string,
    city: string,
    county: string,
    street: string
}