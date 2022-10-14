export class Skill{
    id?: number;
    tech: string;
    image: string;
    
    constructor(tech: string, image: string){
        this.tech= tech;
        this.image= image;
    }
}