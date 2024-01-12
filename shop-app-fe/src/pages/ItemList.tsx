import { useState, useEffect, memo } from "react";
import { useNavigate } from "react-router-dom";
import getItemList from "../global/api";
import ItemListType from "../types/ItemListType";
import styles from "../css/itemlist.module.css";

function ItemList() {
    const [itemList, setItemList] = useState<ItemListType[]>([]);
    const navigate = useNavigate();

    useEffect(() => {
        getItemList().then((item) => {
            // console.warn(item);
            setItemList(item);
        });
    }, []);

    function addToCart(id: number): void {
        console.log("Added: " + id);
    }

    function goTo(id: number): void {
        navigate("/product/" + id);
    }

    return (
    <>
        <h2 className={styles.headText}>Item List</h2>
        <table className={styles.table}>
            <thead>
                <tr key={0}>
                    <th>Name</th>
                    <th>Username</th>
                    <th title="View product.">View</th>
                    <th title="Add to cart.">Add</th>

                </tr>
            </thead>
            <tbody>
            {            
                itemList.map((item: ItemListType) => (
                    <tr key={item.id}>
                        <td>{item.name}</td>
                        <td>{item.username}</td>

                        {/* I'm not using <Link> for UI/UX reasons */}
                        <td onClick={() => goTo(item.id)} title={"View \"" + item.name + "\"."}>&gt;</td>
                        <td onClick={() => addToCart(item.id)} title={"Add \"" + item.name + "\" to cart."}>+</td>
                    </tr>
                ))
            }
            </tbody>
        </table>
    </>
    );
}

export default memo(ItemList);