import { UUID } from "crypto";
import ProductType from "../types/ProductType";
import { apiURL } from "./variables";

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

export default getProductList;
export {getProduct};