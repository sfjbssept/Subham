import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  public email: any;
  public password: any;
  constructor(private router:Router, private userService:UserService) { }

  ngOnInit(): void {
  }

  processLogin(e:any){
    e.preventDefault();
   var email = e.target.elements[0].value;
   // const email:any = e.target.elements[0].value;
    var password = e.target.elements[1].value;

    alert("your email is " + email +" your password is " +password );

    if(email =="admin@gmail.com" && password=="1234"){
      this.userService.setUserLoggedIn();
      this.router.navigate(["profile"]);
    }else{
      alert("email or password is incorrect");
    }

  }

}
