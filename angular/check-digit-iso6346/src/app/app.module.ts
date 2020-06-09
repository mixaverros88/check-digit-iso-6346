import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CheckDigitServiceService } from './services/check-digit-service.service';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CheckDigitComponent } from './check-digit/check-digit.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    CheckDigitComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [CheckDigitServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
