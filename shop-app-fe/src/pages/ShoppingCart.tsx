import { useNavigate } from "react-router-dom";
import { clearCart, getAllFromCart, removeFromCart } from "../global/storage";
import ProductType from "../types/ProductType";
import styles from "../css/productlist_and_cart.module.css";
import cartStyles from "../css/shoppingcart.module.css";
import { useEffect } from "react";

function ShoppingCart() {
    const navigate = useNavigate();
    let productList = getAllFromCart();

    // basically useState, I was just curious if this works well :)
    useEffect(() => {
        return ;
    }, [productList]);

    function removeFromShoppingCart(id: number) {
        console.log("Removed: " + id);
        removeFromCart(productList!.at(--id)!);
        productList!.splice(--id, 1);
    }

    function clearShoppingCart() {
        clearCart();
        productList = null;
    }

    function goTo(id: number): void {
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
                        <th>Username</th>
                        <th>Number</th>
                        <th title="View product.">View</th>
                        <th title="Remove from cart.">Remove</th>
    
                    </tr>
                </thead>
                <tbody>
                {            
                    productList !== null && productList.map((product: ProductType) => (
                        <tr key={product.id}>
                            <td>{product.id}</td>
                            <td>{product.name}</td>
                            <td>{product.username}</td>
                            <td>NR</td>
    
                            {/* I'm not using <Link> for UI/UX reasons */}
                            <td onClick={() => goTo(product.id)} title={"View \"" + product.name + "\"."}>&gt;</td>
                            <td onClick={() => removeFromShoppingCart(product.id)} title={"Remove \"" + product.name + "\" from cart."}>-</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </>
        );
}

export default ShoppingCart;