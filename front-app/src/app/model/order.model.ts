import { Item } from "./item.model";

export class Order {
    items: Item[];


    constructor(items:Item[]) {
        this.items = items;
      }
}
