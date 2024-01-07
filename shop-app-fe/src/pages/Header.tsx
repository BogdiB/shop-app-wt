import { Outlet } from "react-router-dom";
import style from "../css/header.module.css";

function Header() {
    return (
        <>
            <div className={style.headerContainer}>
                <h1>This will be the header</h1>
            </div>
            <Outlet />
        </>
    );
}

export default Header;