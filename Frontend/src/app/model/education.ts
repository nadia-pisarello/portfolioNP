export class Education {
    id?:number;
    title : string;
    institution: string;
    descriptionE: string;

    constructor(title: string, instituion:string, descriptionE: string){
        this.title = title;
        this.institution = instituion;
        this.descriptionE = descriptionE;
    }
    
}