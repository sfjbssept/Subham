import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserformComponent } from './components/userform/userform.component';
import { FlightdetailsComponent } from './components/flightdetails/flightdetails.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginFormComponent } from './components/login-form/login-form.component';

import { RouterModule, Routes } from '@angular/router';
import { ProfileComponent } from './components/profile/profile.component';
import { UserService } from './service/user.service';
import { AuthguardGuard } from './authguard.guard';
import { HomeComponent } from './components/home/home.component';
import { FlightComponent } from './components/flight/flight.component';

const appRoutes:Routes=[

  {
    path:"",
    component:HomeComponent
  },
  {
    path:"login",
    component:LoginFormComponent
  },
  
  {
    path:"profile",
    canActivate:[AuthguardGuard],
    component:ProfileComponent
  }

]

@NgModule({
  declarations: [
    AppComponent,
    UserformComponent,
    FlightdetailsComponent,
    HeaderComponent,
    FooterComponent,
    LoginFormComponent,
    ProfileComponent,
    HomeComponent,
    FlightComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UserService,
  AuthguardGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
