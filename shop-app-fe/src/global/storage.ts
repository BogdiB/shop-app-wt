import ProductType from "../types/ProductType";
const CART_KEY = "shop-app-react";

function getAllFromCart(): ProductType[] | null {
    let products = sessionStorage.getItem(CART_KEY);
    if (products !== null) {
        return JSON.parse(products) as ProductType[];
    }
    return null;
}

function addToCart(product: ProductType): void {
    let storage = sessionStorage.getItem(CART_KEY);
    if (storage === null) {
        let products: ProductType[] = [product];
        sessionStorage.setItem(CART_KEY, JSON.stringify(products));
    }
    else {
        let parsed: ProductType[] = JSON.parse(storage);
        parsed.push(product);
        sessionStorage.setItem(CART_KEY, JSON.stringify(parsed));
    }
}

function removeFromCart(product: ProductType): void {
    let storage = sessionStorage.getItem(CART_KEY);
    if (storage === null) {
        return;
    }
    else {
        let parsed: ProductType[] = JSON.parse(storage);
        for (let i = 0; i < parsed.length; ++i) {
            if (parsed.at(i)!.id === product.id) {
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