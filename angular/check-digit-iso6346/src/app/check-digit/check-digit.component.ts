import { Component, OnInit } from '@angular/core';
import {CheckDigitServiceService} from "../services/check-digit-service.service";

@Component({
  selector: 'app-check-digit',
  templateUrl: './check-digit.component.html'
})
export class CheckDigitComponent implements OnInit {

  constructor(private checkDigitServiceService:CheckDigitServiceService) { }

  ngOnInit(): void {
    this.checkDigitServiceService.postString("dadasd");
  }



}
