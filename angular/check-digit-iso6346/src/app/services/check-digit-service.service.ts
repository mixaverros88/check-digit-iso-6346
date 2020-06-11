import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { CheckDigitRequest } from '../models/CheckDigitRequest';
import { CheckDigitResponse } from '../models/CheckDigitResponse';

@Injectable({
  providedIn: 'root'
})
export class CheckDigitServiceService {
  URL:string = 'http://localhost:8080/iso/api/rest';
  public checkDigitResponse: CheckDigitResponse;

  constructor( private httpClient: HttpClient) {
    this.checkDigitResponse = new CheckDigitResponse();
  }


  postString(checkDigit: CheckDigitRequest): CheckDigitResponse{
    this.httpClient
      .post(this.URL, { text: checkDigit.text })
      .subscribe(
        (response:any) =>{
          this.checkDigitResponse.text = 'ok';
        }
    );
    return this.checkDigitResponse;
  }

}
