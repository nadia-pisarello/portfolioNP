export class Proyect{
    id?: number;
    title: String;
    description: String;
    image: String;
    
    constructor(title: string, description: string, image: string){
        this.title= title;
        this.description= description;
        this.image=image;
    }
}