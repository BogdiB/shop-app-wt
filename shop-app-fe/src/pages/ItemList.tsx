import { useState, useEffect, memo } from "react";
import getItemList from "../global/api";
import { ItemListType } from "../types/ItemListType";

function ItemList() {
    const [itemList, setItemList] = useState<ItemListType[]>([]);

    useEffect(() => {
        getItemList().then((item) => {
            console.warn(item);
            setItemList(item);
        });
    }, []);

    return (
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Username</th>
                </tr>
            </thead>
            <tbody>
            {            
                itemList.map((item: ItemListType) => (
                    <tr key={item.id}>
                        <td>{item.name}</td>
                        <td>{item.username}</td>
                    </tr>
                ))
            }
            </tbody>
        </table>
    );
}

export default memo(ItemList);