import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getProduct } from "../global/api";
import ProductType from "../types/ProductType";
import styles from "../css/products.module.css";

function Products() {
    const {id} = useParams();
    const [product, setProduct] = useState<ProductType>({} as ProductType);

    useEffect(() => {
        getProduct(Number.parseInt(id!))
            .then((product: ProductType) => {
                // console.log(product);
                setProduct(product);
            });
    }, [id])

    return (
        <>
        <h2 className="headText">{product.name || "Product"}</h2>
        <div className={styles.productContainer}>
            <div className={styles.productLabels}>
                <p>Name:</p>
                <p>Username:</p>
                <p>Email:</p>
            </div>
            <div className={styles.productInformation}>
                <p>{product.name}</p>
                <p>{product.username}</p>
                <p>{product.email}</p>
            </div>
        </div>
        </>
    );
}

export default Products;