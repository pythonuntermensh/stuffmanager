import React from 'react'

import User from '../user/User';
import Options from '../options/Options';
import './userstable.css';

const UsersTable = props => {
  return (
    <section>
        <h2>Management Panel</h2>
        <div className="container table__container">
            <Options />
            
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
                    {props.users.map((user, index) => {
                        return <User key={index} index={index} user={user} />
                    })}
                </tbody>
            </table>
        </div>
    </section>
  )
}

export default UsersTable