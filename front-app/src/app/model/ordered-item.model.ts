import { Item } from "./item.model";

export class OrderedItem {
    item : Item;
    prepared : boolean;

    constructor(item : Item, prepared : boolean) {
        this.item = item;
        this.prepared = prepared;
      }
}
