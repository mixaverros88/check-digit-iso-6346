import { Component } from '@angular/core';
import {CheckDigitServiceService} from '../services/check-digit-service.service';
import { CheckDigitRequest } from '../models/CheckDigitRequest';
import { FormGroup, FormControl } from '@angular/forms';
import { CheckDigitResponse } from '../models/CheckDigitResponse';

@Component({
  selector: 'app-check-digit',
  templateUrl: './check-digit.component.html'
})
export class CheckDigitComponent{

  form = new FormGroup({
    digit: new FormControl()
  })

  message:string;

  public checkDigitResponse: CheckDigitResponse;
  public checkDigitRequest: CheckDigitRequest;
  constructor(private checkDigitServiceService:CheckDigitServiceService) {
    this.checkDigitRequest = new CheckDigitRequest();
    this.checkDigitResponse = new CheckDigitResponse();
    // this.checkDigitRequest.text = 'CSQU3054383';
  }


  validate() {
    this.checkDigitRequest.text = this.form.get('digit').value;
    this.checkDigitResponse = this.checkDigitServiceService.postString(this.checkDigitRequest);
    this.message = this.checkDigitResponse.text;
  }

}
