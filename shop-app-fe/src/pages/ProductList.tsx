import { useState, useEffect, memo } from "react";
import { useNavigate } from "react-router-dom";
import getProductList from "../global/api";
import { addToCart } from "../global/storage";
import ProductType from "../types/ProductType";
import styles from "../css/productlist_and_cart.module.css";

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

    function addToShoppingCart(id: number): void {
        // console.log("Added: " + id);
        // we transform id to index
        addToCart(productList.at(--id)!);
    }

    function goTo(id: number): void {
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
                    <th>Username</th>
                    <th title="View product.">View</th>
                    <th title="Add to cart.">Add</th>

                </tr>
            </thead>
            <tbody>
            {            
                productList.map((product: ProductType) => (
                    <tr key={product.id}>
                        <td>{product.id}</td>
                        <td>{product.name}</td>
                        <td>{product.username}</td>

                        {/* I'm not using <Link> for UI/UX reasons */}
                        <td onClick={() => goTo(product.id)} title={"View \"" + product.name + "\"."}>&gt;</td>
                        <td onClick={() => addToShoppingCart(product.id)} title={"Add \"" + product.name + "\" to cart."}>+</td>
                    </tr>
                ))
            }
            </tbody>
        </table>
    </>
    );
}

export default memo(ProductList);