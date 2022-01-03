import { OrderedItem } from "./ordered-item.model";


export class Order {
    orderId: number;
    items: OrderedItem[];
    tableName : string;


    constructor() {
        this.items = [];
      }
    setItems(items : OrderedItem[]):void{
      this.items = items;
    }
}
