import { Order } from "./order.model";

export class SittingTableClass {
    tableId?: number;
    typeId: number;
    restaurantId: number;
    x : number;
    y : number;
    numOfSeats: number;
    icon: string;
    order ?: Order;

    constructor(tableId: number|undefined, typeId: number, restaurantId: number, x: number,y : number, numOfSeats : number, icon : string, order:Order|undefined) {
        this.tableId = tableId;
        this.typeId = typeId;
        this.restaurantId = restaurantId;
        this.x = x;
        this.y = y;
        this.numOfSeats = numOfSeats;
        this.icon = icon;
        this.order = order;
      }

    getTableId():number|undefined {
        return this.tableId;
    }

    getTypeId():number {
        return this.typeId;
    }

    getX():number {
        return this.x;
    }

    getY():number {
        return this.y;
    }

    getNumOfSeats():number{
        return this.numOfSeats;
    }

    getIcon():string{
        return this.icon;
    }
    setX(x : number):void {
        this.x = x
    }

    setY(y : number):void {
        this.y = y
    }

    getOrder():Order|undefined{
        return this.order;
    }
}
