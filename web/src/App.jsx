import React from 'react'
import UsersTable from './components/userstable/UsersTable'

const App = () => {
  return (
    <>
      <UsersTable users={[
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
      ]}/>
    </>
  )
}

export default App