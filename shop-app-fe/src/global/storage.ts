import ProductType from "../types/ProductType";
import ShoppingCartType from "../types/ShoppingCartType";
const CART_KEY = "shop-app-react";

function getAllFromCart(): ShoppingCartType[] | null {
    let products = sessionStorage.getItem(CART_KEY);
    if (products !== null) {
        return JSON.parse(products) as ShoppingCartType[];
    }
    return null;
}

function addToCart(product: ProductType): void {
    let storage = sessionStorage.getItem(CART_KEY);
    if (storage === null) {
        let products: ShoppingCartType[] = [{product, numberOfProducts: 1}];
        sessionStorage.setItem(CART_KEY, JSON.stringify(products));
    }
    else {
        let parsed: ShoppingCartType[] = JSON.parse(storage);
        let found: boolean = false;
        for (let i = 0; i < parsed.length; ++i) {
            let p = parsed.at(i) as ShoppingCartType;
            if (p.product.productID === product.productID) {
                p.numberOfProducts++;
                found = true;
            }
        }
        if (found === false) {
            parsed.push({product, numberOfProducts: 1});
        }
        sessionStorage.setItem(CART_KEY, JSON.stringify(parsed));
    }
}

function removeFromCart(product: ShoppingCartType): void {
    let storage = sessionStorage.getItem(CART_KEY);
    if (storage === null) {
        return;
    }
    else {
        let parsed: ShoppingCartType[] = JSON.parse(storage);
        for (let i = 0; i < parsed.length; ++i) {
            if (parsed.at(i)!.product.productID === product.product.productID) {
                parsed.splice(i, 1);
                break;
            }
        }
        if (parsed.length !== 0) {
            sessionStorage.setItem(CART_KEY, JSON.stringify(parsed));
        }
        else {
            sessionStorage.removeItem(CART_KEY);
        }
    }
}

function clearCart(): void {
    sessionStorage.removeItem(CART_KEY);
}

export { getAllFromCart, addToCart, removeFromCart, clearCart };