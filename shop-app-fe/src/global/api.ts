import ProductType from "../types/ProductType";
import { apiURL, testURL } from "./variables";

async function getProductList() : Promise<ProductType[]> {
    let response : Response = await fetch(testURL, {method: "GET"});
    let text : string = await response.text();
    let productList: ProductType[] = JSON.parse(text);
    // console.log(productList);
    return productList;
}

async function getProduct(id: number): Promise<ProductType> {
    let response : Response = await fetch(testURL + "/" + id, {method: "GET"});
    let text : string = await response.text();
    let product: ProductType = JSON.parse(text);
    // console.log(product);
    return product;
}

export default getProductList;
export {getProduct};