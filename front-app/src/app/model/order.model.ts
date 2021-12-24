import { OrderedItem } from "./ordered-item.model";


export class Order {
    items: OrderedItem[];


    constructor() {
        this.items = [];
      }
    setItems(items : OrderedItem[]):void{
      this.items = items;
    }
}
