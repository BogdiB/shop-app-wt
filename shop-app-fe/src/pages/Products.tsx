import { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { getProduct } from "../global/api";
import { UUID } from "crypto";
import ProductType from "../types/ProductType";
import styles from "../css/products.module.css";

function Products() {
    const [product, setProduct] = useState<ProductType>({} as ProductType);
    const location = useLocation();
    const navigate = useNavigate();
    let id: UUID | null | undefined = location.pathname.match("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")?.[0] as UUID | null | undefined;

    useEffect(() => {
        if (id === null || id === undefined) {
            navigate("/*");
            return ;
        }
        getProduct(id)
            .then((product: ProductType) => {
                // console.log(product);
                setProduct(product);
            });
    }, [id])

    return (
        <>
        <h2 className="headText">{product.productName || "Product"}</h2>
        <div className={styles.productContainer}>
            <div className={styles.productLabels}>
                <p>Name:</p>
                <p>Description:</p>
                <p>Category:</p>
                <p>Category description:</p>
                <p>Weight:</p>
                <p>Price:</p>
            </div>
            <div className={styles.productInformation}>
                <p>{product.productName}</p>
                <p>{product.productDescription}</p>
                <p>{product.categoryName}</p>
                <p>{product.categoryDescription}</p>
                <p>{product.productWeight} KG</p>
                <p>{product.productPrice} RON</p>
            </div>
        </div>
        </>
    );
}

export default Products;