export class Experience {
    xpId?: number;
    xpName: string;
    descripXp: string;
    constructor(xpName: string, descripXp: string){
        this.xpName = xpName;
        this.descripXp = descripXp;
    }
}
