export class SittingTableTypeClass {
    id: number;
    numOfSeats: number;
    name: string;
    icon: string;

    constructor(id: number,numOfSeats : number, name: string, icon: string) {
        this.id = id;
        this.numOfSeats = numOfSeats;
        this.name = name;
        this.icon = icon;
      }

    getId():number {
        return this.id;
    }


    getNumOfSeats():number{
        return this.numOfSeats;
    }

    getName():string{
        return this.name;
    }

    public getIcon():string{
        return this.icon;
    }
}
