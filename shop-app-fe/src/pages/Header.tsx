import { Outlet } from "react-router-dom";
import styles from "../css/header.module.css";

function Header() {
    return (
        <>
            <div className={styles.headerContainer}>
                <h1>Shop App</h1>
            </div>
            <Outlet />
        </>
    );
}

export default Header;