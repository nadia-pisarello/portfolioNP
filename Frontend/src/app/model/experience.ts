export class Experience {
    id? : number;
    xp_name : string;
    xp_descrip : string;

    constructor(xp_name: string, xp_descrip: string){
        this.xp_name = xp_name;
        this.xp_descrip = xp_descrip;
    }
}
