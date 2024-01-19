import { useState, useEffect, memo } from "react";
import { useNavigate } from "react-router-dom";
import getProductList from "../global/api";
import { addToCart } from "../global/storage";
import ProductType from "../types/ProductType";
import styles from "../css/productlist_and_cart.module.css";
import { UUID } from "crypto";
import ShoppingCartType from "../types/ShoppingCartType";

function ProductList() {
    const [productList, setProductList] = useState<ProductType[]>([]);
    const navigate = useNavigate();

    useEffect(() => {
        getProductList()
            .then((item) => {
                // console.warn(item);
                setProductList(item);
        });
    }, []);

    function addToShoppingCart(product: ProductType): void {
        // console.log("Added: " + id);
        // we transform id to index
        addToCart(product);
    }

    function goTo(id: UUID): void {
        navigate("/products/" + id);
    }

    return (
    <>
        <h2 className="headText">Product List</h2>
        <table className={styles.table}>
            <thead>
                <tr key={0}>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th title="View product.">View</th>
                    <th title="Add to cart.">Add</th>

                </tr>
            </thead>
            <tbody>
            {            
                productList.map((product: ProductType) => (
                    <tr key={product.productID}>
                        <td>{product.productID}</td>
                        <td>{product.productName}</td>
                        <td>{product.categoryName}</td>
                        <td>{product.productPrice} RON</td>

                        {/* I'm not using <Link> for UI/UX reasons */}
                        <td onClick={() => goTo(product.productID)} title={"View \"" + product.productName + "\"."}>&gt;</td>
                        <td onClick={() => addToShoppingCart(product)} title={"Add \"" + product.productName + "\" to cart."}>+</td>
                    </tr>
                ))
            }
            </tbody>
        </table>
    </>
    );
}

export default memo(ProductList);