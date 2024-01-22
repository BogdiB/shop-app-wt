import { UUID } from "crypto";
import { apiURL } from "./variables";
import ProductType from "../types/ProductType";
import OrderType from "../types/OrderType";

async function getProductList() : Promise<ProductType[]> {
    let response : Response = await fetch(apiURL + "/products", {method: "GET"});
    let text : string = await response.text();
    let productList: ProductType[] = JSON.parse(text);
    // console.log(productList);
    return productList;
}

async function getProduct(id: UUID): Promise<ProductType> {
    let response : Response = await fetch(apiURL + "/products/" + id, {method: "GET"});
    let text : string = await response.text();
    let product: ProductType = JSON.parse(text);
    // console.log(product);
    return product;
}

function sendOrder(prodId: UUID, numberOfProducts: number, country: string, city: string, county: string, street: string): void {
    const time: string = new Date().toLocaleString(undefined, {
        hourCycle: "h23",
        year: "2-digit",
        month: "2-digit",
        day: "2-digit",
        hour: "2-digit",
        minute: "2-digit",
        second: "2-digit"
      });
      console.log(time);
    const order: OrderType = {
        productToQuantityMap: {productId: prodId, quantity: numberOfProducts},
        createdAt: time,
        country: country,
        city: city,
        county: county,
        street: street
    };
}

export default getProductList;
export {getProduct, sendOrder};