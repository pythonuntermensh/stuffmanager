import React, { useState } from 'react'
import './options.css';
import base64 from 'base-64';

const username = "maxprokofievofficial@mail.ru" //TODO: login page
const password = "alwayswannadrunk"

const Options = props => {

    const [values, setValue] = useState();

    const onChange = event => {
        setValue({
            ...values,
            [event.target.name]: event.target.value
        });
    };

    const filterEmployee = (e) => {
        e.preventDefault();
    
        let headers = new Headers();
        headers.set('Authorization', 'Basic ' + base64.encode(username + ":" + password).toString('base64'));
    
        let url = 'http://127.0.0.1:8080/employees?name=' + e.target.name.value + '&role=' + e.target.role.value + '&email=' + e.target.email.value;
        console.log(url);
        fetch(url, {method:'GET',
            headers: headers,
           })
        .then(response => response.json())
        .then(data => {
          props.setData(data);
          console.log(data);
          return data;
        });
    }

    const newEmployee = (e) => {
        e.preventDefault();

        let headers = new Headers();
        headers.set('Authorization', 'Basic ' + base64.encode(username + ":" + password).toString('base64'));
        
        let url = 'http://127.0.0.1:8080/employees/new?name=' + e.target.name.value + '&role=' + e.target.role.value + '&salary=' + e.target.salary.value + '&email=' + e.target.email.value + '&password=' + e.target.password.value
        fetch(url, {method:'GET',
            headers: headers,
           })
        
    }

  return (
    <div className="options__container">
        <label>Sort by:</label>
        <select id="order">
            <option defaultValue={""}>Id</option>
            <option>Name</option>
            <option>Role</option>
            <option>Salary</option>
        </select>
        
        <div className="form__container">
            <label>Filter:</label>
            <form id="filterButton" onSubmit={(e) => props.setData(filterEmployee(e))} >
                <div className="form-row">
                    <label>Name</label>
                    <input name="name" type="text" placeholder="Name" onChange={onChange} />
                </div>
                <div className="form-row">
                    <label>Email</label>
                    <input name="email" type="email" placeholder='Email' onChange={onChange} />
                </div>
                <div className="form-row">
                    <label >Role</label>
                    <select name="role" onChange={onChange}>
                        <option defaultValue={""}></option>
                        <option>CEO</option>
                        <option>CTO</option>
                        <option>MANAGER</option>
                        <option>ACCOUNTANT</option>
                        <option>CLEANER</option>
                        <option>SECURITYGUARD</option>
                    </select>
                </div>
                <button type="submit" className="btn btn-primary">Accept</button>
            </form>
        </div>

        <div className="form__container">
            <label>New Employee</label>
            <form id="createButton" onSubmit={newEmployee}>
                <div className="form-row">
                    <label>Name</label>
                    <input name="name" type="text" placeholder="Name" onChange={onChange} />
                </div>
                <div className="form-row">
                    <label>Salary</label>
                    <input name="salary" type="number" min="0" step="1000" placeholder='Salary' onChange={onChange} />
                </div>
                <div className="form-row">
                    <label>Role</label>
                    <select name="role" onChange={onChange} >
                        <option defaultValue={""}>CEO</option>
                        <option>CTO</option>
                        <option>MANAGER</option>
                        <option>ACCOUNTANT</option>
                        <option>CLEANER</option>
                        <option>SECURITYGUARD</option>
                    </select>
                </div>
                <div className="form-row">
                    <label>Email</label>
                    <input type="email" placeholder="Email" name="email" onChange={onChange} />
                </div>
                <div className="form-row">
                    <label>Password</label>
                    <input type="password" placeholder="Password" name="password" onChange={onChange} />
                </div>
                <button type="submit" className="btn btn-primary">Create</button>
            </form>
        </div>
    </div>
  )
}

export default Options