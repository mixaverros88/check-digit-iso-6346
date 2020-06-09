import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CheckDigitServiceService {
  URL:string = 'http://localhost:8080/check-digit-iso-6346/webapi/rest';

  constructor( private httpClient: HttpClient) {

  }


  postString(checkDigit: string){
    this.httpClient
      .post(this.URL, checkDigit)
      .subscribe(
        (response:any) =>{
          console.log('okkk')
        }
    );
  }
}
