import { Injectable } from '@angular/core';
import { Storage, ref, uploadBytes, list, getDownloadURL } from '@angular/fire/storage';
import { DomSanitizer } from '@angular/platform-browser';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  public archivos: any = [];
  url: string = "";
  constructor(private storage: Storage, private sanitizer: DomSanitizer) { }

  ngOnInit(){
    this.getImage();
  }

  public uploadFile($event: any, name: string){
    const file = $event.target.files[0].name;
    this.extraerBase64(file).then((image:any) =>{
      console.log(image);
    })
    this.archivos.push(file);    
    const imageRef = ref(this.storage, `image/${name}`);
    uploadBytes(imageRef, file)
    .then(response => {this.getImage()} )
    .catch(error => console.log(error));
   
  }

  getImage(){
    const imageRef = ref(this.storage,'image');
    list(imageRef).then(async response => {
      for(let item of response.items){
        this.url = await getDownloadURL(item);
        console.log(this.url);
      }
    }).catch(error => console.log(error));
  }

  extraerBase64 = async ($event: any) => new Promise((resolve, reject) => {
    try {
      const unsafeImg = window.URL.createObjectURL($event);
      const image = this.sanitizer.bypassSecurityTrustUrl(unsafeImg);
      const reader = new FileReader();
      reader.readAsDataURL($event);
      reader.onload = () => {
        resolve({
          base: reader.result
        });
      };
      reader.onerror = error => {
        resolve({
          base: null
        });
      };

    } catch (e) {
      return null;
    }
  })
}
