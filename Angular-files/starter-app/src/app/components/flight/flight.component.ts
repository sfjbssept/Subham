import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-flight',
  templateUrl: './flight.component.html',
  styleUrls: ['./flight.component.css']
})
export class FlightComponent implements OnInit {

  flights:Flight[];
  constructor() {

    this.flights = new Array();
    this.flights[0]=new Flight("Indigo", "Bangalore", "Pune", "2024-05-05 18:00", "2024-05-05 19:00", 2000);
    this.flights[1]=new Flight("Air India", "Delhi", "Ranchi", "2024-05-05 18:00", "2024-05-05 19:00", 2000);
    this.flights[2]=new Flight("SpiceJet", "Patna", "Mumbai", "2024-05-05 18:00", "2024-05-05 19:00", 2000);
    this.flights[3]=new Flight("Vistara", "Chennai", "Hyderbad", "2024-05-05 18:00", "2024-05-05 19:00", 2000);

   }

  ngOnInit(): void {
  }

}

class Flight{
    company:string;
    from:string;
    to:string;
    departure:string;
    arrival:string;
    cost:number;

    constructor(company:string,from:string,to:string,departure:string,arrival:string,cost:number){
      this.company = company;
      this.from =from;
      this.to = to;
      this.departure = departure;
      this.arrival= arrival;
      this.cost = cost;
    }
}