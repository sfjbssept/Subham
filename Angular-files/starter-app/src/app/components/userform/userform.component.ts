import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {

  username:String="";
  age:number=0;
  title = 'hello world';
  desc:String ="You are using Angular Cli"

  save(){
    console.log("the user's name is "+ this.username + " whose name is "+this.age);
  }
  constructor() { }

  ngOnInit(): void {
  }

}
