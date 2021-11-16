import { Order } from "./order.model";

export class SittingTableClass {
    tableId?: number;
    typeId?: number;
    x? : number;
    y? : number;
    numOfSeats?: number;
    icon?: string;
    order ?: Order;
    name ?: string;

    constructor(tableId: number|undefined, typeId: number|undefined, x: number|undefined,y : number|undefined, numOfSeats : number|undefined, icon : string|undefined, order:Order|undefined, name:string|undefined) {
        this.tableId = tableId;
        this.typeId = typeId;
        this.x = x;
        this.y = y;
        this.numOfSeats = numOfSeats;
        this.icon = icon;
        this.order = order;
        this.name = name;
      }

}
