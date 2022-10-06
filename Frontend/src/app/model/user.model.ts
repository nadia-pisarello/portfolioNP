export class user{
    userId?: number;
    name: string;
    lastname: string;
    position: string;
    description: string;

    constructor(name: string, lastname: string, position: string, description: string){
        this.name = name;
        this.lastname = lastname;
        this.position = position;
        this.description = description;
    }
}
