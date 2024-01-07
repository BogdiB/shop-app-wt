import { ItemListType } from "../types/ItemListType";
import { apiURL, testURL } from "./variables";

async function getItemList() : Promise<ItemListType[]> {
    let response : Response = await fetch(testURL, {method: "GET"});
    let text : string = await response.text();
    let itemList: ItemListType[] = JSON.parse(text);
    console.log(itemList);
    return itemList;
}

export default getItemList;