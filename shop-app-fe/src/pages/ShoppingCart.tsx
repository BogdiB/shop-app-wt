import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { UUID } from "crypto";
import { clearCart, getAllFromCart, removeFromCart } from "../global/storage";
import ShoppingCartType from "../types/ShoppingCartType";
import styles from "../css/productlist_and_cart.module.css";
import cartStyles from "../css/shoppingcart.module.css";

function ShoppingCart() {
    const navigate = useNavigate();
    let [productList, setProductList] = useState(getAllFromCart());

    function removeFromShoppingCart(product: ShoppingCartType) {
        // console.log("Removed: " + id);
        removeFromCart(product);
        setProductList(productList?.filter((prod) => {
            return prod.product.productID !== product.product.productID;
        }) || null);
        // console.log(productList);
    }

    function clearShoppingCart() {
        clearCart();
        setProductList(null);
    }

    function goTo(id: UUID): void {
        navigate("/products/" + id);
    }

    return (
        <>
            <div className={cartStyles.topSide}>
                <h2 className="headText">Shopping Cart</h2>
                <button onClick={clearShoppingCart}>Clear</button>
            </div>
            <table className={styles.table + " " + cartStyles.cartTable}>
                <thead>
                    <tr key={0}>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Number</th>
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
                            <td onClick={() => goTo(product.product.productID)} title={"View \"" + product.product.productName + "\"."}>&gt;</td>
                            <td onClick={() => removeFromShoppingCart(product)} title={"Remove \"" + product.product.productName + "\" from cart."}>-</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </>
        );
}

export default ShoppingCart;