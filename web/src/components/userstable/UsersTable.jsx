import React from 'react'

import User from '../user/User';
import './userstable.css';

const UsersTable = props => {

  let users = props.users;
  if (props.order === "salary") {
        users.sort((a, b) => a.salary > b.salary ? 1 : -1)
    } else {
        users.sort((a, b) => a.name > b.name ? 1 : -1)
    }

  return (
    <table className="container">
        <thead className='table__head'>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Role</th>
                <th scope="col">Salary</th>
                <th scope="col">Email</th>
            </tr>
        </thead>
        <tbody className='table__body'>
            {users.map((user, index) => {
                return <User key={index} index={index} user={user} />
            })}
        </tbody>
    </table>
  )
}

export default UsersTable