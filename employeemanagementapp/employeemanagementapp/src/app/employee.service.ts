import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  //
private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  //alot of mirroring of what is in the backend
  //observables are generics so they need a type just like we did in the backend

  //the observable need to have the employee array made in the employee.ts
  //tell the httpclient how and where to make the call
  public getEmployees():Observable<Employee[]>{
    return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/all`);
  }

  //change to post<> to add to database
  public addEmployee(employee:Employee):Observable<Employee>{
    return this.http.post<Employee>(`${this.apiServerUrl}/employee/add`, employee);
  }

  //change it tpo put<> to update 
  public updateEmployee(employee:Employee):Observable<Employee>{
    return this.http.put<Employee>(`${this.apiServerUrl}/employee/update`, employee);
  }

  //change it tpo delete<> to remove from the database, using void because this isnt returning anything
  public deleteEmployee(employeeId:number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/employee/delete/${employeeId}`);
  }
}
