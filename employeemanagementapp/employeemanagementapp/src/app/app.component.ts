import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
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
  //
  public editEmployee:Employee | undefined;
  public deleteEmployee: Employee | undefined;

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

  //
  //subscribe to wait for a response
  public onAddEmployee(addForm: NgForm): void {
                                                            //RANDOM ERROR HERE I NEED TO FIX
    document.getElementById('add-employee-form').click();
    this.employeeService.addEmployee(addForm.value).subscribe(
(response:Employee) => {
  console.log(response);
  this.getEmployees();
  //this clears the form
  addForm.reset();
},
(error:HttpErrorResponse) => {
  alert(error.message)
}
    );
  }

  //
  //subscribe to wait for a response
  public onUpdateEmployee(employee: Employee): void {
    //
    this.employeeService.updateEmployee(employee).subscribe(
(response:Employee) => {
  console.log(response);
  this.getEmployees();
},
(error:HttpErrorResponse) => {
  alert(error.message)
}
    );
  }

   //
  //subscribe to wait for a response
  public onDeleteEmployee(employeeId: number): void {
    //
    this.employeeService.deleteEmployee(employeeId).subscribe(
(response:void) => {
  console.log(response);
  this.getEmployees();
},
(error:HttpErrorResponse) => {
  alert(error.message)
}
    );
  }

  //search fucntion on the nav-bar
  public searchEmployees(key:string):void {
const results:Employee[] = [];
for (const employee of this.employees){

  //loop over all employees for every one check the name,email,phone, etc.  if it not equal to -1
  if(employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
  || employee.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
  || employee.phone.toLowerCase().indexOf(key.toLowerCase()) !== -1
  || employee.jobtitle.toLowerCase().indexOf(key.toLowerCase()) !== -1){
    results.push(employee);
  }
}
this.employees = results;
//
if(results.length == 0 || !key) {
  this.getEmployees();
}
  }

  //function for button on front end
//mode tell what the user is trying to do.. void because nothing will be retuned
public onOpenModal(employee: Employee, mode: string):void{
  //
const container =document.getElementById('main-container');
const button = document.createElement('button');

  //button are defualt submit setting the type to button
  button.type = 'button';
  //add some styling 
button.style.display = 'none';

//
button.setAttribute('data-toggle', 'modal');

//use the id of the modal from the html
if(mode === 'add') {
  button.setAttribute('data-target', '#addEmployeeModal');
}
//use the id of the modal from the html
if(mode === 'edit') {
  this.editEmployee =employee;
  button.setAttribute('data-target', '#updateEmployeeModal');
}
//use the id of the modal from the html
if(mode === 'delete') {
  this.deleteEmployee = employee;
  button.setAttribute('data-target', '#deleteEmployeeModal');
}
                                                    //RANDOM ERROR BELOW WILL HAVE TO FIX
container.appendChild(button);
button.click();

}
}