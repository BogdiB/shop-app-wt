import { Link, Outlet, useLocation } from "react-router-dom";
import styles from "../css/header.module.css";

function Header() {
    const location = useLocation();

    return (
        <>
            <div className={styles.headerContainer}>
                <h1>Shop App</h1>
                <div className={styles.headerButtons}>
                    { !(location.pathname === "/shopping-cart") && <Link to={"/shopping-cart"}><button title="Go to your shopping cart.">Cart</button></Link> }
                </div>
            </div>
            <Outlet />
        </>
    );
}

export default Header;