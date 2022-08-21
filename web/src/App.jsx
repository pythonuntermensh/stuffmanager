import React, { useEffect, useState } from 'react'
import UsersTable from './components/userstable/UsersTable'
import Options from './components/options/Options'
import base64 from 'base-64';

const App = () => {
  const [data, setData] = useState();
  const [order, setOrder] = useState("salary");

  const username = "maxprokofievofficial@mail.ru" //TODO: login page
  const password = "alwayswannadrunk"

  useEffect(() => {
    document.title = 'Employees Manager'

    let headers = new Headers();

    headers.set('Authorization', 'Basic ' + base64.encode(username + ":" + password).toString('base64'));

    if (data != null) {
      return
    }
    fetch('http://127.0.0.1:8080/employees/', {method:'GET',
        headers: headers,
       })
    .then(response => response.json())
    .then(data => {
      setData(data)
    }
    
  );});

  if (data) {
    return (
      <section>
        <h2>Management Panel</h2>
        <div className="container table__container">
          <Options setData={setData} setOrder={setOrder} />
          <UsersTable users={data} order={order} />
        </div>
      </section>
    )
  } else {
    return (<div>Loading...</div>)
  }
  
}

export default App

/*
[
        
        {name: 'John', role: 'admin', salary: '$1000', email: 'fsa@bom'},
        {name: 'Jane', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'Joe', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'Jack', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'John', role: 'admin', salary: '$1000', email: 'fsa@bom'},
        {name: 'Jane', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'Joe', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'Jack', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'John', role: 'admin', salary: '$1000', email: 'fsa@bom'},
        {name: 'Jane', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'Joe', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'Jack', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'Jane', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'Joe', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'Jack', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'John', role: 'admin', salary: '$1000', email: 'fsa@bom'},
        {name: 'Jane', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'Joe', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'Jack', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'John', role: 'admin', salary: '$1000', email: 'fsa@bom'},
        {name: 'Jane', role: 'user', salary: '$500', email: 'fsa@bom'},
        {name: 'Joe', role: 'user', salary: '$500', email: 'fsa@bom'},
      ]
*/