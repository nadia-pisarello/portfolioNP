export class user{
    userId?: number;
    name: string;
    lastname: string;
    image: string;

    constructor(name: string, lastname: string, image: string){
        this.name = name;
        this.lastname = lastname;
        this.image = image;
    }
}
