import { Item } from "./item";

export class OrderedItem {
    id : number;
    item : Item;
    prepared : boolean;

    constructor(id : number,item : Item, prepared : boolean) {
        this.id = id;
        this.item = item;
        this.prepared = prepared;
      }
}
