import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { clearCart, getAllFromCart, removeFromCart } from "../global/storage";
import ShoppingCartType from "../types/ShoppingCartType";
import styles from "../css/productlist_and_cart.module.css";
import cartStyles from "../css/shoppingcart.module.css";

function ShoppingCart() {
    const navigate = useNavigate();
    let [productList, setProductList] = useState(getAllFromCart());

    function removeFromShoppingCart(product: ShoppingCartType) {
        removeFromCart(product);
        let newProductList = productList?.filter((prod) => prod.product.productID !== product.product.productID) || null;
        if (newProductList?.length === 0) {
            newProductList = null;
        }
        setProductList(newProductList);
    }

    function clearShoppingCart() {
        clearCart();
        setProductList(null);
    }

    return (
        <>
            <div className={cartStyles.topSide}>
                <h2 className="headText">Shopping Cart</h2>
                <button disabled={productList === null} onClick={clearShoppingCart} title="Clear your shopping cart.">Clear Cart</button>
            </div>
            <table className={styles.table + " " + cartStyles.cartTable}>
                <thead>
                    <tr key={0}>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th title="View product.">View</th>
                        <th title="Remove all from cart.">Remove</th>
    
                    </tr>
                </thead>
                <tbody>
                {            
                    productList !== null && productList.map((product: ShoppingCartType) => (
                        <tr key={product.product.productID}>
                            <td>{product.product.productID}</td>
                            <td>{product.product.productName}</td>
                            <td>{product.product.categoryName}</td>
                            <td>{product.product.productPrice} RON</td>
                            <td>{product.numberOfProducts}</td>
    
                            {/* I'm not using <Link> for UI/UX reasons */}
                            <td onClick={() => navigate("/products/" + product.product.productID)} title={"View \"" + product.product.productName + "\"."}>&gt;</td>
                            <td onClick={() => removeFromShoppingCart(product)} title={"Remove \"" + product.product.productName + "\" from cart."}>-</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
            <div className={cartStyles.checkout}>
                <button disabled={productList === null} onClick={() => navigate("/checkout")}>Checkout</button>
            </div>
        </>
        );
}

export default ShoppingCart;