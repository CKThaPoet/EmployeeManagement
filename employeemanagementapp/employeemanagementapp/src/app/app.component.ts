import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

//to call the fucntion getEmployees implement an interface OnInIt, thne overide  ngOnInIt
export class AppComponent implements OnInit{
  

  //give it a type of employee array... I also had to make it undefined to get rid of the error
  public employees: Employee[] | undefined;

  //inject the service to get access
  constructor(private employeeService: EmployeeService) { }

  //
  ngOnInit(){
    this.getEmployees();
  }

  //subscribe so we can be notified some data has come back from the server
  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
(response: Employee[]) => {
  this.employees = response;
},
//error handling
(error:HttpErrorResponse) => {
  alert(error.message);
}
    );
  }
}
